package com.stackroute.propertyownerservice.servicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.propertyownerservice.model.AccomodationType;
import com.stackroute.propertyownerservice.model.Amenities;
import com.stackroute.propertyownerservice.model.PropertyDetails;
import com.stackroute.propertyownerservice.repository.PropertyRepository;
import com.stackroute.propertyownerservice.serviceimpl.PropertyServiceImpl;

/**
 * This is the test class where JUnit test cases are written to check basic
 * Functionality of the Controller class methods
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PropertyServiceTest {

	@InjectMocks
	PropertyServiceImpl propertyServiceImpl;
	
	@Mock 
	Binary binaryData;
	
	@Mock
	PropertyRepository propertyRepository;

	@Test
	void testShowProperty() {
		Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities); 
        AccomodationType accomodationType = new AccomodationType(1,"Villa",true);
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetails propertyDetailsObject = new PropertyDetails(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        propertyDetailsObject.setId(1L);
        Optional<PropertyDetails> propertyDetails = Optional.of(propertyDetailsObject);
 
        when(propertyRepository.findById(any(Long.class))).thenReturn(propertyDetails);
        assertEquals("Villa", propertyServiceImpl.showProperty(1L).getAccomodationType().get(0).getType());
	}
	
	@Test
	void testGetALlProperties() {
		
		Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetails propertyDetails = new PropertyDetails(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        
		List<PropertyDetails> properties = new ArrayList<>();
		properties.add(propertyDetails);
		
		when(propertyRepository.findAll()).thenReturn(properties);
		
		assertEquals(1, propertyServiceImpl.getAllProperties().size());
	}
	
	@Test()
	void testGetPropertyByAccomodationType() {
		Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetails propertyDetails1 = new PropertyDetails(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        PropertyDetails propertyDetails2 = new PropertyDetails(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        List<PropertyDetails> propertiDetails = new ArrayList<>();
        propertiDetails.add(propertyDetails1);
        propertiDetails.add(propertyDetails2);
        List<Optional<PropertyDetails>> properties = propertiDetails.stream().map((o) -> Optional.of(o)).collect(Collectors.toList());
		
		when(propertyRepository.findByAccomodationType(any(String.class))).thenReturn(properties);
		assertEquals(2, properties.size());	
		}
	
	@Test()
	void testGetPropertyByLocation() {
		Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        PropertyDetails propertyDetails1 = new PropertyDetails(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        PropertyDetails propertyDetails2 = new PropertyDetails(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        List<PropertyDetails> propertiDetails = new ArrayList<>();
        propertiDetails.add(propertyDetails1);
        propertiDetails.add(propertyDetails2);
        List<Optional<PropertyDetails>> properties = propertiDetails.stream().map((o) -> Optional.of(o)).collect(Collectors.toList());
		
		when(propertyRepository.findByCity(any(String.class))).thenReturn(properties);
		assertEquals(2, properties.size());	
		}

}
