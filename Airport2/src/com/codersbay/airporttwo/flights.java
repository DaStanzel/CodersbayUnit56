package com.codersbay.airporttwo;

import java.sql.Time;

public class flights {

    private int flight_number;

    private Time departure;
    private int flight_duration;

    private int departure_gate;
    private int arrival_gate;

    private Employees pilot;
    private Employees co_pilot;

    public flights(int flight_number, Time departure, int flight_duration, int departure_gate, int arrival_gate, Employees pilot, Employees co_pilot) {
        this.setFlight_number(flight_number);
        this.setDeparture(departure);
        this.setFlight_duration(flight_duration);
        this.setDeparture_gate(departure_gate);
        this.setArrival_gate(arrival_gate);
        this.setPilot(pilot);
        this.setCo_pilot(co_pilot);
    }

    public flights() {
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public int getFlight_duration() {
        return flight_duration;
    }

    public void setFlight_duration(int flight_duration) {
        this.flight_duration = flight_duration;
    }

    public int getDeparture_gate() {
        return departure_gate;
    }

    public void setDeparture_gate(int departure_gate) {
        this.departure_gate = departure_gate;
    }

    public int getArrival_gate() {
        return arrival_gate;
    }

    public void setArrival_gate(int arrival_gate) {
        this.arrival_gate = arrival_gate;
    }

    public Employees getPilot() {
        return pilot;
    }

    public void setPilot(Employees pilot) {
        this.pilot = pilot;
    }

    public Employees getCo_pilot() {
        return co_pilot;
    }

    public void setCo_pilot(Employees co_pilot) {
        this.co_pilot = co_pilot;
    }
}
