package com.alura.foro.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alura.foro.model.Topico;
import com.alura.foro.repository.TopicoRepository;


@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public List<Topico> obtenerTodosLosTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico crearTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico actualizarTopico(Long id, Topico nuevoTopico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if (topicoExistente.isPresent()) {
            Topico topicoActual = topicoExistente.get();
            topicoActual.setTitulo(nuevoTopico.getTitulo());
            topicoActual.setContenido(nuevoTopico.getContenido());
            // Actualiza otros campos si es necesario

            return topicoRepository.save(topicoActual);
        } else {
            throw new RuntimeException("No se encontró el tópico con ID " + id);
        }
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}