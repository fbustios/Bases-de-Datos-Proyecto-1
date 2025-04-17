package com.example.proyectobd;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentificationController {


    //aunque aqui deberia mostrar todas las observaciones, para elegir uno y ya ahi hace el post
    @PostMapping("home/helpIdentify")
    public void addIdentification(@RequestParam String algo){

    }
}
