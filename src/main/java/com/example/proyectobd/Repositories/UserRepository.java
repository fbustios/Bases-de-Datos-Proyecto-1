package com.example.proyectobd.Repositories;


import com.example.proyectobd.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByNombreAndPrimeroAndSegundo(String nombre, String apellido, String apellido2);
}
