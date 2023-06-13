package com.alura.foro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.alura.foro.modelo.Respuesta;

public interface RespuestaInterfaceRepositorio extends JpaRepository<Respuesta, Long>{
	
//	@Query("SELECT r.mensaje, r.solucion, u.nombre, t.titulo, t.mensaje "
//			+ "FROM Respuesta r "
//			+ "INNER JOIN Usuario u ON r.autor = u.id "
//			+ "INNER JOIN Topico t ON r.topico = t.id "
//			+ "WHERE r.activo = 1")
	List<Respuesta> findByActivoTrue();
	
	@Modifying
	@Query("UPDATE Respuesta SET activo = 0 WHERE id = ?1")
	void eliminarRespuesta(Long id);

	
	Respuesta findByIdAndActivoTrue(Long id);

}
