package com.stackroute.propertyownerservice.model;

/**
* 
* This is the POJO class for the Amenities of a particular property
*
*/

public class CheckInFeatures {
	
	private int id;
	private String checkInFeature;
	private boolean available;
	
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
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean availability) {
		this.available = availability;
	}
	
	/**
	 * No-Arg Constructor
	 */
	
	public CheckInFeatures() {
		super();
	}
	
	/** Parameterized Constructor
	 * @param id
	 * @param checkInFeature
	 * @param availability
	 */
	public CheckInFeatures(int id, String checkInFeature, boolean availability) {
		super();
		this.id = id;
		this.checkInFeature = checkInFeature;
		this.available = availability;
	}	

}
