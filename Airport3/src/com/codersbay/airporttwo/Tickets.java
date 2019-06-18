package com.codersbay.airporttwo;

import com.codersbay.airporttwo.Classes;
import com.codersbay.airporttwo.Flights;

public class Tickets {
	int boardingpass_number;
	Flights flight;
	int seat_number;
	String passenger_first_name;
	String passenger_second_name;
	String passanger_last_name;
	Classes ticket_class;
	float price;
	
	public Tickets(int boardingpass_number, Flights flight, int seat_number, String passenger_first_name,
				   String passenger_second_name, String passanger_last_name, Classes ticket_class, float price) {
		this.boardingpass_number = boardingpass_number;
		this.flight = flight;
		this.seat_number = seat_number;
		this.passenger_first_name = passenger_first_name;
		this.passenger_second_name = passenger_second_name;
		this.passanger_last_name = passanger_last_name;
		this.ticket_class = ticket_class;
		this.price = price;
	}

	public Tickets() {
	}

	public int getBoardingpass_number() {
		return boardingpass_number;
	}

	public void setBoardingpass_number(int boardingpass_number) {
		this.boardingpass_number = boardingpass_number;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getPassenger_first_name() {
		return passenger_first_name;
	}

	public void setPassenger_first_name(String passenger_first_name) {
		this.passenger_first_name = passenger_first_name;
	}

	public String getPassenger_second_name() {
		return passenger_second_name;
	}

	public void setPassenger_second_name(String passenger_second_name) {
		this.passenger_second_name = passenger_second_name;
	}

	public String getPassanger_last_name() {
		return passanger_last_name;
	}

	public void setPassanger_last_name(String passanger_last_name) {
		this.passanger_last_name = passanger_last_name;
	}

	public Classes getTicket_class() {
		return ticket_class;
	}

	public void setTicket_class(Classes ticket_class) {
		this.ticket_class = ticket_class;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
