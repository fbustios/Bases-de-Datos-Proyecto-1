package com.example.proyectobd.Service;

import com.example.proyectobd.Model.*;
import com.example.proyectobd.Repositories.ImageRepository;
import com.example.proyectobd.Repositories.ObservationRepository;
import com.example.proyectobd.Repositories.TaxonRepository;
import com.example.proyectobd.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class ObservationService {
    private final UserRepository userRepository;
    private final TaxonRepository taxonRepository;
    private final ImageRepository imageRepository;
    private final ObservationRepository observationRepository;
    ObservationService(UserRepository ur, TaxonRepository tr, ImageRepository ir, ObservationRepository or){
        this.userRepository = ur;
        this.taxonRepository = tr;
        this.imageRepository = ir;
        this.observationRepository = or;
    }
    public User findUserByFullName(String fullName){
        String[] name = fullName.split(" ");
        return userRepository.getUserByNombreAndPrimeroAndSegundo(name[0],name[1],name[2]);
    }

    public Taxon findTaxonByName(String nombre){
        return taxonRepository.getTaxonByNombre(nombre);
    }

    public void addObservation(Observacion obs){
        try{
            observationRepository.save(obs);
        } catch(RuntimeException e){
            System.out.println();
        }
    }

    public Image addImage(MultipartFile imagen, User user, Taxon tax, String longitud, String latitud, LocalDate fecha) {
        Image img = null;
        try {
            String url = UUID.randomUUID() + imagen.getOriginalFilename();
            Path path = Paths.get("src/main/resources/static/imagenes/" + url);
            Files.copy(imagen.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            img = new Image(user, tax, longitud, latitud, fecha, "no se aun", url, user);
            imageRepository.save(img);
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return img;
    }

    public void reportObservation(MultipartFile imagen, User user, Taxon tax, LocalDate fecha, String longitud, String latitud, String comentario){
        Image img = addImage(imagen,user,tax,longitud,latitud,fecha);
        Observacion nuevaObservacion = new Observacion(latitud,longitud,user,fecha,tax,img,comentario);
        user.addObservacion(nuevaObservacion);
        user.addImage(img);
        addObservation(nuevaObservacion);
    }

    @Transactional
    public void updateObservation(MultipartFile imagen, User user, String tax, LocalDate fecha, String longitud, String latitud, String comentario, Observacion obs){

        if(!Objects.equals(comentario, "")) obs.setComentario(comentario);
        if(fecha != null) obs.setFecha(fecha);
        if(!Objects.equals(longitud,"")) obs.setLongitud(longitud);
        if(!Objects.equals(latitud,"")) obs.setLatitud(latitud);
        Taxon taxon = findTaxonByName(tax);
        if(taxon != null) {
            if(imagen.isEmpty()){
                obs.setTaxon(taxon);
                obs.getImage().setTaxon(taxon);
            }else{
                obs.setTaxon(taxon);
                Image img = addImage(imagen,user,taxon,obs.getLongitud(),obs.getLatitud(),obs.getFecha());
                obs.setImage(img);
            }
        }
        if(taxon == null && !imagen.isEmpty()){
            Image img = addImage(imagen,user,obs.getTaxon(),obs.getLongitud(),obs.getLatitud(),obs.getFecha());
        }

        observationRepository.save(obs);

    }
    public Observacion getObservationByID(Long id){
        return observationRepository.findById(id).get();  //nunca deberia dar nulo, no hace falta chequear
    }
    public List<Observacion> getAllObservations(){
        return observationRepository.findAll();
    }

    public void deleteObservation(Observacion o){
        o.getUser().getObservaciones().remove(o);
        observationRepository.delete(o);

    }
    public List<Taxon> getOrderByID(Taxon actual){
        List<Taxon> Order = new ArrayList<>();
        while(actual!= null){
            Order.add(actual);
            System.out.println(actual.getClass());
            System.out.println(actual.getNombre());
            actual= actual.getPadre();

        }
        return Order;
    }
    public List<TaxonDTO> getBestContributors(){
        List<Object[]> con = userRepository.getBestContributors();
        return con.stream().map(row -> new TaxonDTO(
                ((Number) row[0]).longValue(),
                (String) row[1],
                (String) row[2],
                (String) row[3]
        )).toList();
    }
}
