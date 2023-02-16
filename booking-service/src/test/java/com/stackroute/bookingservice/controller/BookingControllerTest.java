package com.stackroute.bookingservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.stackroute.bookingservice.dto.BookingDetailsDto;
import com.stackroute.bookingservice.exception.BookingNotFoundException;
import com.stackroute.bookingservice.exception.SequenceException;
import com.stackroute.bookingservice.service.BookingService;



/**
 * 
 * This is the test class where JUnit test cases are written to check basic
 * Functionality of the Controller class methods
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BookingControllerTest {

	@InjectMocks
	BookingController bookingController;
	
	@Mock
	BookingService bookingService;

	/**
	 * testAddBooking tests addBooking method of the Controller class
	 * @param String 
	 * 
	 * @throws IOException
	 * @throws SequenceException
	 */
	
	@Test
	void testAddBooking() throws IOException, SequenceException {

		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        LocalDate date1 = LocalDate.parse("2022-03-29");
        
        LocalDate date2 = LocalDate.parse("2022-03-30");

        
        BookingDetailsDto bookingDetailsDto = new BookingDetailsDto("Hilton","classic",2,date1,date2,5,2,1,(float)1500.0,"john","john@gmail.com","9595959595");
                
        //when(bookingService.addBooking( (BookingDetailsDto) any(BookingDetailsDto.class), "Hilton","classic",2,(float)1500.0)).thenReturn(bookingDetailsDto);
        
        ResponseEntity<BookingDetailsDto> responseEntity = bookingController.addBookingDetails(bookingDetailsDto, "Hilton","classic",2,(float)1500.0, null);
        
        assertEquals(200,responseEntity.getStatusCodeValue()); 
        
	}
	
	/**
	 * testGetAllBookings tests getAllBookings method of the Controller class
	 * 
	 */

	
	@Test
	void testGetAllBookings() {
        
		LocalDate date1 = LocalDate.parse("2022-03-29");
        
        LocalDate date2 = LocalDate.parse("2022-03-30");

        BookingDetailsDto bookingDetailsDto = new BookingDetailsDto("Hilton","classic",2,date1,date2,5,2,1,(float)1500.0,"john","john@gmail.com","9595959595");
        
        List<BookingDetailsDto> bookings = new ArrayList<>();
        bookings.add(bookingDetailsDto);
        when(bookingService.getAllBookings()).thenReturn(bookings);
        
        ResponseEntity<List<BookingDetailsDto>> responseEntity = bookingController.getAllBookings();
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}
	
	/**
	 * testShowBookingById tests the showookingById method of the Controller class
	 */
	
	@Test
	void testShowBookingById() {
		
		LocalDate date1 = LocalDate.parse("2022-03-29");
        
        LocalDate date2 = LocalDate.parse("2022-03-30");
        
        BookingDetailsDto bookingDetailsDto = new BookingDetailsDto("Hilton","classic",2,date1,date2,5,2,1,(float)1500.0,"john","john@gmail.com","9595959595");
        
        List<BookingDetailsDto> bookings = new ArrayList<>();
        bookings.add(bookingDetailsDto);
        when(bookingService.getAllBookings()).thenReturn(bookings);
        
        ResponseEntity<BookingDetailsDto> responseEntity = bookingController.getBookingsById(any(Integer.class));
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}
	
	/**
	 * testGetBookingsByHotelName tests the getBookingsByHotelName method of the Controller Class
	 * 
	 * @throws BookingNotFoundException
	 */
	
	@Test
	void testGetBookingsByHotelName() throws BookingNotFoundException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        LocalDate date1 = LocalDate.parse("2022-03-29");
        
        LocalDate date2 = LocalDate.parse("2022-03-30");
        
        BookingDetailsDto bookingDetailsDto = new BookingDetailsDto("Hilton","classic",2,date1,date2,5,2,1,(float)1500.0,"john","john@gmail.com","9595959595");
        
        List<BookingDetailsDto> bookings = new ArrayList<>();
        bookings.add(bookingDetailsDto);
        when(bookingService.getAllBookings()).thenReturn(bookings);
        
        ResponseEntity<List<BookingDetailsDto>> responseEntity = bookingController.getBookingsByHotelName("Hilton");
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}

	/**
	 * testcancelBooking tests the cancelBookingById method of the controller class
	 * 
	 * @throws BookingNotFoundException
	 */
	
	@Test
	void testcancelBooking() throws BookingNotFoundException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
      
        ResponseEntity<String> responseEntity = bookingController.cancelBookingById(1);
        
        assertEquals("Booking cancelled successfully",responseEntity.getBody());	
	}


}
