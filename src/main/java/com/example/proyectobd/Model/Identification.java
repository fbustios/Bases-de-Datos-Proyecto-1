package com.example.proyectobd.Model;


import jakarta.persistence.*;

@Entity
@Table(schema = "reportes")
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

}
