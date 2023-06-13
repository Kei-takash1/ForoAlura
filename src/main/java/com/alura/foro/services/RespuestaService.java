package com.alura.foro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.foro.dto.RespuestaDTO;
import com.alura.foro.modelo.Respuesta;
import com.alura.foro.repositorio.RespuestaInterfaceRepositorio;

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
	
	public List<RespuestaDTO> listarRespuesta(){
		return respuestaInterfaceRepositorio.findByActivoTrue()
				.stream()
				.map(this::converEntityToDTO)
				.collect(Collectors.toList());
	}
	
	private RespuestaDTO converEntityToDTO(Respuesta respuesta) {
		RespuestaDTO respuestaDTO = new RespuestaDTO();
		respuestaDTO.setMensaje(respuesta.getMensaje());
		respuestaDTO.setFechaCreacion(respuesta.getFechaCreacion());
		respuestaDTO.setSolucion(respuesta.getSolucion());
		respuestaDTO.setAutor(respuesta.getAutor().getNombre());
		respuestaDTO.setTopico(respuesta.getTopico().getTitulo());
		return respuestaDTO;
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
				respuesta.getAutor().getNombre(), respuesta.getTopico().getTitulo());
		
		return respuestaDTO;
	}

}
