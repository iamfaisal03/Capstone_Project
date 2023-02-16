package com.stackroute.bookingservice.service;

import java.io.IOException;
import java.util.List;

import com.stackroute.bookingservice.dto.BookingDetailsDto;
import com.stackroute.bookingservice.exception.SequenceException;

/**
 * 
 * This is the Service interface with business logic methods which are implemented in 
 * BookingServiceImpl class
 *
 */


public interface BookingService {

	public BookingDetailsDto addBooking(BookingDetailsDto bookingDetailsDto,String hotelName,String accomodationType,int availableRooms,float price) throws IOException, SequenceException;

	public List<BookingDetailsDto> getAllBookings();
	
	public BookingDetailsDto getBookingsById(long bookingId);

	public List<BookingDetailsDto> getBookingsByHotelName(String hotelName);

	public void deleteBooking(long bookingId);

}
