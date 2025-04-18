package com.example.proyectobd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.sql.Date;


@Controller
public class ObservationController {


    @PostMapping("home/reportObservation")
    public String addObservation(@RequestParam("fecha") String fecha,
                                 @RequestParam("taxon") String taxon,
                                 @RequestParam("direccion") String direccion,
                                 @RequestParam("imagen") File imagen){


        return "redirect:/home";
    }

}
