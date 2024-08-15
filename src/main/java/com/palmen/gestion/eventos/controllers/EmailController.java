package com.palmen.gestion.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palmen.gestion.eventos.models.EmailDTO;
import com.palmen.gestion.eventos.models.Evento;
import com.palmen.gestion.eventos.services.IEmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private IEmailService emailService;

	@PostMapping("/send-email")
	private ResponseEntity<String> sendEmail(@RequestBody EmailDTO email, Evento evento) throws MessagingException {
		emailService.sendEmail(email);
		return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);
	}

}
