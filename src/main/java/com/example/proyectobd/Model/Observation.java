package com.example.proyectobd.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "reportes")
public class Observation {
    @Id
    int id;
}
