package com.example.proyectobd.Repositories;

import com.example.proyectobd.Model.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface ObservationRepository extends JpaRepository<Observacion,Long> {

}
