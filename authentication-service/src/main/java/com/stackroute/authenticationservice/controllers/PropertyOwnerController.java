package com.stackroute.authenticationservice.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class PropertyOwnerController {

	@PreAuthorize("hasRole('OWNER')")
	@GetMapping("/u2")
	public String home() {
		return ("<h1>Welcome owner<h1>");
	}
	
}