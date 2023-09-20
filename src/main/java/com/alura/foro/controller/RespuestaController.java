package com.alura.foro.controller;

import com.alura.foro.model.Respuesta;
import com.alura.foro.repository.RespuestaRepository;
import com.alura.foro.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private RespuestaService respuestaService;

	@Autowired
	public RespuestaController(RespuestaService respuestaService) {
		this.respuestaService = respuestaService;
	}

	@GetMapping
	public List<Respuesta> obtenerTodasLasRespuestas() {
		return respuestaService.obtenerTodasLasRespuestas();
	}

	@GetMapping("/{id}")
	public Respuesta obtenerRespuestaPorId(@PathVariable Long id) {
		return respuestaService.obtenerRespuestaPorId(id)
				.orElseThrow(() -> new RuntimeException("No se encontró la respuesta con ID " + id));
	}

	@PostMapping("/{topicoId}")
	public Respuesta crearRespuesta(@RequestBody Respuesta respuesta, @PathVariable Long topicoId) {
	    return respuestaService.crearRespuesta(respuesta, topicoId);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Respuesta> actualizarRespuesta(@PathVariable Long id, @RequestBody Respuesta respuesta) {
	    // Verifica si existe una respuesta con el ID proporcionado.
	    Optional<Respuesta> respuestaExistenteOptional = respuestaService.obtenerRespuestaPorId(id);

	    if (!respuestaExistenteOptional.isPresent()) {
	        // Maneja el caso en el que no se encuentra la respuesta.
	        return ResponseEntity.notFound().build();
	    }

	    Respuesta respuestaExistente = respuestaExistenteOptional.get();

	    // Actualiza los campos de la respuesta existente con los valores de la respuesta recibida.
	    respuestaExistente.setContenido(respuesta.getContenido());
	    // Actualiza otros campos según sea necesario.

	    // Guarda la respuesta actualizada en el repositorio.
	    respuestaRepository.save(respuestaExistente);

	    return ResponseEntity.ok(respuestaExistente);
	}

	@DeleteMapping("/{id}")
	public void eliminarRespuesta(@PathVariable Long id) {
		respuestaService.eliminarRespuesta(id);
	}
}