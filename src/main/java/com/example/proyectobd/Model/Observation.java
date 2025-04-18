package com.example.proyectobd.Model;


import jakarta.persistence.*;

@Entity
@Table
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
