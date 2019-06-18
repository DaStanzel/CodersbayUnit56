package com.codersbay.airporttwo;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		CreateDBObjects.createAll(DBConnection.connectDB());
		Scanner sc = new Scanner(System.in);
		enterFlightNumber(sc);
		enterEmployeeNumber(sc);
	}

	/**
	 * Let the user enter a flight-number. Call printFlightDetails if a match is found.
	 *
	 * @param scanner
	 */
	private static void enterFlightNumber(Scanner scanner) {
		System.out.println("Enter a flight number: ");

		Flights f = findFlightByNumber(Integer.valueOf(scanner.next()));

		if (f != null) {
			printFlightDetails(f);
			System.out.println();
		} else {
			System.out.println("Flight not found!");
			System.out.println();
		}
	}

	/**
	 * Let the user enter a employee-number. Call printEmployeeDetails if a match is found.
	 *
	 * @param scanner
	 */
	private static void enterEmployeeNumber(Scanner scanner) {
		System.out.println("Enter an employee-number: ");

		Employees e = findEmployeeByNumber(Integer.valueOf(scanner.next()));

		if (e != null) {
			printEmployeeDetails(e);
			System.out.println();
		} else {
			System.out.println("Employee not found!");
			System.out.println();
		}
	}

	/**
	 * Loop trough all employee objects and try to find a matching personnel_number.
	 *
	 * @param enteredNumber The personnel_number we want to find
	 * @return The found flight (null if none was found)
	 */
	private static Employees findEmployeeByNumber(int enteredNumber) {
		for (int i = 0; i < CreateDBObjects.allEmployees.size(); i++) {
			if (CreateDBObjects.allEmployees.get(i).getPersonnel_number() == enteredNumber) {
				return CreateDBObjects.allEmployees.get(i);
			}
		}
		//return null if no employee was found
		return null;
	}

	/**
	 * Loop trough all flight objects and try to find a matching flight_number.
	 *
	 * @param enteredNumber The flight_number we want to find
	 * @return The found flight (null if none was found)
	 */
	private static Flights findFlightByNumber(int enteredNumber) {
		for (int i = 0; i < CreateDBObjects.allFlights.size(); i++) {
			if (CreateDBObjects.allFlights.get(i).getFlight_number() == enteredNumber) {
				return CreateDBObjects.allFlights.get(i);
			}
		}
		//return null if no flight was found
		return null;
	}

	/**
	 * Print out some info about a certain flight
	 *
	 * @param f The flight object
	 */
	private static void printFlightDetails(Flights f) {
		System.out.println("Flight Number: " + f.getFlight_number());
		System.out.println("Departure Time: " + f.getDeparture());
		System.out.println("Flight Duration: " + f.getFlight_duration());
		System.out.println("Departure Gate: " + f.getDeparture_gate().getName());
		System.out.println("Departure Terminal: " +f.getDeparture_gate().getTerminal().getName());
		System.out.println("Departure Airport: " +f.getDeparture_gate().getTerminal().getAirport().getIATA()+" "+f.getDeparture_gate().getTerminal().getAirport().getName());
		System.out.println("Arrival Gate: " + f.getArrival_gate().getName());
		System.out.println("Arrival Terminal: " +f.getArrival_gate().getTerminal().getName());
		System.out.println("Arrival Airport: " +f.getArrival_gate().getTerminal().getAirport().getIATA()+" "+f.getArrival_gate().getTerminal().getAirport().getName());
		System.out.println();
		System.out.println("Pilot: " + f.getPilot().getFirst_name() + " " + f.getPilot().getLast_name());
		System.out.println("Co-Pilot: " + f.getCopilot().getFirst_name() + " " + f.getCopilot().getLast_name());
	}

	/**
	 * Print out some info about a certain flight
	 *
	 * @param e Employee
	 */
	private static void printEmployeeDetails(Employees e) {

		System.out.println(e.getFirst_name() + " " + e.getLast_name() + " is assigned to the following roles:");

		//Print out flights where he is a pilot.
		System.out.println("---[  Pilot  ]--- ");
		for (int i = 0; i < CreateDBObjects.allFlights.size(); i++) {
			if (CreateDBObjects.allFlights.get(i).getPilot().equals(e)) {
				System.out.println("Flight " + CreateDBObjects.allFlights.get(i).getFlight_number());
			}
		}

		System.out.println();

		//Print out flights where he is a co-pilot.
		System.out.println("---[  Co-Pilot  ]--- ");
		for (int i = 0; i < CreateDBObjects.allFlights.size(); i++) {
			if (CreateDBObjects.allFlights.get(i).getCopilot().equals(e)) {
				System.out.println("Flight " + CreateDBObjects.allFlights.get(i).getFlight_number());
			}
		}
	}
}


