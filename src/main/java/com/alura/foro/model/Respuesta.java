package com.alura.foro.model;

import java.util.Date;

public class Respuesta {
	
//	========== campos de clase ==========
	private int id;
	private String contenido;
	private Date fechaDeCreacion;
	// Referencia al tópico al que pertenece la respuesta
	private Topico topic;

//	========== constructores ==========
	public Respuesta(int id, String contenido, Date fechaDeCreacion, Topico topic) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.fechaDeCreacion = fechaDeCreacion;
		this.topic = topic;
	}

//	========== setter & getter ==========
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Topico getTopic() {
		return topic;
	}

	public void setTopic(Topico topic) {
		this.topic = topic;
	}

}
