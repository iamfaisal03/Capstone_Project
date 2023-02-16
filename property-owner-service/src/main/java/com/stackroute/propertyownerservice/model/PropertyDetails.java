package com.stackroute.propertyownerservice.model;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * This is the Entity class for property details
 *
 */

@Document(collection = "propertydetails")
public class PropertyDetails {
	
	@Transient
    public static final String SEQUENCE_NAME = "property_sequence";
	
	@Id
	private long id;
	private String propertyName;
	private List<AccomodationType> accomodationType;
	private int numberOfRooms;
	private float pricePerNight;
	private float offerPrice;
	private float offerPercentage;
	private String city;
	private String address;
	private Binary propertyImage;
	private List<Amenities> amenities;
	private List<CheckInFeatures> checkInFeatures;
	private List<PropertyCollections> propertyCollections;
		
	//Getter and Setter Methods
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<AccomodationType> getAccomodationType() {
		return accomodationType;
	}
	public void setAccomodationType(List<AccomodationType> accomodationType) {
		this.accomodationType = accomodationType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public float getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(float pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public float getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(float offerPrice) {
		this.offerPrice = offerPrice;
	}
	public float getOfferPercentage() {
		return offerPercentage;
	}
	public void setOfferPercentage(float offerPercentage) {
		this.offerPercentage = offerPercentage;
	}	 
	public String getCity() {
		return city;	
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Binary getPropertyImage() {
		return propertyImage;
	}
	public void setPropertyImage(Binary propertyImage) {
		this.propertyImage = propertyImage;
	}
	
	public List<Amenities> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenities> amenities) {
		this.amenities = amenities;
	}
	public List<CheckInFeatures> getCheckInFeatures() {
		return checkInFeatures;
	}
	public void setCheckInFeatures(List<CheckInFeatures> checkInFeatures) {
		this.checkInFeatures = checkInFeatures;
	}	
	public List<PropertyCollections> getPropertyCollections() {
		return propertyCollections;
	}
	public void setPropertyCollections(List<PropertyCollections> propertyCollections) {
		this.propertyCollections = propertyCollections;
	}	
	
	// No-Args Constructor

	public PropertyDetails() {
		super();
	}
		
	/**
	 * Parameterized Comstructor
	 * 
	 * @param accomodationType
	 * @param numberOfRooms
	 * @param pricePerNight
	 * @param availableRooms
	 * @param city
	 * @param address
	 * @param propertyImage
	 * @param amenities
	 */
		
	public PropertyDetails(List<AccomodationType> accomodationType, String propertyName, int numberOfRooms, float pricePerNight,
			float offerPrice, float offerPercentage, String address, String city, 
			Binary propertyImage, List<Amenities> amenities, List<CheckInFeatures> checkInFeatures, 
			List<PropertyCollections> propertyCollections) {
		super();
		this.accomodationType = accomodationType;
		this.propertyName = propertyName;
		this.numberOfRooms = numberOfRooms;
		this.pricePerNight = pricePerNight;
		this.offerPrice = offerPrice;
		this.offerPercentage = offerPercentage;
		this.city = city;
		this.address = address;
		this.propertyImage = propertyImage;
		this.amenities = amenities;
		this.checkInFeatures = checkInFeatures;
		this.propertyCollections = propertyCollections;
	}

}
