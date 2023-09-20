package com.alura.foro.service;

import com.alura.foro.model.Respuesta;
import com.alura.foro.model.Topico;
import com.alura.foro.repository.RespuestaRepository;
import com.alura.foro.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;

    @Autowired
    public RespuestaService(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
    }

    public List<Respuesta> obtenerTodasLasRespuestas() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> obtenerRespuestaPorId(Long id) {
        return respuestaRepository.findById(id);
    }

    public Respuesta crearRespuesta(Respuesta respuesta, Long topicoId) {
        Optional<Topico> topicoOptional = topicoRepository.findById(topicoId);
        
        if (topicoOptional.isPresent()) {
            respuesta.setTopic(topicoOptional.get());
            return respuestaRepository.save(respuesta);
        } else {
            throw new RuntimeException("No se encontró el tópico con ID " + topicoId);
        }
    }

    public void actualizarRespuesta(Respuesta respuesta) {
        respuestaRepository.save(respuesta);
    }

    public void eliminarRespuesta(Long id) {
        respuestaRepository.deleteById(id);
    }
}
