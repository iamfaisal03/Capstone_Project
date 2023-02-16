package com.stackroute.bookingservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.stackroute.bookingservice.dto.BookingDetailsDto;
import com.stackroute.bookingservice.exception.SequenceException;
import com.stackroute.bookingservice.service.BookingService;

@RestController
@RequestMapping("/booking")
@SessionAttributes("reservationDto")
public class BookingController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	BookingService bookingService;
	
	/**
	 * addBookingDetails is POST method that accepts BookingDetailsDto for fields and saves it to the database 
	 */

	@PostMapping(value = "booking/{hotelName}/{accomodationType}/{availableRooms}/{price}")
	public ResponseEntity<BookingDetailsDto> addBookingDetails(@RequestBody BookingDetailsDto bookingDetailsDto,@PathVariable String hotelName,@PathVariable String accomodationType,@PathVariable int availableRooms,@PathVariable float price,HttpSession session) throws IOException, SequenceException  {
		
		logger.info("BookingController :: addBookingDetails() :: Beginning process to add the Booking");
		bookingDetailsDto.setHotelName(hotelName);
		bookingDetailsDto.setAccomodationType(accomodationType);
		bookingDetailsDto.setPrice(price);
		return new ResponseEntity<>(bookingService.addBooking(bookingDetailsDto,hotelName,accomodationType,availableRooms,price), HttpStatus.OK);
		
	}
	
	/**
	 * getAllBookings is a GET method that retrieves all the bookings from the database
	 * 
	 */
	
	@GetMapping(value = "bookings")
	public ResponseEntity<List<BookingDetailsDto>> getAllBookings() {
		
		logger.info("BookingController :: getAllBooking() :: Beginning process to retrieve all the Properties");
		return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
		
	}
	
	/**
	 * showBooking is a GET method that retrieves the booking details of a booking with the particular id
	 * 
	 * @param id
	 */

	@GetMapping(value = "bookingById/{id}")
	public ResponseEntity<BookingDetailsDto>  getBookingsById(@PathVariable long id) {
		
		logger.info("BookingController :: showBooking() :: Beginning process to retrieve booking with id: {}", id);
		return new ResponseEntity<>(bookingService.getBookingsById(id), HttpStatus.OK);
		
	}
	
	/**
	 * getBookingsByHotelName is a GET method that retrieves the list of all bookings with the hotel name as parameter
	 * 
	 * @param accommodationType
	 */
	
	@GetMapping(value = "bookingByHotelName/{hotelName}")
	public ResponseEntity<List<BookingDetailsDto>> getBookingsByHotelName(@PathVariable String hotelName) {
		
		logger.info("BookingController :: getBookingsByHotelName() :: "
				+ "Beginning process to retrieve bookings with Hotel Name: {}", hotelName);
		return new ResponseEntity<>(bookingService.getBookingsByHotelName(hotelName), HttpStatus.OK);
		
	}

	/**
	 * deleteBooking is a DELETE method that removes a booking from the database
	 * 
	 * @param id
	 */

	@DeleteMapping(value = "booking/{id}")
	public ResponseEntity<String> cancelBookingById(@PathVariable long id) {
		
		logger.info("BookingController :: deleteBookingById() :: Beginning process to delete booking with id: {}", id); 
		bookingService.deleteBooking(id);
		return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
		
	}

}

