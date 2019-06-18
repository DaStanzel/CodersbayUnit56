package com.codersbay.airporttwo;

public class Luggage {
	int id;
	Tickets ticket;
	Luggage_Types type;
	
	public Luggage(int id, Tickets ticket, Luggage_Types type) {
		this.id = id;
		this.ticket = ticket;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tickets getTicket() {
		return ticket;
	}
	public void setTicket(Tickets ticket) {
		this.ticket = ticket;
	}
	public Luggage_Types getType() {
		return type;
	}
	public void setType(Luggage_Types type) {
		this.type = type;
	}

	public Luggage() {
	}
}
