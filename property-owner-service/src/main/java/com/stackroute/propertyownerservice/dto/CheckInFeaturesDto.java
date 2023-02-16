package com.stackroute.propertyownerservice.dto;

public class CheckInFeaturesDto {

	private int id;
	private String checkInFeature;
	private boolean availability;
	
	// Getter and Setter Methods
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckInFeature() {
		return checkInFeature;
	}
	public void setCheckInFeature(String checkInFeature) {
		this.checkInFeature = checkInFeature;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	/**
	 * No-Arg Constructor
	 */
	
	public CheckInFeaturesDto() {
		super();
	}
	
	/** Parameterized Constructor
	 * @param id
	 * @param checkInFeature
	 * @param availability
	 */
	public CheckInFeaturesDto(int id, String checkInFeature, boolean availability) {
		super();
		this.id = id;
		this.checkInFeature = checkInFeature;
		this.availability = availability;
	}	

}
