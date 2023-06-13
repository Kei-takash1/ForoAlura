package com.alura.foro.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.repository.NoRepositoryBean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Topico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String mensaje;
	
	@NotBlank
	private String curso;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion = LocalDateTime.now().toString();
	
	@Column(name = "estatus_topico")
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	
	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Usuario usuario;
	
	@JsonBackReference
	  public Usuario getUsuario(){
	    return usuario;
	  }
	
	private Long activo;
	
}
