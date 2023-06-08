package com.alura.foro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	public List<Respuesta> listarRespuesta(){
		return respuestaInterfaceRepositorio.findAll();
	}
	
	public void eliminarRespuesta(Long id) {
		respuestaInterfaceRepositorio.deleteById(id);
	}
	
	public void modificarRespuesta(Respuesta respuesta) {
		respuestaInterfaceRepositorio.save(respuesta);
	}
	
	public Respuesta buscarRespuesta(Long id){
		return respuestaInterfaceRepositorio.findById(id).orElse(null);
	}

}
