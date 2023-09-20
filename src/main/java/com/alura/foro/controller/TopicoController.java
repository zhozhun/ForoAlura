package com.alura.foro.controller;

import com.alura.foro.model.Topico;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    private final TopicoService topicoService;
    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoController(TopicoService topicoService, TopicoRepository topicoRepository) {
        this.topicoService = topicoService;
        this.topicoRepository = topicoRepository;
    }

    @GetMapping
    public List<Topico> obtenerTodosLosTopicos() {
        return topicoService.obtenerTodosLosTopicos();
    }

    @GetMapping("/{id}")
    public Topico obtenerTopicoPorId(@PathVariable Long id) {
        return topicoService.obtenerTopicoPorId(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el tópico con ID " + id));
    }

    @PostMapping
    public ResponseEntity<?> crearTopico(@Valid @RequestBody Topico topico) {
        if (topicoRepository.existsByTituloAndContenido(topico.getTitulo(), topico.getContenido())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El tópico ya existe.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoService.crearTopico(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topico) {
        // Verificar si el tópico con el ID dado existe
        boolean existeTopico = topicoRepository.existsById(id);

        if (!existeTopico) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tópico con ID " + id + " no existe.");
        }

        // Verificar duplicados
        if (topicoRepository.existsByTituloAndContenido(topico.getTitulo(), topico.getContenido())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El tópico ya existe.");
        }

        // Actualizar el tópico existente o crear uno nuevo
        Topico t = topicoService.actualizarTopico(id, topico);

        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        // Verificar si el tópico con el ID dado existe
        boolean existeTopico = topicoRepository.existsById(id);

        if (!existeTopico) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tópico con ID " + id + " no existe.");
        }

        // Eliminar el tópico
        topicoService.eliminarTopico(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}