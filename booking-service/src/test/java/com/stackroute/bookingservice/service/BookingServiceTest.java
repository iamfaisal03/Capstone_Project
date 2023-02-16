package com.stackroute.bookingservice.service;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.bookingservice.model.BookingDetails;
import com.stackroute.bookingservice.repository.BookingRepository;
import com.stackroute.bookingservice.serviceimpl.BookingServiceImpl;

/**
 * This is the test class where JUnit test cases are written to check basic
 * Functionality of the Controller class methods
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BookingServiceTest {
	
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;

	
	@Mock
	BookingRepository bookingRepository;

	@Test
	void testGetAllBookings(){
		
		LocalDate date1 = LocalDate.parse("2022-03-29");
        
        LocalDate date2 = LocalDate.parse("2022-03-30");
        
        long numOfDays = (ChronoUnit.DAYS.between(date1,date2))+1;

        BookingDetails bookingDetails = new BookingDetails("Hilton","classic",2,date1,date2,numOfDays,5,2,1,(float)1500.0,"john","john@gmail.com","9595959595");
    	List<BookingDetails> bookings = new ArrayList<>();
		bookings.add(bookingDetails);
		
		when(bookingRepository.findAll()).thenReturn(bookings);
		assertEquals(1, bookingServiceImpl.getAllBookings().size());
	}

	@Test()
	void testBookingsByHotelName() {
		
        LocalDate date1 = LocalDate.parse("2022-03-29");
        
        LocalDate date2 = LocalDate.parse("2022-03-30");
        
        long numOfDays = (ChronoUnit.DAYS.between(date1,date2))+1;

        LocalDate date3 = LocalDate.parse("2022-03-03");
        
        LocalDate date4 = LocalDate.parse("2022-03-09");
        
        long numOfDays2 = (ChronoUnit.DAYS.between(date3,date4))+1;
        BookingDetails bookingDetails1 = new BookingDetails("Hilton","classic",2,date1,date2,numOfDays,5,2,1,(float)1500.0,"john","john@gmail.com","9595959595");
        BookingDetails bookingDetails2 = new BookingDetails("Taj","Double",1,date3,date4,numOfDays2,4,2,2,(float)1500.0,"bob","bob@gmail.com","8765432123");

        List<BookingDetails> bookingDetails = new ArrayList<>();
        bookingDetails.add(bookingDetails1);
        bookingDetails.add(bookingDetails2);
        List<Optional<BookingDetails>> bookings = bookingDetails.stream().map((o) -> Optional.of(o)).collect(Collectors.toList());
		
		when(bookingRepository.findByHotelName(any(String.class))).thenReturn(bookings);
		assertEquals(2, bookings.size());	
		}
	
}


