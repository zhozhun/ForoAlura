package com.alura.foro.service;

import com.alura.foro.model.Usuario;
import com.alura.foro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuarioActual = usuarioExistente.get();
            usuarioActual.setNombreDeUsuario(nuevoUsuario.getNombreDeUsuario());
            usuarioActual.setEmail(nuevoUsuario.getEmail());
            // Actualiza otros campos si es necesario

            return usuarioRepository.save(usuarioActual);
        } else {
            throw new RuntimeException("No se encontró el usuario con ID " + id);
        }
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}