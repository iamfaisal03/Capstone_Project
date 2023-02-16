package com.stackroute.propertyownerservice.model;

public class PropertyCollections {
	
	private int id;
	private String propertyCollection;
	private boolean available;
	
	// Getter and Setter Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPropertyCollection() {
		return propertyCollection;
	}
	public void setPropertyCollection(String propertyCollection) {
		this.propertyCollection = propertyCollection;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	/**
	 * No-Arg Constructor
	 */
	
	public PropertyCollections() {
		super();
	}
	
	/** Parameterized Constructor
	 * 
	 * @param id
	 * @param propertyCollection
	 * @param available
	 */
	
	public PropertyCollections(int id, String propertyCollection, boolean available) {
		super();
		this.id = id;
		this.propertyCollection = propertyCollection;
		this.available = available;
	}

}
