package com.palmen.gestion.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.palmen.gestion.eventos.models.Evento;
import com.palmen.gestion.eventos.models.Usuario;
import com.palmen.gestion.eventos.services.IEventoService;
import com.palmen.gestion.eventos.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/eventos")
public class EventoController {

	@Autowired
	private IEventoService eventoService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/eventos")
	public String eventos(Evento evento, HttpSession session, Model model) {
		String usuarioEmail = (String) session.getAttribute("usuario");
		if (usuarioEmail != null) {
			Usuario usuario = usuarioService.findByEmail(usuarioEmail).orElse(null);
			model.addAttribute("usuario", usuario);

			List<Evento> eventos = eventoService.findByUsuarioId(usuario.getId());
			model.addAttribute("eventos", eventos);
		}
		return "eventos";
	}

	@PostMapping("/crearEvento")
	public String crearEvento(@RequestParam("usuarioEmail") String usuarioEmail, Evento evento) {

		Usuario usuario = usuarioService.findByEmail(usuarioEmail).orElse(null);

		if (usuario != null) {
			evento.setUsuario(usuario);
			eventoService.save(evento);
		}

		return "redirect:/api/eventos/eventos";
	}

	@DeleteMapping("/eliminar/{id}")
	@ResponseBody
	public ResponseEntity<Void> eliminarEvento(@PathVariable Long id) {
		eventoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Evento> buscarEvento(@PathVariable Long id) {
		Optional<Evento> evento = eventoService.findById(id);
		return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Evento>> buscarEventos() {
		List<Evento> eventos = eventoService.findAll();
		return ResponseEntity.ok(eventos);
	}

}
