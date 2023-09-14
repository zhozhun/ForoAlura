package com.alura.foro.model;

import java.util.Date;

public class Topico {

//	========== campos de clase ==========

	private int id;
	private String titulo;
	private String contenido;
	private Date fechaDeCreacion;

//	========== constructores ==========

	public Topico(int id, String titulo, String contenido, Date fechaDeCreacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fechaDeCreacion = fechaDeCreacion;
	}

//	========== setter & getter ==========

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

}
