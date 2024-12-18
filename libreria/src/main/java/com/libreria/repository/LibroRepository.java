package com.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
