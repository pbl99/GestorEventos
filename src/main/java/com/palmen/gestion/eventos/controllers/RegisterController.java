package com.palmen.gestion.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.palmen.gestion.eventos.models.Usuario;

@Controller
public class RegisterController {

	
	@GetMapping("/register")
	public String registro(Usuario usuario) {
		return "register";
	}
}
