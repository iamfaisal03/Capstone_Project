package com.stackroute.bookingservice.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bookingdetails")
public class BookingDetails{

	@Transient
    public static final String SEQUENCE_NAME = "booking_sequence";

	@Id
	private long id;
	
	private String hotelName;
	
	private String accomodationType;
	
	private int availableRooms;
	
	private float price;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
		
	private long numOfDays;
	
	private int numOfRooms;
	
	private int numOfAdults;
	
	private int numOfChild;
		
	private  String guestName;
	
	private String email;
	
	private String mobileNumber;


	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id= id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(String accomodationType) {
		this.accomodationType = accomodationType;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public long getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(long numOfDays) {
		this.numOfDays = numOfDays;
	}
	
	public int getNumOfRooms() {
		return numOfRooms;
	}

	public void setNumOfRooms(int numOfRooms) {
		this.numOfRooms = numOfRooms;
	}

	public int getNumOfAdults() {
		return numOfAdults;
	}

	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
	}

	public int getNumOfChild() {
		return numOfChild;
	}

	public void setNumOfChild(int numOfChild) {
		this.numOfChild = numOfChild;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public BookingDetails(String hotelName,String accomodationType ,int availableRooms,LocalDate checkInDate, LocalDate checkOutDate,long numOfDays, int numOfRooms,
			int numOfAdults, int numOfChild, float price,String guestName, String email, String mobileNumber) {
		super();
		this.hotelName = hotelName;
		this.accomodationType = accomodationType;
		this.availableRooms = availableRooms;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numOfDays = numOfDays;
		this.numOfRooms = numOfRooms;
		this.numOfAdults = numOfAdults;
		this.numOfChild = numOfChild;
		this.price = price;
		this.guestName = guestName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

}
