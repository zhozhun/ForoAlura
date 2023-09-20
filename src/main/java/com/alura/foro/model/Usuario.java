package com.alura.foro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Usuario {

//	========== campos de clase ==========

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreDeUsuario;
	private String contrasena;
	private String email;
	private Date fechaDeRegistro;

//	========== constructores ==========

	public Usuario() {
		
	}
	
	public Usuario(String nombreDeUsuario, String contrasena, String email, Date fechaDeRegistro) {
//		no es necesario usar el argumento Id, JPA lo hace automáticamente
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;
		this.email = email;
		this.fechaDeRegistro = fechaDeRegistro;
	}

//	========== setter & getter ==========

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(Date fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

}
