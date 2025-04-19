package com.example.proyectobd.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "taxon", schema = "modelos")
public class Taxon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "padre_id")
    private Taxon padre;
}
