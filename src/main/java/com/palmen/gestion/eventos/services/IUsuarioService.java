package com.palmen.gestion.eventos.services;

import java.util.List;
import java.util.Optional;

import com.palmen.gestion.eventos.models.Usuario;

public interface IUsuarioService {

	void save(Usuario usuario);

	void deleteById(Long id);

	Optional<Usuario> findById(Long id);

	List<Usuario> findAll();

	Optional<Usuario> findByEmail(String email);
	
	boolean autenticarUsuario(String email, String password);
}
