package com.alura.foro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.foro.modelo.Respuesta;
import com.alura.foro.repositorio.RespuestaInterfaceRepositorio;
import com.alura.foro.services.dto.RespuestaDTO;

@Service
public class RespuestaService {
	
	
	private RespuestaInterfaceRepositorio respuestaInterfaceRepositorio;
	
	@Autowired
	public RespuestaService(RespuestaInterfaceRepositorio respuestaInterfaceRepositorio) {
		this.respuestaInterfaceRepositorio = respuestaInterfaceRepositorio;
	}
	
	public Respuesta crearRespuesta(Respuesta respuesta) {
		return respuestaInterfaceRepositorio.save(respuesta);
	}
	
	public List<Object[]> listarRespuesta(){
		return respuestaInterfaceRepositorio.findByActivoTrue();
	}
	
	public void eliminarRespuesta(Long id) {
		respuestaInterfaceRepositorio.eliminarRespuesta(id);
	}
	
	public void modificarRespuesta(Respuesta respuesta) {
		respuestaInterfaceRepositorio.save(respuesta);
	}
	
	public RespuestaDTO buscarRespuesta(Long id){
		Respuesta respuesta = respuestaInterfaceRepositorio.findByIdAndActivoTrue(id);
		
		RespuestaDTO respuestaDTO = new RespuestaDTO(respuesta.getMensaje(), 
				respuesta.getFechaCreacion(), respuesta.getSolucion(), 
				respuesta.getAutor(), respuesta.getTopico());
		
		return respuestaDTO;
	}

}
