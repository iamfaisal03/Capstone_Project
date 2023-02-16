package com.stackroute.propertyownerservice.model;

/**
 * 
 * This is the POJO class for the Amenities of a particular property
 *
 */

public class Amenities {
	
	private int id;
	private String amenity;
	private boolean available;	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
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
	public Amenities() {
		super();
	}



	/** Parameterized Constructor
	 * @param id
	 * @param amenity
	 * @param availability
	 */
	public Amenities(int id, String amenity, boolean availability) {
		super();
		this.id = id;
		this.amenity = amenity;
		this.available = availability;
	}
	

}
