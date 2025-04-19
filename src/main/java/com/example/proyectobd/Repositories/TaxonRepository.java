package com.example.proyectobd.Repositories;

import com.example.proyectobd.Model.Taxon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonRepository extends JpaRepository<Taxon,Long> {
    Taxon getTaxonByNombre(String nombre);
}
