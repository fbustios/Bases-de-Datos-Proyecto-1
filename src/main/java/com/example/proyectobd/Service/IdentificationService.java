package com.example.proyectobd.Service;

import com.example.proyectobd.Model.Identification;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Model.User;
import com.example.proyectobd.Repositories.IdentificationRepository;
import com.example.proyectobd.Repositories.ObservationRepository;
import com.example.proyectobd.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IdentificationService {
    private final ObservationRepository observationRepository;
    private final IdentificationRepository identificationRepository;
    IdentificationService(ObservationRepository or, IdentificationRepository ir){
        this.observationRepository = or;
        this.identificationRepository = ir;
    }

    public List<Observacion> getAllObservations(){
        return observationRepository.findAll();
    }

    public void reportIdentification(Identification ide){
        ide.getUser().addIdentificacion(ide);
        ide.getObservacion().addIdentification(ide);
        identificationRepository.save(ide);
    }


}
