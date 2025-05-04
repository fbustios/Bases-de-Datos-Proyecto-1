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




import java.time.LocalDate;

import java.util.List;



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
        try{
            Observacion obs = observationService.getObservationByID(obs_id);
            model.addAttribute("o",obs);
            return "observationEPage";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "redirect:/home/reportObservation/error";
        }

    }

    @PostMapping("home/showAll/editObservation")
    public String editObservation(@RequestParam(name = "nuevo-taxon", required = false) String taxon,
                                @RequestParam(name = "fecha", required = false)@DateTimeFormat(pattern = "dd/mm/yyyy")  LocalDate fecha,
                                @RequestParam(name = "nueva-imagen", required = false) MultipartFile img,
                                @RequestParam(name = "nuevo-comentario", required = false) String comentario,
                                @RequestParam(name = "latitud", required = false) String latitud,
                                  @RequestParam(name = "longitud", required = false) String longitud,
                                @RequestParam("id") Long id){

        Observacion o = observationService.getObservationByID(id);
        try {
            observationService.updateObservation(img, o.getUser(), taxon, fecha,longitud,latitud,comentario,o);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }


        return "redirect:/home/showAll";
    }

    //1 consulta
    @GetMapping("home/showAllObservationsC")
    public String consulta(Model model){
        model.addAttribute("observaciones",observationService.getAllObservations());
        model.addAttribute("Si",3);
        return "identificationPage";
    }

    @GetMapping("home/showAllObservationsC/see")
    public String seeObservation(@RequestParam("id") Long id, Model model){
        Observacion selected = observationService.getObservationByID(id);
        model.addAttribute("obs_id",selected.getId());
        model.addAttribute("taxon",selected.getTaxon().getNombre());
        model.addAttribute("url",selected.getImage().getUrl());
        model.addAttribute("Si",3);
        model.addAttribute("o",selected);
        List<Taxon> order = observationService.getOrderByID(observationService.getObservationByID(id).getTaxon());
        int size = order.size();
        Taxon dom = order.get(size-1);
        model.addAttribute("Dominio",dom.getNombre());
        if(size > 1) model.addAttribute("Reino",order.get(size-2).getNombre());
        else model.addAttribute("Reino","");

        return "searchResult";
    }
    @PostMapping("/home")
    public String deleteObservation(@RequestParam("id") Long id){
        observationService.deleteObservation(observationService.getObservationByID(id));
        return "redirect:home/showAll";
    }

    @GetMapping("home/showAllObservationsOrder")
    public String consultOrder(Model model){
        model.addAttribute("observaciones",observationService.getAllObservations());
        model.addAttribute("Si",4);
        return "identificationPage";
    }
    @GetMapping("home/showAllObservationsOrder/seeOrder")
    public String seeOrder(Model model, @RequestParam("id") Long id){
        List<Taxon> order = observationService.getOrderByID(observationService.getObservationByID(id).getTaxon());
        model.addAttribute("url",observationService.getObservationByID(id).getImage().getUrl());
        model.addAttribute("order",order);
        model.addAttribute("Si",4);
        return "searchResult";
    }

    @GetMapping("home/showBestContributors")
    public String consult(Model model){
        model.addAttribute("cont",observationService.getBestContributors());
        return "reportePropuesto";
    }
}
