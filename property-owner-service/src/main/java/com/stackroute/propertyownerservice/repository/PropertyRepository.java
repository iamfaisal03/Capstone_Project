package com.stackroute.propertyownerservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.propertyownerservice.model.PropertyDetails;

/**
 * This is the Repository interface that extends MongoRepository
 * and contains some custom queries
 *
 */

@Repository
public interface PropertyRepository extends MongoRepository<PropertyDetails, Integer> {
	
	public Optional<PropertyDetails> findById(long id);

	public List<Optional<PropertyDetails>> findByAccomodationType(String accomodationType);
	
	public List<Optional<PropertyDetails>> findByCity(String city);
	
	Boolean existsById(long id);
	
	void deleteById(long id);
}

