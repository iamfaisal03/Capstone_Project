package com.globallogic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.config.Producer;
import com.globallogic.config.UserDto;
import com.globallogic.models.Guest;
import com.globallogic.mongodb.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	Producer producer;
	
	@Autowired
	public GuestServiceImpl (GuestRepository guestRepository) {
		this.guestRepository=guestRepository;
		
	}
	//To save or Create Guest Profile.
	@Override
	public Guest createProfile(Guest guest) {
		
		
		guest.setGuestEmail(guest.getGuestEmail());
		guest.setGuestPassword(guest.getGuestPassword());
		
		UserDto userDto =new UserDto();
		userDto.setEmailId(guest.getGuestEmail());
		userDto.setPassword(guest.getGuestPassword());
		userDto.setUserRole(guest.getUserRole());
		producer.sendMessageToConsumer(userDto);
		return guestRepository.save(guest);
	}
	//To find guest email id 
	@Override
	public Optional<Guest> findById(String guestEmail) {
		return guestRepository.findById(guestEmail);
	}
	//Guest can update Profile 
	@Override
	public Guest updateProfile(Guest guest, String guestEmail) {
		return guestRepository.save(guest);
	}
	//To get all lists of Guests
	@Override
	public List<Guest> getAllGuests() {
		return guestRepository.findAll();
	}
	//To delete user profile 
	@Override
	public void deleteProfileById(String guestEmail) {
		if(!guestRepository.existsById(guestEmail)) {
			throw new RuntimeException("GUEST_NOT_FOUND");
			
		}
		guestRepository.deleteById(guestEmail);
	}
	
}
	
	


