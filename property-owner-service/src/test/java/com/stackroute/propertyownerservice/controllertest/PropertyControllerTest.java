package com.stackroute.propertyownerservice.controllertest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.stackroute.propertyownerservice.controller.PropertyController;
import com.stackroute.propertyownerservice.dto.PropertyDetailsDto;
import com.stackroute.propertyownerservice.exception.PropertyNotFoundException;
import com.stackroute.propertyownerservice.exception.SequenceException;
import com.stackroute.propertyownerservice.model.AccomodationType;
import com.stackroute.propertyownerservice.model.Amenities;
import com.stackroute.propertyownerservice.service.PropertyService;

/**
 * 
 * This is the test class where JUnit test cases are written to check basic
 * Functionality of the Controller class methods
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PropertyControllerTest {
	
	@InjectMocks
	PropertyController propertyController;
	
	@Mock
	Binary binaryData;
	
	@Mock
	PropertyService propertyService;

	/**
	 * testAddProperty tests addProperty method of the Controller class
	 * 
	 * @throws IOException
	 * @throws SequenceException
	 */
	
//	@Test
//	void testAddProperty() throws IOException, SequenceException {
//
//		MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        byte[] data = {1};
//        Amenities amenities = new Amenities();
//        List<Amenities> amenitiesList = new ArrayList<>();
//        amenitiesList.add(amenities);
//        AccomodationType accomodationType = new AccomodationType();
//        List<AccomodationType> accomodationTypes = new ArrayList<>();
//        accomodationTypes.add(accomodationType);
//
//        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
//
//        MockMultipartFile multipartFile = new MockMultipartFile("file.png", data);
//
//        //when(propertyService.addProperty( (PropertyDetailsDto) any(PropertyDetailsDto.class), (MultipartFile) any(MultipartFile.class))).thenReturn(propertyDetailsDto);
//        when(propertyService.addProperty( (PropertyDetailsDto) any(PropertyDetailsDto.class))).thenReturn(propertyDetailsDto);
//        //ResponseEntity<PropertyDetailsDto> responseEntity = propertyController.addPropertyDetails(propertyDetailsDto, multipartFile);
//        ResponseEntity<PropertyDetailsDto> responseEntity = propertyController.addPropertyDetails(propertyDetailsDto);
//        assertEquals(200,responseEntity.getStatusCodeValue());
//	}
	
	/**
	 * testGetAllProperties tests the getAllProperties method of the Controller class
	 */
	
	@Test
	void testGetAllProperties() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        
        List<PropertyDetailsDto> properties = new ArrayList<>();
        properties.add(propertyDetailsDto);
        when(propertyService.getAllProperties()).thenReturn(properties);
        
        ResponseEntity<List<PropertyDetailsDto>> responseEntity = propertyController.getAllProperties();
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}
	
	/**
	 * testShowProperty tests the showProperty method of the Controller class
	 */
	
	@Test
	void testShowProperty() {
		Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        
        List<PropertyDetailsDto> properties = new ArrayList<>();
        properties.add(propertyDetailsDto);
        when(propertyService.getAllProperties()).thenReturn(properties);
        
        ResponseEntity<PropertyDetailsDto> responseEntity = propertyController.showProperty(any(Integer.class));
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}
	
	/**
	 * testGetPropertiesByLocation tests the getPropertiesByLocation method of the Controller Class
	 * 
	 * @throws PropertyNotFoundException
	 */
	
	@Test
	void testGetPropertiesByLocation() throws PropertyNotFoundException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        
        List<PropertyDetailsDto> properties = new ArrayList<>();
        properties.add(propertyDetailsDto);
        when(propertyService.getPropertyByCity(any(String.class))).thenReturn(properties);
        
        ResponseEntity<List<PropertyDetailsDto>> responseEntity = propertyController.getPropertiesByLocation("Pune");
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}
	
	/**
	 * testUpdateProperty tests the updateProperty method of the Controller Class
	 * 
	 * @throws PropertyNotFoundException
	 * @throws IOException 
	 */
	
	@Test
	void testUpdateProperty() throws PropertyNotFoundException, IOException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Amenities amenities = new Amenities();
        List<Amenities> amenitiesList = new ArrayList<>();
        amenitiesList.add(amenities);
        byte[] data = {1}; AccomodationType accomodationType = new AccomodationType();
        List<AccomodationType> accomodationTypes = new ArrayList<>();
        accomodationTypes.add(accomodationType);
        
        PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto(accomodationTypes, null, 3, (float) 1000.0, 3, 0, "Pune", null, binaryData, amenitiesList, null, null);
        MockMultipartFile multipartFile = new MockMultipartFile("file.png", data);
        
        when(propertyService.updateProperty(propertyDetailsDto, multipartFile, 1)).thenReturn(propertyDetailsDto);
        
        ResponseEntity<PropertyDetailsDto> responseEntity = propertyController.updateProperty(propertyDetailsDto, multipartFile,1);
        
        assertEquals(200,responseEntity.getStatusCodeValue());	
	}
	
	/**
	 * testDeleteProperty tests the deleteProperty method of the controller class
	 * 
	 * @throws PropertyNotFoundException
	 */
	
	@Test
	void testDeleteProperty() throws PropertyNotFoundException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
      
        ResponseEntity<String> responseEntity = propertyController.deletePropertyById(1);
        
        assertEquals("Property deleted successfully",responseEntity.getBody());	
	}

}
