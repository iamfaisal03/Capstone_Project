package com.stackroute.propertyownerservice.dto;

/**
 * 
 * This is the dto class for the Amenities of a particular property
 *
 */

public class AmenitiesDto {
	
	private boolean wifi;
	private boolean ac;
	private boolean cctv;
	private boolean tv;
	private boolean swimmingPool;
	
	// Getter and Setter Methods
	
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public boolean isCctv() {
		return cctv;
	}
	public void setCctv(boolean cctv) {
		this.cctv = cctv;
	}
	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	
	//  No-Args Constructor
	
	AmenitiesDto() {
		super();
	}
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param wifi
	 * @param ac
	 * @param cctv
	 * @param tv
	 * @param swimmingPool
	 */
	public AmenitiesDto(boolean wifi, boolean ac, boolean cctv, boolean tv, boolean swimmingPool) {
		super();
		this.wifi = wifi;
		this.ac = ac;
		this.cctv = cctv;
		this.tv = tv;
		this.swimmingPool = swimmingPool;
	}


}
