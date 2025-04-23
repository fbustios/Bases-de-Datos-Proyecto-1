package com.example.proyectobd.Model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "image", schema = "modelos")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "taxon_id")
    private Taxon taxon;

    private String longitud;

    private String latitud;

    private LocalDate fecha;

    private String licencia;

    @ManyToOne
    @JoinColumn(name = "dueño_id")
    private User dueño;

    private String url;

    public Image(){}
    public Image(User us, Taxon taxon, String lon, String lat, LocalDate fec, String licencia, String url, User dueño){
        this.user = us;
        this.taxon = taxon;
        this.fecha = fec;
        this.longitud = lon;
        this.latitud = lat;
        this.licencia = licencia;
        this.url = url;
        this.dueño = dueño;
    }

}
