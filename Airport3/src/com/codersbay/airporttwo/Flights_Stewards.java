package com.codersbay.airporttwo;

import com.codersbay.airporttwo.Employees;

public class Flights_Stewards {
	Employees employee;
	Flights flight;

	public Flights_Stewards() {
	}

	public Flights_Stewards(Employees employee, Flights flight) {
		this.employee = employee;
		this.flight = flight;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	
}
