package com.globallogic.controllers;

import java.util.List;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.Exceptions.ResourceNotFoundException;
import com.globallogic.Service.GuestService;
import com.globallogic.config.MessageConfig;
import com.globallogic.models.Guest;

@CrossOrigin //to prevent CROS Error on website
@RestController
@RequestMapping("/reg")
public class GuestController {
	
	@Autowired
	RabbitTemplate template;
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	public GuestController(GuestService guestService) {
		this.guestService=guestService;
	}
	
	//method to create new Guest record in db
	@PostMapping(value = "/guest")
	public ResponseEntity<Guest> createProfile(@RequestBody Guest guest){
		template.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.ROUTING_KEY,guest);
		return  new ResponseEntity<>(guestService.createProfile(guest),HttpStatus.CREATED);
	}
	
	
	//method to get guest by emailID
	@GetMapping("/guest/guestEmail/{guestEmail}")
	public ResponseEntity<Guest> getGuestByEmail(@PathVariable ("guestEmail") String guestEmail) throws ResourceNotFoundException{
		Guest guest=guestService.findById(guestEmail).orElseThrow(()->new ResourceNotFoundException
				("Guest is not exists with emailID"+guestEmail) );
		return new ResponseEntity<>(guest,HttpStatus.OK);
	}
	
	
	//method to update Guest details by the emailId
    @PutMapping("/guest/update/guestEmail/{guestEmail}")
    public ResponseEntity<Guest> updateProfile(@RequestBody Guest guest, @PathVariable ("guestEmail") String guestEmail)
            throws ResourceNotFoundException
    {
        guestService.findById(guestEmail).orElseThrow(() -> new ResourceNotFoundException
                ("Guest is not exits with emailID"));        
        return  new ResponseEntity<>(guestService.updateProfile(guest,guestEmail), HttpStatus.CREATED);
    }
    
    
    //method to get all guests
    @GetMapping("/guest/getAllGuest")
    public ResponseEntity<List<Guest>> getAllGuests(){
    	List<Guest> guestlist=guestService.getAllGuests();
    	return new ResponseEntity<List<Guest>>(guestlist,HttpStatus.OK);
    }
    //method to delete guest by email
    @DeleteMapping(value = "/deleteguest/{guestEmail}")
	public ResponseEntity<String> deleteProfileById(@PathVariable String guestEmail) {
		guestService.deleteProfileById(guestEmail);
		return new ResponseEntity<String>("Guest deleted successfully", HttpStatus.OK);
	}
	
}
