package com.example.proyectobd.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "observacion", schema = "reportes")
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String latitud;

    private String longitud;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "taxon_id")
    private Taxon taxon;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "observacion", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Identification> identifications = new ArrayList<>();

    private String comentario;

    public Observacion(){}

    public Observacion(String lat, String lon, User us, LocalDate fecha, Taxon tax, Image im, String comentario){
        this.latitud = lat;
        this.longitud = lon;
        this.user = us;
        this.fecha = fecha;
        this.taxon = tax;
        this.image = im;
        this.comentario = comentario;
    }
    public void addIdentification(Identification identification){
        identifications.add(identification);
    }
}