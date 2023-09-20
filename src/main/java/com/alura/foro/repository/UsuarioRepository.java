package com.alura.foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.foro.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByNombre(String nombreDeUsuario);
}
