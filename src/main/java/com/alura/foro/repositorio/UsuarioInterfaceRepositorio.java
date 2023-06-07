package com.alura.foro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Usuario;

public interface UsuarioInterfaceRepositorio extends JpaRepository<Usuario, Long> {

}
