package com.palmen.gestion.eventos.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.gestion.eventos.models.Evento;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Long> {
	List<Evento> findByUsuarioId(Long id);
	List<Evento> findByDate(LocalDateTime date);
	List<Evento> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
