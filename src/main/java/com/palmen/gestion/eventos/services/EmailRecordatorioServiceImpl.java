package com.palmen.gestion.eventos.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.palmen.gestion.eventos.models.EmailDTO;
import com.palmen.gestion.eventos.models.Evento;
import com.palmen.gestion.eventos.models.Usuario;

import jakarta.mail.MessagingException;

@Service
public class EmailRecordatorioServiceImpl {

	@Autowired
	private IEventoService eventoService;

	@Autowired
	private IEmailService emailService;

	private Set<Long> eventosNotificados = new HashSet<>();

	@Scheduled(fixedRate = 60000) // Ejecuta cada minuto
	public void enviarRecordatorios() throws MessagingException {
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime unaHoraDesdeAhora = ahora.plusHours(1);

		// Obtener eventos que comienzan entre ahora y una hora desde ahora
		List<Evento> eventosProximos = eventoService.findEventosInNextHour(ahora, unaHoraDesdeAhora);

		for (Evento evento : eventosProximos) {
			if (!eventosNotificados.contains(evento.getId())) {
				Usuario usuario = evento.getUsuario();

				// Crear el mensaje del correo
				String mensaje = String.format(
						"Hola %s,\n\nEste es un recordatorio de que el evento \"%s\" comenzará en una hora, a las %s.\n\nDescripción: %s\n\n¡Te esperamos!",
						usuario.getName(), evento.getName(), evento.getDate().toString(), evento.getDescription());

				EmailDTO email = new EmailDTO();
				email.setDestinatario(usuario.getEmail());
				email.setAsunto("Recordatorio: Evento en una hora");
				email.setMensaje(mensaje);

				emailService.sendEmail(email);

				eventosNotificados.add(evento.getId());
			}
		}
	}
}
