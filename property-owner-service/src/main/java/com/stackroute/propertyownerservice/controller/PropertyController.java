package com.stackroute.propertyownerservice.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.propertyownerservice.dto.PropertyDetailsDto;
import com.stackroute.propertyownerservice.exception.SequenceException;
import com.stackroute.propertyownerservice.service.PropertyService;

/**
 * 
 * This is the controller class that carries out various Http operations
 * for the Property Owner Service
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/v1/api")
public class PropertyController {
	
	Logger logger = LoggerFactory.getLogger(PropertyController.class);
	
	@Autowired
	PropertyService propertyService;
	
	/**
	 * addPropertyDetails is POST method that accepts MultipartFile for property image
	 * and propertyDetailsDto for other fields and saves it to the database 
	 * 
	 * @param propertyDetailsDto
	 * @param file
	 * @throws IOException
	 * @throws SequenceException
	 */
	
//	@PostMapping(value = "propertydetails",
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<PropertyDetailsDto> addPropertyDetails(
//			@RequestPart("propertyDetailsDto") PropertyDetailsDto propertyDetailsDto, 
//			@RequestPart("file") MultipartFile file) throws IOException, SequenceException {
//		
//		logger.info("PropertyController :: addPropertyDetails() :: Beginning process to add the Property");
//		return new ResponseEntity<>(propertyService.addProperty(propertyDetailsDto, file), HttpStatus.OK);
//		
//	}
	
//	@PostMapping(value = "propertydetails",
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<PropertyDetailsDto> addPropertyDetails(
//			@ModelAttribute PropertyDetailsDto propertyDetailsDto) throws IOException, SequenceException {
//		
//		logger.info("PropertyController :: addPropertyDetails() :: Beginning process to add the Property");
//		return new ResponseEntity<>(propertyService.addProperty(propertyDetailsDto), HttpStatus.OK);
//		
//	}
	
//	@PostMapping(value = "propertydetails")
//	public ResponseEntity<PropertyDetailsDto> addPropertyDetails(
//			@RequestBody PropertyDetailsDto propertyDetailsDto) throws IOException, SequenceException {
//		
//		logger.info("PropertyController :: addPropertyDetails() :: Beginning process to add the Property");
//		return new ResponseEntity<>(propertyService.addProperty(propertyDetailsDto), HttpStatus.OK);
//		
//	}
	
	/**
	 * getAllProperties is a GET method that retrieves all the properties in the database
	 * 
	 */
	
	@GetMapping(value = "properties")
	public ResponseEntity<List<PropertyDetailsDto>> getAllProperties() {
		
		logger.info("PropertyController :: getAllProperties() :: Beginning process to retrieve all the Properties");
		logger.info("PropertyController :: getAllProperties() :: Beginning process to retrieve all the Properties :{}", propertyService.getAllProperties().toString()); 
		return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
	}
	
	/**
	 * showProperty is a GET method that retrieves the property details of a property with the particular id
	 * 
	 * @param id
	 */
	
	
	@GetMapping(value = "property/{id}")
	public ResponseEntity<PropertyDetailsDto>  showProperty(@PathVariable long id) {
		
		logger.info("PropertyController :: showProperty() :: Beginning process to retrieve Property with id: {}", id);
		return new ResponseEntity<>(propertyService.showProperty(id), HttpStatus.OK);
		
	}
	
	/**
	 * getPropertiesByLocation is a GET method that retrieves the list of all properties that 
	 * have the particular city in the parameter
	 * 
	 * @param location
	 */
	
	@GetMapping(value = "propertiesBasedOnLocation")
	public ResponseEntity<List<PropertyDetailsDto>> getPropertiesByLocation(@RequestParam String location) {
		
		logger.info("PropertyController :: getPropertiesByLocation() :: "
				+ "Beginning process to retrieve Properties with city: {}", location);
		return new ResponseEntity<>(propertyService.getPropertyByCity(location), HttpStatus.OK);
		
	}
	
	
	/**
	 * updateProperty is a PUT method that updates the details of a particular property
	 * 
	 * @param propertyDetailsDto
	 * @param id
	 * @throws IOException 
	 */
	
	@PutMapping(value = "property/{id}") public
	ResponseEntity<PropertyDetailsDto> updateProperty(
			@RequestPart("propertyDetailsDto") PropertyDetailsDto propertyDetailsDto, 
			@RequestPart("file") MultipartFile file, @PathVariable long id) throws IOException {
		
		logger.info("PropertyController :: updateProperty() :: Beginning process to update Property with id: {}", id); 
		return new ResponseEntity<>(propertyService.updateProperty(propertyDetailsDto, file, id), HttpStatus.OK); 
		
	}
	 
	/**
	 * deleteProperty is a DELETE method that removes a property from the database
	 * 
	 * @param id
	 */
	
	@DeleteMapping(value = "property/{id}")
	public ResponseEntity<String> deletePropertyById(@PathVariable long id) {
		
		logger.info("PropertyController :: deletePropertyById() :: Beginning process to delete Property with id: {}", id); 
		propertyService.deleteProperty(id);
		return new ResponseEntity<>("Property deleted successfully", HttpStatus.OK);
		
	}

}
