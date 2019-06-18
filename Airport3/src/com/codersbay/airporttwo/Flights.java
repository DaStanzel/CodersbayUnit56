package com.codersbay.airporttwo;

import com.codersbay.airporttwo.Employees;

import java.util.Date;

public class Flights {
	int flight_number;
	Date departure;
	int flight_duration;
	Gates departure_gate;
	Gates arrival_gate;
	Employees pilot;
	Employees copilot;
	
	public Flights(int flight_number, Date departure, int flight_duration, Gates departure_gate, Gates arrival_gate,
			Employees pilot, Employees copilot) {
		this.flight_number = flight_number;
		this.departure = departure;
		this.flight_duration = flight_duration;
		this.departure_gate = departure_gate;
		this.arrival_gate = arrival_gate;
		this.pilot = pilot;
		this.copilot = copilot;
	}

	public Flights() {
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public int getFlight_duration() {
		return flight_duration;
	}

	public void setFlight_duration(int flight_duration) {
		this.flight_duration = flight_duration;
	}

	public Gates getDeparture_gate() {
		return departure_gate;
	}

	public void setDeparture_gate(Gates departure_gate) {
		this.departure_gate = departure_gate;
	}

	public Gates getArrival_gate() {
		return arrival_gate;
	}

	public void setArrival_gate(Gates arrival_gate) {
		this.arrival_gate = arrival_gate;
	}

	public Employees getPilot() {
		return pilot;
	}

	public void setPilot(Employees pilot) {
		this.pilot = pilot;
	}

	public Employees getCopilot() {
		return copilot;
	}

	public void setCopilot(Employees copilot) {
		this.copilot = copilot;
	}
	
	
	

}
