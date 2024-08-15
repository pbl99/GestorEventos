package com.palmen.gestion.eventos.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.palmen.gestion.eventos.models.Evento;

public interface IEventoService {

	void save(Evento evento);

	void deleteById(Long id);

	Optional<Evento> findById(Long id);

	List<Evento> findAll();

	List<Evento> findByUsuarioId(Long id);
	
	List<Evento> findByDate(LocalDateTime date);
	
	List<Evento> findEventosInNextHour(LocalDateTime start, LocalDateTime end);
}
