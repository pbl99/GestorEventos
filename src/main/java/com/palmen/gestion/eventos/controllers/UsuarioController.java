package com.palmen.gestion.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palmen.gestion.eventos.models.Usuario;
import com.palmen.gestion.eventos.services.IUsuarioService;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/register")
	public String crearUsuario(Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/login";
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		List<Usuario> usuarios = usuarioService.findAll();
		return ResponseEntity.ok(usuarios);
	}
}
