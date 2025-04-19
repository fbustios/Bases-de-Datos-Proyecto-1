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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        User user = userRepository.getUserByNombreAndPrimeroAndSegundo(name[0],name[1],name[2]);
        return user;
    }

    public Taxon findTaxonByName(String nombre){
        Taxon taxon = taxonRepository.getTaxonByNombre(nombre);
        return taxon;
    }

    public void addObservation(Observacion obs){
        try{
            observationRepository.save(obs);
        } catch(RuntimeException e){
            System.out.println();
        }
    }
    public void deleteObservation(){

    }

    public void addImage(Image img){
        try{
            imageRepository.save(img);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
