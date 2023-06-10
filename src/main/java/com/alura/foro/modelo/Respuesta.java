package com.alura.foro.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String mensaje;
	
	@Column(name = "fecha_creacion")
	@NotBlank
	private String fechaCreacion = LocalDateTime.now().toString();
	
	@Column(name = "solucion")
	@Enumerated(EnumType.STRING)
	private StatusTopico solucion;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Usuario autor;
	
	@ManyToOne
	@JoinColumn(name = "topico_id")
	private Topico topico;
	
	@Column(name = "activo")
	private Long activo;
}
