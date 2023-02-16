package com.stackroute.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingserviceApplication.class, args);
	}

}
