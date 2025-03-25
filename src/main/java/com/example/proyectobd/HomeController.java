package com.example.proyectobd;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("home")
    public String DisplayHomePage(){
        return "index";
    }

    @GetMapping("search")
    public String SearchResult(@RequestParam String query){
        return "searchResult";
    }

    @GetMapping("home/helpIdentify")
    public String IdentifyDisplay(){
        return "identificationPage";
    }

    @GetMapping("home/reportObservation")
    public String makeObservation(){
        return "observationPage";
    }

}
