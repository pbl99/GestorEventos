package com.palmen.gestion.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palmen.gestion.eventos.models.Usuario;
import com.palmen.gestion.eventos.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/login")
	public String login(Usuario usuario) {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes redirectAttributes) {

		boolean autenticado = usuarioService.autenticarUsuario(email, password);

		if (autenticado) {
			session.setAttribute("usuario", email); 
			return "redirect:/api/eventos/eventos"; 
		} else {
			redirectAttributes.addFlashAttribute("error", "Credenciales incorrectas");
			return "redirect:/login"; 
		}
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
