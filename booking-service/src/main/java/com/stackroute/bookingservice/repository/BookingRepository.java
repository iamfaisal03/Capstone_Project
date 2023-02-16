package com.stackroute.bookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.bookingservice.model.BookingDetails;

/**
 * This is the Repository interface that extends MongoRepository
 * and contains some custom queries
 *
 */

@Repository
public interface BookingRepository extends MongoRepository<BookingDetails, Long>{

	public Optional<BookingDetails> findById(long id);

	public List<Optional<BookingDetails>> findByHotelName(String hotelName);

	void deleteById(long id);

}