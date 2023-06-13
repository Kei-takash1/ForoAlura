package com.alura.foro.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.modelo.Topico;
import com.alura.foro.services.TopicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.val;

@RestController
@RequestMapping("/topico")
public class TopicoController {
	
	private TopicoService service;
	
	@Autowired
	public TopicoController(TopicoService service) {
		this.service = service;
	}
	
	@PostMapping
	public Topico crearTopico(@RequestBody @Valid Topico topico){
		return service.crearTopico(topico);
		
	}
	
	@GetMapping
	public List<TopicoDTO> listarTopico(){
		return service.listarTopico();
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public void eliminarTopico(@PathVariable Long id) {
		service.eliminarTopico(id);
	}
	
	@PutMapping
	public void modificarTopico(@RequestBody @Valid Topico topico) {
		service.modificarTopico(topico);
	}
	
	@GetMapping("{id}")
	public Topico buscarTopico(@PathVariable Long id){
		return service.buscarTopico(id);
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
