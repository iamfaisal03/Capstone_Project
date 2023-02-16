package com.stackroute.authenticationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.authenticationservice.models.AuthRequest;
import com.stackroute.authenticationservice.models.JwtAuthResponse;
import com.stackroute.authenticationservice.services.CustomUserDetailsService;
import com.stackroute.authenticationservice.util.JwtUtil;



@CrossOrigin
@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;

	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
//		try {
			
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
				);
//		}
//		catch(BadCredentialsException e){
//			throw new Exception("Incorrect username or password", e);
//		}
//		
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
		
		final String jwtToken = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtAuthResponse(jwtToken));
	}

	
	
}
