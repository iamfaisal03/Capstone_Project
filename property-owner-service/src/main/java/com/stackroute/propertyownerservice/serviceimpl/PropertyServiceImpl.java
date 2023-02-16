package com.stackroute.propertyownerservice.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.propertyownerservice.dto.PropertyDetailsDto;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.exception.SequenceException;
import com.stackroute.propertyownerservice.model.PropertyDetails;
import com.stackroute.propertyownerservice.repository.PropertyRepository;
import com.stackroute.propertyownerservice.service.SequenceGeneratorService;
import com.stackroute.propertyownerservice.service.PropertyService;

/**
 * This is the Service Implementation class that implements business logic
 *
 */

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
	
	/**
	 * addProperty method adds a Property to the database
	 * 
	 * @param propertyDetailsDto
	 * @param file
	 * @return propertyDetailsDto
	 * @throws IOException
	 * @throws SequenceException
	 */
	
//	@Override
//	public PropertyDetailsDto addProperty(
//			PropertyDetailsDto propertyDetailsDto, MultipartFile file) throws IOException, SequenceException {
//		PropertyDetails propertyDetails = new PropertyDetails();
//		propertyDetails.setId(sequenceGeneratorService.generateSequence(PropertyDetails.SEQUENCE_NAME));
//		logger.info("Start :: ProprtyService :: addProperty() :: Adding Property with id : {}", propertyDetails.getId());
//		propertyDetails.setPropertyName(propertyDetailsDto.getPropertyName());
//		propertyDetails.setAccomodationType(propertyDetailsDto.getAccomodationType());
//		propertyDetails.setNumberOfRooms(propertyDetailsDto.getNumberOfRooms());
//		propertyDetails.setPricePerNight(propertyDetailsDto.getPricePerNight());
//		propertyDetails.setOfferPrice(propertyDetailsDto.getOfferPrice());
//		propertyDetails.setOfferPercentage(propertyDetailsDto.getOfferPercentage());
//		propertyDetails.setCity(propertyDetailsDto.getCity());
//		propertyDetails.setAddress(propertyDetailsDto.getAddress());
//		propertyDetails.setPropertyImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
//		propertyDetails.setAmenities(propertyDetailsDto.getAmenities());
//		propertyDetails.setCheckInFeatures(propertyDetailsDto.getCheckInFeatures());
//		propertyDetails.setPropertyCollections(propertyDetailsDto.getPropertyCollections());
//		propertyRepository.save(propertyDetails);
//		propertyDetailsDto.setPropertyImage(propertyDetails.getPropertyImage());
//		propertyDetailsDto.setId(propertyDetails.getId());
//		logger.info("End :: ProprtyService :: addProperty() :: Added Property with id : {}", propertyDetails.getId());
//		return propertyDetailsDto;
//	}
	
	@Override
	public PropertyDetailsDto addProperty(
			PropertyDetailsDto propertyDetailsDto) throws IOException, SequenceException {
		PropertyDetails propertyDetails = new PropertyDetails();
		propertyDetails.setId(sequenceGeneratorService.generateSequence(PropertyDetails.SEQUENCE_NAME));
		logger.info("Start :: ProprtyService :: addProperty() :: Adding Property with id : {}", propertyDetails.getId());
		propertyDetails.setPropertyName(propertyDetailsDto.getPropertyName());
		propertyDetails.setAccomodationType(propertyDetailsDto.getAccomodationType());
		propertyDetails.setNumberOfRooms(propertyDetailsDto.getNumberOfRooms());
		propertyDetails.setPricePerNight(propertyDetailsDto.getPricePerNight());
		propertyDetails.setOfferPrice(propertyDetailsDto.getOfferPrice());
		propertyDetails.setOfferPercentage(propertyDetailsDto.getOfferPercentage());
		propertyDetails.setCity(propertyDetailsDto.getCity());
		propertyDetails.setAddress(propertyDetailsDto.getAddress());
		//propertyDetails.setPropertyImage(new Binary(BsonBinarySubType.BINARY, propertyDetailsDto.getPropertyImage().getData()));
		propertyDetails.setAmenities(propertyDetailsDto.getAmenities());
		propertyDetails.setCheckInFeatures(propertyDetailsDto.getCheckInFeatures());
		propertyDetails.setPropertyCollections(propertyDetailsDto.getPropertyCollections());
		propertyRepository.save(propertyDetails);
		propertyDetailsDto.setPropertyImage(propertyDetails.getPropertyImage());
		propertyDetailsDto.setId(propertyDetails.getId());
		logger.info("End :: ProprtyService :: addProperty() :: Added Property with id : {}", propertyDetails.getId());
		return propertyDetailsDto;
	}
	
	/**
	 * getAllProperties retrieves all the Properties in the database
	 * 
	 * @return properties
	 */
	
	@Override
	public List<PropertyDetailsDto> getAllProperties() {
		List<PropertyDetailsDto> properties = new ArrayList<>();
		List<PropertyDetails> propertyFromDb = propertyRepository.findAll();
		logger.info("Start :: PropertyService :: getAllProperties :: Retrieving all the properties");
		
		for(PropertyDetails property : propertyFromDb) {
			PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
			propertyDetailsDto.setId(property.getId());
			propertyDetailsDto.setPropertyName(property.getPropertyName());
			propertyDetailsDto.setAccomodationType(property.getAccomodationType());
			propertyDetailsDto.setNumberOfRooms(property.getNumberOfRooms());
			propertyDetailsDto.setCity(property.getCity());
			propertyDetailsDto.setAddress(property.getAddress());
			propertyDetailsDto.setPricePerNight(property.getPricePerNight());
			propertyDetailsDto.setOfferPrice(property.getOfferPrice());
			propertyDetailsDto.setOfferPercentage(property.getOfferPercentage());
			propertyDetailsDto.setPropertyImage(property.getPropertyImage());
			propertyDetailsDto.setAmenities(property.getAmenities());
			propertyDetailsDto.setCheckInFeatures(property.getCheckInFeatures());
			propertyDetailsDto.setPropertyCollections(property.getPropertyCollections());
			properties.add(propertyDetailsDto);
		}
		
		logger.info("End :: PropertyService :: getAllProperties :: Retrieved all the properties");
		return properties;
	}

	/**
	 * showProperty takes propertyId as input and retrieves the property Details
	 * 
	 * @param propertyId
	 * @return PropertyDetailsDto
	 */
	
	@Override
	public PropertyDetailsDto showProperty(long id) {
		PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
		Optional<PropertyDetails> propertyOptionalObject = propertyRepository.findById(id);
		if(propertyOptionalObject.isPresent()) {
			PropertyDetails property = propertyOptionalObject.get();
			propertyDetailsDto.setId(property.getId());
			propertyDetailsDto.setPropertyName(property.getPropertyName());
			propertyDetailsDto.setAccomodationType(property.getAccomodationType());
			propertyDetailsDto.setNumberOfRooms(property.getNumberOfRooms());
			propertyDetailsDto.setCity(property.getCity());
			propertyDetailsDto.setAddress(property.getAddress());
			propertyDetailsDto.setPricePerNight(property.getPricePerNight());
			propertyDetailsDto.setOfferPrice(property.getOfferPrice());
			propertyDetailsDto.setOfferPercentage(property.getOfferPercentage());
			propertyDetailsDto.setPropertyImage(property.getPropertyImage());
			propertyDetailsDto.setAmenities(property.getAmenities());
			propertyDetailsDto.setCheckInFeatures(property.getCheckInFeatures());
			propertyDetailsDto.setPropertyCollections(property.getPropertyCollections());
		} else {
			logger.error("PropertyNotFoundException :: PropertyService :: showProperty() ::"
					+ "No Property found with this id");
			throw new PropertyNotFoundException("SERVICE.PROPERTY_NOT_FOUND");
		}
		return propertyDetailsDto;
	}

	/**
	 * getPropertyByLocation takes location as input parameter and
	 * retrieves the Properties that are in that location
	 * 
	 * @param location
	 * @return propertyDetailsResult
	 * @throws PropertyNotFoundException
	 */
	
	@Override
	public List<PropertyDetailsDto> getPropertyByCity(String location) {
		logger.info("Start :: PropertyService :: getPropertyByAccomodationType :: "
				+ "Retrieving Property with location: {}", location);
		List<PropertyDetailsDto> propertyDetailsResult = new ArrayList<>();
		List<Optional<PropertyDetails>> propertyDetailsFromDb = propertyRepository.findByCity(location);
		if(!propertyDetailsFromDb.isEmpty()) {
			for(Optional<PropertyDetails> propertyDetailDto : propertyDetailsFromDb) {
				
				if(!propertyDetailDto.isEmpty()) {
					PropertyDetails propertyDetails = propertyDetailDto.get();
					PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
					propertyDetailsDto.setId(propertyDetails.getId());
					propertyDetailsDto.setPropertyName(propertyDetails.getPropertyName());
					propertyDetailsDto.setAccomodationType(propertyDetails.getAccomodationType());
					propertyDetailsDto.setNumberOfRooms(propertyDetails.getNumberOfRooms());
					propertyDetailsDto.setPricePerNight(propertyDetails.getPricePerNight());
					propertyDetailsDto.setOfferPrice(propertyDetails.getOfferPrice());
					propertyDetailsDto.setOfferPercentage(propertyDetails.getOfferPercentage());
					propertyDetailsDto.setCity(propertyDetails.getCity());
					propertyDetailsDto.setAddress(propertyDetails.getAddress());
					propertyDetailsDto.setPropertyImage(propertyDetails.getPropertyImage());
					propertyDetailsDto.setAmenities(propertyDetails.getAmenities());
					propertyDetailsDto.setCheckInFeatures(propertyDetails.getCheckInFeatures());
					propertyDetailsDto.setPropertyCollections(propertyDetails.getPropertyCollections());
					propertyDetailsResult.add(propertyDetailsDto);
				}
			}
		} else {
			logger.error("PropertyNotFoundException :: PropertytService :: "
					+ "getPropertyByLocation() :: No Properties found with this location!");
			throw new PropertyNotFoundException("SERVICE.PROPERTY_NOT_FOUND");
		}
		
		logger.info("End :: PropertyService :: getPropertyByAccomodationType :: "
				+ "Retrieved Property with location: {}", location);
		return propertyDetailsResult;
	}

	/**
	 * updateProperty takes propertyDetailsDto with updated values and updates the
	 * propertyDetails for the id passed as parameter
	 * 
	 * @param propertyDetailsDto
	 * @param propertyId
	 * @return PropertyDetailsDto
	 * @throws IOException 
	 * @throws PropertyNotFoundException
	 */
	
	@Override
	public PropertyDetailsDto updateProperty(
			PropertyDetailsDto propertyDetailsDto, MultipartFile file, long id) throws IOException {
		logger.info("Start :: PropertyService :: updateProperty :: Updating property with id: {}", id);
		Optional<PropertyDetails> propertyFromDb = propertyRepository.findById(id);
		if(propertyFromDb.isPresent()) {
			PropertyDetails propertyFromRepo = propertyFromDb.get();
			propertyFromRepo.setPropertyName(propertyDetailsDto.getPropertyName());
			propertyFromRepo.setAccomodationType(propertyDetailsDto.getAccomodationType());
			propertyFromRepo.setNumberOfRooms(propertyDetailsDto.getNumberOfRooms());
			propertyFromRepo.setPricePerNight(propertyDetailsDto.getPricePerNight());
			propertyFromRepo.setOfferPrice(propertyDetailsDto.getOfferPrice());
			propertyFromRepo.setCity(propertyDetailsDto.getCity());
			propertyFromRepo.setAddress(propertyDetailsDto.getAddress());
			propertyFromRepo.setOfferPercentage(propertyDetailsDto.getOfferPercentage());
			propertyFromRepo.setPropertyImage(propertyDetailsDto.getPropertyImage());
			propertyFromRepo.setAmenities(propertyDetailsDto.getAmenities());
			propertyFromRepo.setCheckInFeatures(propertyDetailsDto.getCheckInFeatures());
			propertyFromRepo.setPropertyImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
			propertyFromRepo.setPropertyCollections(propertyDetailsDto.getPropertyCollections());
			propertyRepository.save(propertyFromRepo);
			propertyDetailsDto.setId(propertyFromRepo.getId());
			propertyDetailsDto.setPropertyImage(propertyFromRepo.getPropertyImage());
		} else {
			logger.error("PropertyNotFoundException :: PropertyService :: deleteProperty :: Property Not Found!");
			throw new PropertyNotFoundException("SERVICE.PROPERTY_NOT_FOUND");
		}
		logger.info("End :: PropertyService :: updateProperty :: Updated property with id: {}", id);
		return propertyDetailsDto;
	}

	/**
	 * deleteProperty takes id as Input Paramater and deletes the corresponding property 
	 * from the database
	 * 
	 * @param porpertyId
	 * @throws PropertyNotFoundException
	 */
	
	@Override
	public void deleteProperty(long id) {
		logger.info("Start :: PropertyService :: deleteProperty :: Deleting property with id: {}", id);
		if(Boolean.FALSE.equals(propertyRepository.existsById(id))) {
			logger.error("PropertyNotFoundException :: PropertyService :: deleteProperty :: Property Not Found!");
			throw new PropertyNotFoundException("SERVICE.PROPERTY_NOT_FOUND");
		}
		propertyRepository.deleteById(id);
		logger.info("End :: PropertyService :: deleteProperty :: Deleted property");
	}


}
