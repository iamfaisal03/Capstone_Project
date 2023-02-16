package com.stackroute.authenticationservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.authenticationservice.models.User;




public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	public Optional<User> findByEmail(String email);
	
	
}
