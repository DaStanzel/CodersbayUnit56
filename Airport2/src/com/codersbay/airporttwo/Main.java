package com.codersbay.airporttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Time;

public class Main {

    //DECLARATIONS
    static ArrayList<flights> flights_all;
    static ArrayList<Employees> employees_all;

    public static void main(String[] args) {

        CreateDBObjects.createEmployees(DBConnection.connectDB());
        CreateDBObjects.createFlight(DBConnection.connectDB());
        flights_all = CreateDBObjects.allFlights;
        employees_all = CreateDBObjects.allEmployees;
        for (flights f : flights_all) {
            System.out.println(f.getFlight_number());
        }
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

        flights f = findFlightByNumber(Integer.valueOf(scanner.next()));

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
            System.out.println("Flight not found!");
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
        for (int i = 0; i < employees_all.size(); i++) {
            if (employees_all.get(i).getPersonalNumber() == enteredNumber) {
                return employees_all.get(i);
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
    private static flights findFlightByNumber(int enteredNumber) {
        for (int i = 0; i < flights_all.size(); i++) {
            if (flights_all.get(i).getFlight_number() == enteredNumber) {
                return flights_all.get(i);
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
    private static void printFlightDetails(flights f) {
        System.out.println("Flight Number: " + f.getFlight_number());
        System.out.println("Departure Time: " + f.getDeparture());
        System.out.println("Flight Duration: " + f.getFlight_duration());
        System.out.println("Departure Gate: " + f.getDeparture_gate());
        System.out.println("Arrival Gate: " + f.getArrival_gate());
        System.out.println();
        System.out.println("Pilot: " + f.getPilot().getFirst_name() + " " + f.getPilot().getLast_name());
        System.out.println("Co-Pilot: " + f.getCo_pilot().getFirst_name() + " " + f.getCo_pilot().getLast_name());
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
        for (int i = 0; i < flights_all.size(); i++) {
            if (flights_all.get(i).getPilot().equals(e)) {
                System.out.println("Flight " + flights_all.get(i).getFlight_number());
            }
        }

        System.out.println();

        //Print out flights where he is a co-pilot.
        System.out.println("---[  Co-Pilot  ]--- ");
        for (int i = 0; i < flights_all.size(); i++) {
            if (flights_all.get(i).getCo_pilot().equals(e)) {
                System.out.println("Flight " + flights_all.get(i).getFlight_number());
            }
        }
    }
}
