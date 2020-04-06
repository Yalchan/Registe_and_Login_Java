package model;

import java.io.Serializable;

public class Address implements Serializable{
	private String city;
	private String street;
	
	public Address() {
		super();
		this.city = null;
		this.street = null;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
	

}
