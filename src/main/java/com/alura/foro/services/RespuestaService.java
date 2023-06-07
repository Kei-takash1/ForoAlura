package com.alura.foro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.foro.controller.TopicoController;
import com.alura.foro.modelo.Respuesta;
import com.alura.foro.modelo.Topico;
import com.alura.foro.repositorio.RespuestaInterfaceRepositorio;
import com.alura.foro.repositorio.TopicoInterfaceRepositorio;

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
		return respuestaInterfaceRepositorio.findByAllRespuesta();
	}
	
	public String eliminarRespuesta(Long id) {
		respuestaInterfaceRepositorio.eliminarRespuesta(id);
		return "Operacion exitosa";
	}
	
	public void modificarRespuesta(Respuesta respuesta) {
		respuestaInterfaceRepositorio.save(respuesta);
	}
	
	public Respuesta buscarRespuesta(Long id){
		return respuestaInterfaceRepositorio.findByIdActivo(id);
	}

}
