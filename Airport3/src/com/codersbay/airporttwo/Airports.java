package com.codersbay.airporttwo;

public class Airports {
	String IATA;
	Locations location;
	String name;
	
	public Airports() {
		
	}
	
	public Airports(String iATA, Locations location, String name) {
		IATA = iATA;
		this.location = location;
		this.name = name;
	}
	
	public String getIATA() {
		return IATA;
	}
	public void setIATA(String iATA) {
		IATA = iATA;
	}
	public Locations getLocation() {
		return location;
	}
	public void setLocation(Locations location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
