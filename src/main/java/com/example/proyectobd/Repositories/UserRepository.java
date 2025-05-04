package com.example.proyectobd.Repositories;


import com.example.proyectobd.Model.TaxonDTO;
import com.example.proyectobd.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByNombreAndPrimeroAndSegundo(String nombre, String apellido, String apellido2);

    @Query(
         value = """
            select u.id, u.nombre, u.primer_apellido, t.nombre
            from (
            	select o.user_id, o.taxon_id from reportes.observacion o 
            
            	union all
            
            	select i.user_id, i.taxon_id from reportes.identificacion i
            
            ) as acciones
            inner join modelos.user u on u.id = acciones.user_id
            inner join modelos.taxon t on t.id = acciones.taxon_id
            group by u.id, u.nombre, u.primer_apellido, t.nombre
            having count(*) > 3
            order by count(*) asc
            
         """,
        nativeQuery = true
    )
    List<Object[]> getBestContributors();
}
