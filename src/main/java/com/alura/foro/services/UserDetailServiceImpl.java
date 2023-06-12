package com.alura.foro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alura.foro.modelo.Usuario;
import com.alura.foro.repositorio.UsuarioInterfaceRepositorio;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioInterfaceRepositorio usuarioInterfaceRepositorio;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioInterfaceRepositorio
		.findOneByEmail(email)
		.orElseThrow(() -> new UsernameNotFoundException("Correo no encontrado " + email));
		
		return new UserDetailsImpl(usuario);
	}

}
