package com.example.proyectobd.Service;

import com.example.proyectobd.Model.Image;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Model.Taxon;
import com.example.proyectobd.Model.User;
import com.example.proyectobd.Repositories.ImageRepository;
import com.example.proyectobd.Repositories.ObservationRepository;
import com.example.proyectobd.Repositories.TaxonRepository;
import com.example.proyectobd.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import java.util.List;
import java.util.UUID;

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

    public void updateObservation(MultipartFile imagen, User user, Taxon tax, LocalDate fecha, String longitud, String latitud, String comentario, Observacion obs){
        //falta ver que valores entran no nulos
        Image img = addImage(imagen,user,tax,longitud,latitud,fecha);
        obs.setComentario(comentario);
        obs.setFecha(fecha);
        obs.setLongitud(longitud);
        obs.setLatitud(latitud);
        obs.setImage(img);
        obs.setTaxon(tax);
        observationRepository.save(obs);

    }
    public Observacion getObservationByID(Long id){
        return observationRepository.findById(id).get();  //nunca deberia dar nulo, no hace falta chequear
    }
    public List<Observacion> getAllObservations(){
        return observationRepository.findAll();
    }
}
