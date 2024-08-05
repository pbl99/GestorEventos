package com.palmen.gestion.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	
	@GetMapping("/register")
	public String registro() {
		return "register";
	}
}
