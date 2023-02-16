package com.stackroute.authenticationservice.services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stackroute.authenticationservice.config.CustomUserDetails;
import com.stackroute.authenticationservice.models.User;
import com.stackroute.authenticationservice.repositories.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOP = userRepo.findByEmail(username);

		if (userOP.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		User user = userOP.get();

		CustomUserDetails userDetails = new CustomUserDetails(user);
		System.out.println(userDetails.getAuthorities());
		return userDetails;

	}

	
	
	


//	public void saveToken(String email, String jwtToken) {
//		Optional<User> findByEmail = userRepo.findByEmail(email);
//		User user = findByEmail.get();
//		User updateUser = new User();
//		updateUser.setEmail(user.getEmail());
//		updateUser.setPassword(user.getPassword());
//		updateUser.setRole(user.getRole());
//		userRepo.save(updateUser);
//		
//	}
	
	
//	public void updatePassword(String email, String newPassword) {
//		Optional<User> userOP = userRepo.findByEmail(email);
//		if(userOP.isEmpty()) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		User user = userOP.get();
//		
//		user.setPassword(newPassword);
//		
//	}

}
