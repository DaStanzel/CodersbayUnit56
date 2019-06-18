package com.codersbay.airporttwo;

public class Employees {
	int personnel_number;
	String first_name;
	String last_name;
	String street;
	String apartment_number;
	Locations location;
	String phonenumber;
	String email;
	
	public Employees(int personnel_number, String first_name, String last_name, String street, String apartment_number,
			Locations location, String phonenumber, String email) {
		this.personnel_number = personnel_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.apartment_number = apartment_number;
		this.location = location;
		this.phonenumber = phonenumber;
		this.email = email;
	}

	public Employees() {
	}

	public int getPersonnel_number() {
		return personnel_number;
	}

	public void setPersonnel_number(int personnel_number) {
		this.personnel_number = personnel_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getApartment_number() {
		return apartment_number;
	}

	public void setApartment_number(String apartment_number) {
		this.apartment_number = apartment_number;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
