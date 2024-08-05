package com.palmen.gestion.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.gestion.eventos.models.Evento;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Long>{

}
