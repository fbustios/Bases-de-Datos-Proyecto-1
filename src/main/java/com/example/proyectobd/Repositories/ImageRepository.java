package com.example.proyectobd.Repositories;

import com.example.proyectobd.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
