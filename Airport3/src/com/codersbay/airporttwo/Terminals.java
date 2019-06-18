package com.codersbay.airporttwo;


public class Terminals {
	int terminal_id;
	Airports airport;
	String name;

	public Terminals() {
	}

	public Terminals(int terminal_id, Airports airport, String name) {
	
		this.terminal_id = terminal_id;
		this.airport = airport;
		this.name = name;
	}
	public int getTerminal_id() {
		return terminal_id;
	}
	public void setTerminal_id(int terminal_id) {
		this.terminal_id = terminal_id;
	}
	public Airports getAirport() {
		return airport;
	}
	public void setAirport(Airports airport) {
		this.airport = airport;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
