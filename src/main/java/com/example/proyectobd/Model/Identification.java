package com.example.proyectobd.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "identificacion", schema = "reportes")
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "observacion_id")
    Observacion observacion;

    @ManyToOne
    @JoinColumn(name = "taxon_id")
    Taxon taxon;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    LocalDate fecha;

    public Identification(){}

    public Identification(User us, Taxon tax, LocalDate fe, Observacion obs){
        this.fecha = fe;
        this.taxon = tax;
        this.user = us;
        this.observacion = obs;
    }

}
