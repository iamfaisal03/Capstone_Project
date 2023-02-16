package com.stackroute.authenticationservice.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class UserController {

	@PreAuthorize("hasRole('GUEST')")
	@GetMapping("/g")
	public String home() {
		return ("<h1>Welcome guest<h1>");
	}
}
