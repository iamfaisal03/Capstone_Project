package com.globallogic.controllers;

import java.util.List;

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
import com.globallogic.MessageResponse.OwnerMessageResponse;
import com.globallogic.Service.OwnerService;
import com.globallogic.models.Owner;
@CrossOrigin//to prevent CROS Error on website
@RestController
@RequestMapping("/reg")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService=ownerService;
	}
	
	//method to create new owner record in db
	@PostMapping(value = "/owner")
	public ResponseEntity<Owner> createOwnerprofile(@RequestBody Owner owner){
		return new ResponseEntity<Owner>(ownerService.createOwnerprofile(owner),HttpStatus.CREATED);
	}
	
	//method to get owner by emailId
	@GetMapping("/owner/ownerEmail/{ownerEmail}")
	public ResponseEntity<Owner> getOwnerByEmail(@PathVariable("ownerEmail") String ownerEmail) throws ResourceNotFoundException{
		Owner owner=ownerService.findById(ownerEmail).orElseThrow(()->new ResourceNotFoundException
				("Owner is not exists with emailId"+ownerEmail));
		return new ResponseEntity<> (owner,HttpStatus.OK);
	}
	
	//method to update owner details by the emailId
	@PutMapping (value = "/owner/update/ownerEmail/{ownerEmail}")
	public ResponseEntity<Owner> updateOwnerProfile(@RequestBody Owner owner, @PathVariable("ownerEmail") String ownerEmail)
			throws ResourceNotFoundException
	{
		ownerService.findById(ownerEmail).orElseThrow(()->new ResourceNotFoundException("Owner is not exists with emailID"));
		return new ResponseEntity<>(ownerService.updateOwnerprofile(owner, ownerEmail),HttpStatus.CREATED);
		
	}
	@GetMapping("/owner/getAllOwner")
	public ResponseEntity<List<Owner>> getAllOwner(){
		List<Owner> ownerslist=ownerService.getAllOwners();
		return new ResponseEntity<> (ownerslist,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/deleteowner/{ownerEmail}")
	public ResponseEntity<String> deleteProfileById(@PathVariable String ownerEmail) {
		ownerService.deleteProfileById(ownerEmail);
		return new ResponseEntity<String>("Owner deleted successfully", HttpStatus.OK);
	}
}
