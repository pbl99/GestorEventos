package com.palmen.gestion.eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmen.gestion.eventos.repositories.IEventoRepository;

@Service
public class EventoServiceImpl implements IEventoService{

	@Autowired
	private IEventoRepository eventoRepository;
}
