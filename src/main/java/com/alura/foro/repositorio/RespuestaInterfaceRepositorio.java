package com.alura.foro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.alura.foro.modelo.Respuesta;

public interface RespuestaInterfaceRepositorio extends JpaRepository<Respuesta, Long>{
	
	@Query("SELECT t.id, t.titulo, t.mensaje, r.mensaje, r.solucion, u.nombre AS usuario "
			+ "FROM Respuesta r "
			+ "INNER JOIN Usuario u ON r.autor = u.id "
			+ "INNER JOIN Topico t ON r.topico = t.id "
			+ "WHERE r.activo = 1")
	List<Object[]> findByAllRespuesta();
	
	@Modifying
	@Query("UPDATE Respuesta SET activo = 0 WHERE id = ?1")
	void eliminarRespuesta(Long id);

	@Modifying
	//@Query("SELECT * FROM Respuesta WHERE id = ?1 AND activo = 1")
	Respuesta findByIdActivo(Long id);

}
