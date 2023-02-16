package com.stackroute.authenticationservice.rabbitconfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.authenticationservice.models.User;
import com.stackroute.authenticationservice.models.UserDto;
import com.stackroute.authenticationservice.repositories.UserRepository;



@Component
public class Consumer {

	@Autowired
	UserRepository userRepo;
	
	@RabbitListener(queues = "auth_queue")
	public void consumeUserDetails(UserDto userDto) {
		System.out.println(userDto.toString());
		User user = new User();
        user.setEmail(userDto.getEmailId());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getUserRole());
        userRepo.save(user);
		
	}
	
}
