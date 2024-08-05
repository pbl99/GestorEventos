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

import com.palmen.gestion.eventos.models.Evento;
import com.palmen.gestion.eventos.services.IEventoService;

@Controller
@RequestMapping("/api/eventos")
public class EventoController {

	@Autowired
	private IEventoService eventoService;

	@GetMapping("/eventos")
	public String eventos() {
		return "eventos";
	}

	@PostMapping("/crearEvento")
	public String crearEvento(Evento evento) {
		eventoService.save(evento);
		return "redirect:/eventos";
	}

	@DeleteMapping("/{id}")
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
