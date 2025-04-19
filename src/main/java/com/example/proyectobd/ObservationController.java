package com.example.proyectobd;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Model.Taxon;
import com.example.proyectobd.Model.User;
import com.example.proyectobd.Repositories.TaxonRepository;
import com.example.proyectobd.Repositories.UserRepository;
import com.example.proyectobd.Service.ObservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;


@Controller
public class ObservationController {


    @PostMapping("home/reportObservation")
    public String addObservation(@RequestParam("usuario") String nombre,
                                 @RequestParam("taxon") String taxon,
                                 @RequestParam("latitud") String latitud,
                                 @RequestParam("longitud") String longitud,
                                 @RequestParam("comentario") String comentario,
                                 @RequestParam("imagen") File imagen,
                                 @RequestParam("fecha") @DateTimeFormat(pattern = "dd/mm/yyyy") LocalDate fecha
                                 ){
        try{
            Observacion nuevaObservacion = new Observacion();
            User user = observationService.findUserByFullName(nombre);
            nuevaObservacion.setUser(user);
            nuevaObservacion.setLatitud(latitud);
            nuevaObservacion.setLongitud(longitud);
            nuevaObservacion.setComentario(comentario);
            nuevaObservacion.setTaxon(observationService.findTaxonByName(taxon));
            nuevaObservacion.setFecha(fecha);
            user.getObservaciones().add(nuevaObservacion);
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/home";
    }

    @GetMapping("home/reportObservation/hola")
    public String metodo(){
        return "hola";
    }
}
