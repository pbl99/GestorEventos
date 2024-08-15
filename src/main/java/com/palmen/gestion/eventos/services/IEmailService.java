package com.palmen.gestion.eventos.services;

import com.palmen.gestion.eventos.models.EmailDTO;

import jakarta.mail.MessagingException;

public interface IEmailService {

	/*void sendEmail(String to, String subject, String body);*/
	void sendEmail(EmailDTO email) throws MessagingException;
}
