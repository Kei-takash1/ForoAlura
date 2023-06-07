package com.alura.foro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.foro.controller.TopicoController;
import com.alura.foro.modelo.Topico;
import com.alura.foro.repositorio.TopicoInterfaceRepositorio;

@Service
public class TopicoService {
	
	
	private TopicoInterfaceRepositorio topicoInterfaceRepositorio;
	
	@Autowired
	public TopicoService(TopicoInterfaceRepositorio topicoInterfaceRepositorio) {
		this.topicoInterfaceRepositorio = topicoInterfaceRepositorio;
	}
	
	public Topico crearTopico(Topico topico) {
		return topicoInterfaceRepositorio.save(topico);
	}
	
	public List<Topico> listarTopico(){
		return topicoInterfaceRepositorio.findAll();
	}
	
	public void eliminarTopico(Long id) {
		topicoInterfaceRepositorio.deleteById(id);
	}
	
	public void modificarTopico(Topico topico) {
		topicoInterfaceRepositorio.save(topico);
	}
	
	public Topico buscarTopico(Long id){
		return topicoInterfaceRepositorio.findById(id).orElse(null);
	}

}
