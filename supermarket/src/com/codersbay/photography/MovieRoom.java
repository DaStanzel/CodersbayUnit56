package com.codersbay.photography;

import java.time.LocalTime;
//verschiedensten Filmen, Uhrzeiten, einen Kinosaal und einem boolean ob das der Film ausgebucht

public class MovieRoom {
	LocalTime begin;
	String cinema_hall;
	Movie movie[];
	boolean booked_out[];
	/**
	 * @param begin
	 * @param movie
	 * @param cinema_hall
	 * @param booked_out
	 */
	public MovieRoom(LocalTime begin, String cinema_hall, Movie movie[],  boolean booked_out[]) {
		this.begin = begin;
		this.cinema_hall = cinema_hall;
		this.movie = movie;
		this.booked_out = booked_out;
	}
	public LocalTime getBegin() {
		return begin;
	}
	public void setBegin(LocalTime begin) {
		this.begin = begin;
	}
	public String getCinema_hall() {
		return cinema_hall;
	}
	public void setCinema_hall(String cinema_hall) {
		this.cinema_hall = cinema_hall;
	}
	public Movie[] getMovie() {
		return movie;
	}
	public void setMovie(Movie[] movie) {
		this.movie = movie;
	}
	public boolean[] getBooked_out() {
		return booked_out;
	}
	public void setBooked_out(boolean[] booked_out) {
		this.booked_out = booked_out;
	}
	

}
