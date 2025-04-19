package com.example.proyectobd.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany
    List<Observacion> observaciones;

    @OneToMany
    List<Image> imagenes;
}
