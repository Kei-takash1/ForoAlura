package com.alura.foro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.modelo.Topico;

public interface TopicoInterfaceRepositorio extends JpaRepository<Topico, Long>{
	
//	@Query("SELECT t.id, t.titulo, t.mensaje, t.curso, t.fechaCreacion, t.status "
//			+ "FROM Topico t "
//			+ "WHERE t.activo = 1")
	List<Topico> findAllByActivoTrue();
	
	@Modifying
	@Query("UPDATE Topico SET activo = 0 WHERE id = ?1")
	void eliminarTopico(Long id);

}
