package com.globallogic.Service;

import java.util.List;
import java.util.Optional;

import com.globallogic.models.Guest;
import com.globallogic.models.Owner;

public interface OwnerService {
	
	Owner createOwnerprofile(Owner owner);
	
	Optional<Owner> findById(String owneremail);
	
	Owner updateOwnerprofile(Owner owner,String owneremail);
	
	List<Owner> getAllOwners();
	
	public void deleteProfileById(String guestEmail);




}
