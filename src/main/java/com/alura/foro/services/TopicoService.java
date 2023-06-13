package com.alura.foro.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.foro.dto.TopicoDTO;
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
	
	public List<TopicoDTO> listarTopico(){
		return topicoInterfaceRepositorio.findAllByActivoTrue()
				.stream()
				.map(this::converEntityToDTO)
				.collect(Collectors.toList());
	}
	
	private TopicoDTO converEntityToDTO(Topico topico) {
		TopicoDTO topicoDTO = new TopicoDTO();
		topicoDTO.setId(topico.getId());
		topicoDTO.setTitulo(topico.getTitulo());
		topicoDTO.setMensaje(topico.getMensaje());
		topicoDTO.setCurso(topico.getCurso());
		topicoDTO.setFechaCreacion(topico.getFechaCreacion());
		topicoDTO.setStatus(topico.getStatus());
		topicoDTO.setUsuario(topico.getUsuario().getNombre());
		return topicoDTO;
		}
	
	public void eliminarTopico(Long id) {
		topicoInterfaceRepositorio.eliminarTopico(id);
	}
	
	public void modificarTopico(Topico topico) {
		topicoInterfaceRepositorio.save(topico);
	}
	
	public Topico buscarTopico(Long id){
		return topicoInterfaceRepositorio.findById(id).orElse(null);
	}

}
