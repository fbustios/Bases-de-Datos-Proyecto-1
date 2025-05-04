package com.example.proyectobd.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxonDTO {
    private Long id;
    private String nombre;
    private String primer_apellido;
    private String nombre_taxon;

    public TaxonDTO(Long id, String nombre, String pa, String nt){
        this.id = id;
        this.nombre = nombre;
        this.primer_apellido = pa;
        this.nombre_taxon = nt;
    }
}
