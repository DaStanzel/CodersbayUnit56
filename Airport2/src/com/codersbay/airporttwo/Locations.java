package com.codersbay.airporttwo;

public class Locations {
	String zip;
	String city;
	String country;
	String timezone;
	
	public Locations() {
		
	}
	
	public Locations(String zip, String city, String country, String timezone) {
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.timezone = timezone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	

}
