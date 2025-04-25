package com.example.proyectobd;
import com.example.proyectobd.Model.Image;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Model.Taxon;
import com.example.proyectobd.Model.User;

import com.example.proyectobd.Service.ObservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.time.LocalDate;

import java.util.UUID;


@Controller
public class ObservationController {
    private final ObservationService observationService;

    ObservationController(ObservationService os){
        this.observationService=os;
    }

    @PostMapping("home/reportObservation")
    public String addObservation(@RequestParam("usuario") String nombre,
                                 @RequestParam("taxon") String taxon,
                                 @RequestParam("latitud") String latitud,
                                 @RequestParam("longitud") String longitud,
                                 @RequestParam("comentario") String comentario,
                                 @RequestParam("imagen") MultipartFile imagen,
                                 @RequestParam("fecha") @DateTimeFormat(pattern = "dd/mm/yyyy") LocalDate fecha
                                 ){
        try{
            User user = observationService.findUserByFullName(nombre);
            Taxon tax = observationService.findTaxonByName(taxon);
            observationService.reportObservation(imagen,user,tax,fecha,longitud,latitud,comentario);

        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
            return "redirect:/home/reportObservation/error";
        }


        return "redirect:/home";
    }

    @GetMapping("/home/reportObservation")
    public String makeObservation(){
        return "observationPage";
    }

    @GetMapping("home/reportObservation/error")
    public String metodo(){
        return "UserTaxonNotFound";
    }

    @GetMapping("home/showAll")
    public String showAll(Model model){
        model.addAttribute("Si",0);
        model.addAttribute("observaciones",observationService.getAllObservations());
        return "identificationPage";
    }
    @GetMapping("home/showAll/editObservation")
    public String showObservation(@RequestParam("id") Long obs_id, Model model){
        Observacion obs = observationService.getObservationByID(obs_id);
        model.addAttribute("o",obs);
        return "observationEPage";
    }

    @PostMapping("home/showAll/editObservation")
    public void editObservation(){
        //recibir todos los parametros, los paso todos al service para ahi la logica y ya queda listo solo faltaria probarlo que se cambie
        //las varas bien
    }
}
