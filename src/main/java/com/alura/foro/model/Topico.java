package com.alura.foro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Topico {

//	========== campos de clase ==========

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "El título no puede estar en blanco")
	private String titulo;

	@NotBlank(message = "El contenido no puede estar en blanco")
	private String contenido;
	@NotNull(message = "La fecha de creación no puede ser nula")
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaDeCreacion;
	
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas = new ArrayList<>();

//	========== constructores ==========

	public Topico() {
	}

	public Topico(String titulo, String contenido, Date fechaDeCreacion) {
//		no es necesario usar el argumento Id, JPA lo hace automáticamente
		this.titulo = titulo;
		this.contenido = contenido;
		this.fechaDeCreacion = fechaDeCreacion;
	}

//	========== setter & getter ==========
	
    public void addRespuesta(Respuesta respuesta) {
        respuesta.setTopic(this);
        respuestas.add(respuesta);
    }

    public void removeRespuesta(Respuesta respuesta) {
        respuesta.setTopic(null);
        respuestas.remove(respuesta);
    }
    

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
