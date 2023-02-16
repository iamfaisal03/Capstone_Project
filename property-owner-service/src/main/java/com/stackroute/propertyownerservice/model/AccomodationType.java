package com.stackroute.propertyownerservice.model;

/**
* 
* This is the POJO class for the AccommodationType of a particular property
*
*/

public class AccomodationType {
	
	private int id;
	private String type;
	private boolean availability;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public AccomodationType() {
		super();
	}
	public AccomodationType(int id, String type, boolean availability) {
		super();
		this.id = id;
		this.type = type;
		this.availability = availability;
	}

}
