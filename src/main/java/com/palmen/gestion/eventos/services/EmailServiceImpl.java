package com.palmen.gestion.eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.palmen.gestion.eventos.models.EmailDTO;

import jakarta.mail.MessagingException;

@Service
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(EmailDTO email) throws MessagingException {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getDestinatario());
			message.setSubject(email.getAsunto());
			message.setText(email.getMensaje());

			mailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException("Error al enviar el correo electrónico: " + e.getMessage());
		}
	}
}
