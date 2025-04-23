package com.example.proyectobd;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Service.IdentificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;


@Controller
public class IdentificationController {
    private final IdentificationService identificationService;

    IdentificationController(IdentificationService is){
        this.identificationService = is;
    }

    //aunque aqui deberia mostrar todas las observaciones, para elegir uno y ya ahi hace el post
    @GetMapping("/home/helpIdentify")
    public String addIdentification(Model model){
        model.addAttribute("observaciones",identificationService.getAllObservations());
        return "identificationPage";
    }

    @GetMapping("/home/helpIdentify/makeId")
    public String showSelectedIdentification(@RequestParam Long id, Model model){
        //pagina para mostrar observacion y identificar
        Observacion selected = identificationService.getObservationByID(id);
        for(Observacion e : selected.getUser().getObservaciones()){
            System.out.println(e.getComentario());
        }
        model.addAttribute("observacion_id",selected.getId());
        model.addAttribute("user_id",selected.getUser().getId());
        model.addAttribute("user",selected.getUser().getNombre());
        model.addAttribute("taxon",selected.getTaxon().getNombre());
        model.addAttribute("url",selected.getImage().getUrl());
        return "searchResult";
    }
    @PostMapping("/home/helpIdentify/makeId")
    public void addIdentification(@RequestParam String Taxon,
                                  @RequestParam LocalDate fecha,
                                  @RequestParam String nombre_usuario){



    }


}
