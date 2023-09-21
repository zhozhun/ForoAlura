package com.alura.foro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Respuesta {
	
//	========== campos de clase ==========
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String contenido;
	private Date fechaDeCreacion;
	// Referencia al tópico al que pertenece la respuesta
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topico topic;

//	========== constructores ==========
	
	public Respuesta() {
		
	}
	
	public Respuesta(String contenido, Date fechaDeCreacion, Topico topic) {
//		no es necesario usar el argumento Id, JPA lo hace automáticamente
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
