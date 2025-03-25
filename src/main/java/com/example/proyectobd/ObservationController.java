package com.example.proyectobd;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ObservationController {


    @PostMapping("home/reportObservation")
    public void addObservation(@RequestParam("nose") String name){

    }
}
