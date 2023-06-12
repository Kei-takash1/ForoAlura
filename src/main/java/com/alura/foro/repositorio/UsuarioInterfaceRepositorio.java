package com.alura.foro.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Usuario;

public interface UsuarioInterfaceRepositorio extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findOneByEmail(String email);

}
