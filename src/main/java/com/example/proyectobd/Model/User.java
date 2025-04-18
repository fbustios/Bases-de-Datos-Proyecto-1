package com.example.proyectobd.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "modelos")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "país")
    private String pais;

    @Column(name = "dirección")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "segundo_apellido")
    private String segundo_apellido;
}
