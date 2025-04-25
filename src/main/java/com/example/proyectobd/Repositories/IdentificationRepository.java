package com.example.proyectobd.Repositories;

import com.example.proyectobd.Model.Identification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification,Long> {
}
