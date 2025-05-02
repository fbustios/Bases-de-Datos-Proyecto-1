package com.example.proyectobd;
import com.example.proyectobd.Model.Identification;
import com.example.proyectobd.Model.Observacion;
import com.example.proyectobd.Service.IdentificationService;
import com.example.proyectobd.Service.ObservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;


@Controller
public class IdentificationController {
    private final IdentificationService identificationService;
    private final ObservationService observationService;

    IdentificationController(IdentificationService is, ObservationService os){
        this.identificationService = is;this.observationService = os;
    }

    //aunque aqui deberia mostrar todas las observaciones, para elegir uno y ya ahi hace el post
    @GetMapping("/home/helpIdentify")
    public String addIdentification(Model model){
        model.addAttribute("Si",1);
        model.addAttribute("observaciones",identificationService.getAllObservations());
        return "identificationPage";
    }

    @GetMapping("/home/helpIdentify/makeId")
    public String showSelectedIdentification(@RequestParam Long id, Model model){
        //pagina para mostrar observacion y identificar
        Observacion selected = observationService.getObservationByID(id);
        for(Observacion e : selected.getUser().getObservaciones()){
            System.out.println(e.getComentario());
        }
        model.addAttribute("obs_id",selected.getId());
        model.addAttribute("taxon",selected.getTaxon().getNombre());
        model.addAttribute("url",selected.getImage().getUrl());
        model.addAttribute("Si",1);

        return "searchResult";
    }
    @PostMapping("/home/helpIdentify/makeId")
    public String addIdentification(@RequestParam(name = "taxon_identificado") String Taxon,
                                  @RequestParam(name = "fecha") LocalDate fecha,
                                  @RequestParam(name = "username") String nombre_usuario,
                                  @RequestParam(name = "obs_id") Long observacion_id)
                                  {
        try {
            Identification identificacion = new Identification(observationService.findUserByFullName(nombre_usuario), observationService.findTaxonByName(Taxon), fecha, observationService.getObservationByID(observacion_id));
            identificationService.reportIdentification(identificacion);
        }catch(RuntimeException e){
            return "redirect:/home/reportObservation/error";
        }
        return "redirect:/home/helpIdentify";
    }

    @GetMapping("/home/helpIdentify/makeId/error")
    public String error(){
        return "UserTaxonNotFound";
    }


    @GetMapping("home/showAll/identifications")
    public String showAllIdentifications(Model model, @RequestParam("id") Long id){

        model.addAttribute("identificaciones",observationService.getObservationByID(id).getIdentifications());
        model.addAttribute("Si",1);
        return "displayIdentifications";
    }

    @GetMapping("home/showAll/editIdentification")
    public String showIdentification(Model model, @RequestParam("id") Long id){
        try {
            model.addAttribute("identificacion", identificationService.getIdentificationById(id));
            return "editIdentification";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:/home/reportObservation/error";
        }

    }

    @PostMapping("home/showAll/editIdentification")
    public String editIdentification(@RequestParam(name = "nuevo-taxon", required = false) String taxon,
                                     @RequestParam(name = "fecha", required = false) LocalDate fecha,
                                     @RequestParam("id") Long id){
        try{
            identificationService.updateIdentification(identificationService.getIdentificationById(id),fecha,taxon);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/home/reportObservation/error";
        }

        return "redirect:/home/showAll";
    }




}
