package com.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.model.Libro;
import com.libreria.repository.LibroRepository;
import com.libreria.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/libri")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Ottieni tutti i libri
    @GetMapping
    public List<Libro> getAllLibri() {
        return libroService.findAll();
    }

    // Crea un nuovo libro
    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        Libro savedLibro = libroService.save(libro);
        return ResponseEntity.status(201).body(savedLibro); // HTTP 201 Created
    }

    // Elimina un libro
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }

}
