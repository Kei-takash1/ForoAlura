package com.alura.foro.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.foro.modelo.Topico;

public interface TopicoInterfaceRepositorio extends JpaRepository<Topico, Long>{

}
