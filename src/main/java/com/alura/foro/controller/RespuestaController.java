package com.alura.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.dto.RespuestaDTO;
import com.alura.foro.modelo.Respuesta;
import com.alura.foro.modelo.Topico;
import com.alura.foro.services.RespuestaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
	
	private RespuestaService service;
	
	@Autowired
	public RespuestaController(RespuestaService service) {
		this.service = service;
	}
	
	@PostMapping
	public Respuesta crearRespuesta(@RequestBody @Valid Respuesta respuesta){
		return service.crearRespuesta(respuesta);
		
	}
	
	@GetMapping
	public List<RespuestaDTO> listarRespuesta(){
		return service.listarRespuesta();
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public void eliminarRespuesta(@PathVariable Long id) {
		service.eliminarRespuesta(id);
	}
	
	@PutMapping
	public void modificarRespuesta(@RequestBody @Valid Respuesta respuesta) {
		service.modificarRespuesta(respuesta);
	}
	
	@GetMapping("{id}")
	public RespuestaDTO buscarRespuesta(@PathVariable Long id){
		return service.buscarRespuesta(id);
	}
	
	/*
	@Autowired
	private UsuarioInterfaceRepositorio usuarioInterfaceRepositorio;
	@GetMapping("/topico")
	public String greeting(Model model) {
		model.addAttribute("usuario", usuarioInterfaceRepositorio.findAll());
		return "holamundo";
	}
	*/

}
