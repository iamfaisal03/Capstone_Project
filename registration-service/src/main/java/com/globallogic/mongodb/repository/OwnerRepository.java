package com.globallogic.mongodb.repository;

import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.models.Owner;
@Repository
public interface OwnerRepository extends MongoRepository<Owner, String> {

	Optional<Owner> save(String ownerEmail);

	

}
