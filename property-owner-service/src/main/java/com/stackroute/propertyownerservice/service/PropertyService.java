package com.stackroute.propertyownerservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stackroute.propertyownerservice.dto.PropertyDetailsDto;
import com.stackroute.propertyownerservice.exception.SequenceException;

/**
 * 
 * This is the Service interface with business logic methods which are implemented in 
 * PropertyServiceImpl class
 *
 */

public interface PropertyService {

	//public PropertyDetailsDto addProperty(PropertyDetailsDto propertyDetailsDto, MultipartFile file) throws IOException, SequenceException;
	public PropertyDetailsDto addProperty(PropertyDetailsDto propertyDetailsDto) throws IOException, SequenceException;
	
	public List<PropertyDetailsDto> getAllProperties();
	
	public PropertyDetailsDto showProperty(long propertyId);
	
	public List<PropertyDetailsDto> getPropertyByCity(String location);
	
	public PropertyDetailsDto updateProperty(PropertyDetailsDto propertyDetailsDto, MultipartFile file,long propertyId) throws IOException;
	
	public void deleteProperty(long porpertyId);

}
