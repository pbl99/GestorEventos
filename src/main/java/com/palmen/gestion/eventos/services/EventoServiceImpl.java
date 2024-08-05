package com.palmen.gestion.eventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmen.gestion.eventos.models.Evento;
import com.palmen.gestion.eventos.repositories.IEventoRepository;

@Service
public class EventoServiceImpl implements IEventoService {

	@Autowired
	private IEventoRepository eventoRepository;

	@Override
	public void save(Evento evento) {
		eventoRepository.save(evento);
	}

	@Override
	public void deleteById(Long id) {
		eventoRepository.deleteById(id);
	}

	@Override
	public Optional<Evento> findById(Long id) {
		return eventoRepository.findById(id);
	}

	@Override
	public List<Evento> findAll() {
		return eventoRepository.findAll();
	}
}
