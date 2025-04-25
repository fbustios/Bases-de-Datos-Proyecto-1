package com.example.proyectobd.Model;

import com.example.proyectobd.IdentificationController;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "modelos")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "primer_apellido")
    private String primero;

    @Column(name = "país")
    private String pais;

    @Column(name = "dirección")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "segundo_apellido")
    private String segundo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Observacion> observaciones = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Image> imagenes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Identification> identifications = new ArrayList<>();

    public void addObservacion(Observacion o) {
        observaciones.add(o);
        o.setUser(this);
    }

    public void addImage(Image img){
        imagenes.add(img);
        img.setUser(this);
    }
    public void addIdentificacion(Identification o) {
        identifications.add(o);
        o.setUser(this);
    }
}
