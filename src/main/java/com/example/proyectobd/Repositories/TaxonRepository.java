package com.example.proyectobd.Repositories;

import com.example.proyectobd.Model.Taxon;
import org.hibernate.annotations.processing.SQL;
import org.springframework.boot.actuate.endpoint.invoke.ParameterValueMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxonRepository extends JpaRepository<Taxon,Long> {


    @Query(
            value = """
            select * from modelos.taxon t where t.nombre = :nombre
            """,
            nativeQuery = true
    )
    Taxon getTaxonByNombre(String nombre);

}
