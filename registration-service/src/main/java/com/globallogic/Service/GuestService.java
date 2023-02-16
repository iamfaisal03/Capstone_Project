package com.globallogic.Service;

import java.util.List;
import java.util.Optional;

import com.globallogic.models.Guest;

public interface GuestService {
	
	Guest createProfile(Guest guest); //Guest will create new profile
	
	Optional<Guest> findById(String guestEmail);//To find guest email id 
	
	Guest updateProfile(Guest guest,String guestEmail);//Guest can update Profile 
	
	List<Guest> getAllGuests(); //To get all lists of Guests
	
	public void deleteProfileById(String guestEmail); //To delete user profile 

}


