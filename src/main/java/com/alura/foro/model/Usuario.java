package com.alura.foro.model;

import java.util.Date;

public class Usuario {

//	========== campos de clase ==========

	private int id;
	private String nombreDeUsuario;
	private String contrasena;
	private String email;
	private Date fechaDeRegistro;

//	========== constructores ==========

	public Usuario(int id, String nombreDeUsuario, String contrasena, String email, Date fechaDeRegistro) {
		super();
		this.id = id;
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
