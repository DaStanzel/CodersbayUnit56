package com.codersbay.photography;

public class Movie {
	String movieName;
	double duration_per_hour;
	/**
	 * @param movieName
	 * @param duratrion_per_houre
	 */
	public Movie(String movieName, double duration_per_hour) {
		this.movieName = movieName;
		this.duration_per_hour = duration_per_hour;
	}
	public String toString() {
		int dhour=(int)duration_per_hour;
		int dminute=((int)(duration_per_hour*60))%60;
		int dsecound=((int)(duration_per_hour*60*60))%60;
		return "movie:"+movieName+" (duration:"+String.format("%02d:%02d:%02d",dhour,dminute,dsecound)+")";
	}
}
