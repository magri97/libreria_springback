package com.libreria.service;

import org.springframework.stereotype.Service;

import com.libreria.model.Libro;
import com.libreria.repository.LibroRepository;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    // Iniezione del repository attraverso il costruttore
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Recupera tutti i libri dal database
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    // Salva o aggiorna un libro
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    // Elimina un libro per ID
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
}