package com.stackroute.emailservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.stackroute.emailservice.controller.MailController;
import com.stackroute.emailservice.model.User;

@Service
public class MailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;
	Logger logger = LoggerFactory.getLogger(MailController.class);
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(User user) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Welcome to Stop-N-Rest");
		mail.setText("Successfully registered with the Stop-N-Rest");

		javaMailSender.send(mail);
		
	}
	
	public void successEmail(User user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Booking Successful");
		mail.setText("Booking Successful with the Stop-N-Rest");

		javaMailSender.send(mail);
		
	}
	
	public void failureEmail(User user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Booking Failed");
		mail.setText("Booking failed with the Stop-N-Rest");

		javaMailSender.send(mail);
		
	}
} 