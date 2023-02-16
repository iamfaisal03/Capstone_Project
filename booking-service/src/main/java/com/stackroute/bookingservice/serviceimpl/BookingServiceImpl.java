package com.stackroute.bookingservice.serviceimpl;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.bookingservice.dto.BookingDetailsDto;
import com.stackroute.bookingservice.exception.BookingNotFoundException;
import com.stackroute.bookingservice.exception.RoomsNotAvailableException;
import com.stackroute.bookingservice.exception.SequenceException;
import com.stackroute.bookingservice.model.BookingDetails;
import com.stackroute.bookingservice.repository.BookingRepository;
import com.stackroute.bookingservice.service.BookingService;
import com.stackroute.bookingservice.service.SequenceGeneratorService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
		Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

		/**
		 * addBooking method adds a Booking to the database
		 * 
		 * @param bookingDetailsDto
		 * @return bookingDetailsDto
		 * @throws IOException
		 * @throws SequenceException
		 */
		
	@Override
	public BookingDetailsDto addBooking(BookingDetailsDto bookingDetailsDto,String hotelName,String accomodationType,int availableRooms,float price) throws IOException, SequenceException  {
		
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setId(sequenceGeneratorService.generateSequence(BookingDetails.SEQUENCE_NAME));
		if(availableRooms!=0) {
		logger.info("Start :: BookingService :: addBooking() :: Adding Booking with id : {} :: for hotel : {}", bookingDetails.getId(),hotelName);
		bookingDetails.setHotelName(hotelName);
		bookingDetails.setAccomodationType(accomodationType);
		bookingDetails.setAvailableRooms(availableRooms-1);
		bookingDetails.setPrice(price);
		bookingDetails.setCheckInDate(bookingDetailsDto.getCheckInDate());
		bookingDetails.setCheckOutDate(bookingDetailsDto.getCheckOutDate());
		bookingDetails.setNumOfDays(ChronoUnit.DAYS.between(bookingDetailsDto.getCheckInDate(),bookingDetailsDto.getCheckOutDate())+1);
		bookingDetails.setNumOfRooms(bookingDetailsDto.getNumOfRooms());
		bookingDetails.setNumOfAdults(bookingDetailsDto.getNumOfAdults());
		bookingDetails.setNumOfChild(bookingDetailsDto.getNumOfChild());
		bookingDetails.setGuestName(bookingDetailsDto.getGuestName());
		bookingDetails.setEmail(bookingDetailsDto.getEmail());
		bookingDetails.setMobileNumber(bookingDetailsDto.getMobileNumber());
		bookingRepository.save(bookingDetails);
		bookingDetailsDto.setId(bookingDetails.getId());
		bookingDetailsDto.setNumOfDays(bookingDetails.getNumOfDays());
		bookingDetailsDto.setAvailableRooms(availableRooms-1);
		logger.info("BookingService :: addBooking() :: Added Booking with id : {}", bookingDetails.getId());
		}
		else {
			logger.error("RoomsNotAvailableException :: BookingService ::No rooms available!");
			throw new RoomsNotAvailableException("ROOMS_NOT_AVAILABLE");
		}
		return bookingDetailsDto;	
	}


	/**
	 * getAllBookings retrieves all the Bookings from the database
	 * 
	 * @return bookings
	 */

	@Override
	public List<BookingDetailsDto> getAllBookings(){
		List<BookingDetailsDto> bookings = new ArrayList<>();
		List<BookingDetails> bookingFromDb = bookingRepository.findAll();
		for(BookingDetails booking : bookingFromDb) {
			BookingDetailsDto bookingDetailsDto = new BookingDetailsDto();
			bookingDetailsDto.setId(booking.getId());
			bookingDetailsDto.setHotelName(booking.getHotelName());
			bookingDetailsDto.setAccomodationType(booking.getAccomodationType());
			bookingDetailsDto.setAvailableRooms(booking.getAvailableRooms());
			bookingDetailsDto.setPrice(booking.getPrice());
			bookingDetailsDto.setCheckInDate(booking.getCheckInDate());
			bookingDetailsDto.setCheckOutDate(booking.getCheckOutDate());
			bookingDetailsDto.setNumOfDays(booking.getNumOfDays());
			bookingDetailsDto.setNumOfRooms(booking.getNumOfRooms());
			bookingDetailsDto.setNumOfAdults(booking.getNumOfAdults());
			bookingDetailsDto.setNumOfChild(booking.getNumOfChild());
			bookingDetailsDto.setGuestName(booking.getGuestName());
			bookingDetailsDto.setEmail(booking.getEmail());
			bookingDetailsDto.setMobileNumber(booking.getMobileNumber());
			bookings.add(bookingDetailsDto);
		}
		
		return bookings;

	}
	
	/**
	 * getBookingsById takes bookingId as input and retrieves the booking Details
	 * 
	 * @param bookingId
	 * @return BookingDetailsDto
	 */

	
	@Override
	public BookingDetailsDto getBookingsById(long id) {
		BookingDetailsDto bookingDetailsDto = new BookingDetailsDto();
		Optional<BookingDetails> bookingOptionalObject = bookingRepository.findById(id);
		if(bookingOptionalObject.isPresent()) {
			BookingDetails booking = bookingOptionalObject.get();
			bookingDetailsDto.setId(booking.getId());
			bookingDetailsDto.setHotelName(booking.getHotelName());
			bookingDetailsDto.setAccomodationType(booking.getAccomodationType());
			bookingDetailsDto.setAvailableRooms(booking.getAvailableRooms());
			bookingDetailsDto.setPrice(booking.getPrice());
			bookingDetailsDto.setCheckInDate(booking.getCheckInDate());
			bookingDetailsDto.setCheckOutDate(booking.getCheckOutDate());
			bookingDetailsDto.setNumOfRooms(booking.getNumOfRooms());
			bookingDetailsDto.setNumOfAdults(booking.getNumOfAdults());
			bookingDetailsDto.setNumOfChild(booking.getNumOfChild());
			bookingDetailsDto.setGuestName(booking.getGuestName());
			bookingDetailsDto.setEmail(booking.getEmail());
			bookingDetailsDto.setMobileNumber(booking.getMobileNumber());
		}
		else {
			logger.error("BookingNotFoundException :: BookingService :: showBooking() ::"+ "No booking found with this id");
			throw new BookingNotFoundException("SERVICE.BOOKING_NOT_FOUND");
		}
		return bookingDetailsDto;
	}
	
	
	/**
	 * getBookingsByHotelName takes hotelName as input parameter and
	 * retrieves the Bookings with that hotel name
	 * 
	 * @param hotelName
	 * @return bookingDetailsResult
	 * @throws BookingNotFoundException
	 */
	
	@Override
	public List<BookingDetailsDto> getBookingsByHotelName(String hotelName) {
		logger.info("Start :: BookingService :: getBookingByHotelName :: "+ "Retrieving Booking with hotel name: {}", hotelName);
		List<BookingDetailsDto> bookingDetailsResult = new ArrayList<>();
		List<Optional<BookingDetails>> bookingDetailsFromDb = bookingRepository.findByHotelName(hotelName);
		if(!bookingDetailsFromDb.isEmpty()) {
			for(Optional<BookingDetails> bookingDetailDto : bookingDetailsFromDb) {
				
				if(!bookingDetailDto.isEmpty()) {
					BookingDetails bookingDetails = bookingDetailDto.get();
					BookingDetailsDto bookingDetailsDto = new BookingDetailsDto();
					bookingDetailsDto.setId(bookingDetails.getId());
					bookingDetailsDto.setHotelName(bookingDetails.getHotelName());
					bookingDetailsDto.setAccomodationType(bookingDetails.getAccomodationType());
					bookingDetailsDto.setAvailableRooms(bookingDetails.getAvailableRooms());
					bookingDetailsDto.setPrice(bookingDetails.getPrice());
					bookingDetailsDto.setCheckInDate(bookingDetails.getCheckInDate());
					bookingDetailsDto.setCheckOutDate(bookingDetails.getCheckOutDate());
					bookingDetailsDto.setNumOfRooms(bookingDetails.getNumOfRooms());
					bookingDetailsDto.setNumOfAdults(bookingDetails.getNumOfAdults());
					bookingDetailsDto.setNumOfChild(bookingDetails.getNumOfChild());
					bookingDetailsDto.setGuestName(bookingDetails.getGuestName());
					bookingDetailsDto.setEmail(bookingDetails.getEmail());
					bookingDetailsDto.setMobileNumber(bookingDetails.getMobileNumber());
					bookingDetailsResult.add(bookingDetailsDto);
				}
			}
		} else {
			logger.error("BookingNotFoundException :: BookingService :: "
					+ "getBookingByHotelName() :: No Bookings found with this Hotel Name!");
			throw new BookingNotFoundException("SERVICE.BOOKING_NOT_FOUND");
		}
		logger.info("End :: BookingService :: getBookingByHotelName :: "+ "Retrieved Booking with HotelName");
		
		return bookingDetailsResult;
	}

	
	/**
	 * deleteBooking takes id as Input Parameter and deletes the corresponding booking
	 * from the database
	 * 
	 * @param bookingId
	 * @throws BookingNotFoundException
	 */


	@Override
	public void deleteBooking(long id) {
		logger.info("Start :: BookingService :: deleteBooking :: Deleting booking with id: {}", id);
		if(Boolean.FALSE.equals(bookingRepository.existsById(id))) {
			logger.error("BookingException :: BookingService :: deleteBooking :: Booking Not Found!");
			throw new BookingNotFoundException("SERVICE.BOOKING_NOT_FOUND");
		}
		bookingRepository.deleteById(id);
		logger.info("End :: BookingService :: deleteBooking :: Deleted booking");	
	}

}
