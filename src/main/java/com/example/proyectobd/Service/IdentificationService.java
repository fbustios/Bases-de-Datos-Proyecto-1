package com.example.proyectobd.Service;

import com.example.proyectobd.Model.Identification;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Model.Taxon;
import com.example.proyectobd.Model.User;
import com.example.proyectobd.Repositories.IdentificationRepository;
import com.example.proyectobd.Repositories.ObservationRepository;
import com.example.proyectobd.Repositories.TaxonRepository;
import com.example.proyectobd.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class IdentificationService {
    private final ObservationRepository observationRepository;
    private final IdentificationRepository identificationRepository;
    private final TaxonRepository taxonRepository;
    IdentificationService(ObservationRepository or, IdentificationRepository ir, TaxonRepository tr){
        this.observationRepository = or;
        this.identificationRepository = ir;
        this.taxonRepository = tr;
    }

    public List<Observacion> getAllObservations(){
        return observationRepository.findAll();
    }

    public void reportIdentification(Identification ide){
        ide.getUser().addIdentificacion(ide);
        ide.getObservacion().addIdentification(ide);
        identificationRepository.save(ide);
    }
    public Identification getIdentificationById(Long id){
        return identificationRepository.findById(id).get();   //nunca deberia de dar nulo
    }

    @Transactional
    public void updateIdentification(Identification id, LocalDate fecha, String taxon){
        if(fecha != null){
            id.setFecha(fecha);
        }
        Taxon tax = taxonRepository.getTaxonByNombre(taxon);
        if(tax != null){
            id.setTaxon(tax);
        }
        identificationRepository.save(id);
    }
    @Transactional
    public void deleteIdentification(Identification id){
        id.getObservacion().getIdentifications().remove(id);
        identificationRepository.delete(id);

    }

}
