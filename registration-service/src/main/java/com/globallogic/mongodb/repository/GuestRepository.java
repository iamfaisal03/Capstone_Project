package com.globallogic.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.globallogic.models.Guest;

public interface GuestRepository extends MongoRepository<Guest, String> {
  

  

  Boolean existsByGuestEmail(String email);

  Optional<Guest> findByGuestEmail(String email);


  Guest save(String user);
  
}
