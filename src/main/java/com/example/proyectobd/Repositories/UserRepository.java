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
            from modelos.user u
            inner join reportes.observacion o on o.user_id = u.id
            inner join reportes.identificacion i on i.user_id = u.id AND i.taxon_id = o.taxon_id
            inner join modelos.taxon t on t.id = o.taxon_id
            group by u.id, u.nombre, u.primer_apellido, t.nombre
            having count(*) > 3
            order by count(*) asc
         """,
        nativeQuery = true
    )
    List<Object[]> getBestContributors();
}
