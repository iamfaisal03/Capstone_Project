package com.stackroute.authenticationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/dashboard")
	public String home() {
		return ("<h1>Welcome to dashboard<h1>");
	}
	
}

