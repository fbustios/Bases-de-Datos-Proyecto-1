package com.example.proyectobd.Service;

import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Repositories.ObservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificationService {
    private final ObservationRepository observationRepository;
    IdentificationService(ObservationRepository or){
        this.observationRepository = or;
    }
    public List<Observacion> getAllObservations(){
        return observationRepository.findAll();
    }
    public Observacion getObservationByID(Long id){
        return observationRepository.findById(id).get();  //nunca deberia dar nulo, no hace falta chequear
    }


}
