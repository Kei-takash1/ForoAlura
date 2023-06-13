package com.alura.foro.dto;

import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TopicoDTO {

	private Long id;
	private String titulo;
	private String mensaje;
	private String curso;
	private String fechaCreacion;
	private StatusTopico status;
	private String usuario;
	
	
	public TopicoDTO() {
		super();
	}


	public TopicoDTO(Long id, String titulo, String mensaje, String curso, String fechaCreacion, StatusTopico status,
			String usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
		this.fechaCreacion = fechaCreacion;
		this.status = status;
		this.usuario = usuario;
	}
	
	
}
