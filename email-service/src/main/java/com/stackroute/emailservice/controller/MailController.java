package com.stackroute.emailservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import com.stackroute.emailservice.model.User;
import com.stackroute.emailservice.service.MailService;

/**
 * This class contains a Mail API developed using Spring Boot
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/mail")
public class MailController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MailService notificationService;

	@PostMapping(value = "send-mail")
	@ResponseBody
	public String sendMail(@RequestBody User user) {

		logger.info("EmailController :: sendingEmail() :: Beginning process to send the mail");

		try {
			notificationService.sendEmail(user);
		}
		catch(MailException mailException) {
			System.out.println(mailException);
		}
		
		return "Congratulations! Your mail has been send to the user.";	
	}
	
	@PostMapping(value = "booking-sucess")
	@ResponseBody
	public String bookingSuccess(@RequestBody User user) {
		
		logger.info("EmailController :: Sending booking success mail");
		notificationService.successEmail(user);
		return "Congratulations! Your Booking is Successful";	
	}
	
	@PostMapping(value = "booking-failed")
	@ResponseBody
	public String bookingFailed(@RequestBody User user) {
		
		logger.info("EmailController :: Sending booking failure mail");
		notificationService.failureEmail(user);
		return "Your Booking is Failed";	
	}
}