package com.alura.foro.dto;

import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class RespuestaDTO {
	
	private String mensaje;
	private String fechaCreacion;
	private StatusTopico solucion;
	private String autor;
	private String topico;
	
	public RespuestaDTO() {
		super();
	}
	public RespuestaDTO(String mensaje, String fechaCreacion, StatusTopico solucion, String autor, String topico) {
		super();
		this.mensaje = mensaje;
		this.fechaCreacion = fechaCreacion;
		this.solucion = solucion;
		this.autor = autor;
		this.topico = topico;
	}
	
}
