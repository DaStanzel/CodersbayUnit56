package com.codersbay.airporttwo;

import com.codersbay.airporttwo.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateDBObjects {

    static ArrayList<Employees> allEmployees = new ArrayList<Employees>();
    static ArrayList<flights> allFlights = new ArrayList<>();

    public static void createEmployees(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ;
            String sqlQuery = "SELECT * FROM Employees";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setPersonalNumber(rs.getInt(1));
                employee.setFirst_name(rs.getString(2));
                employee.setLast_name(rs.getString(3));
                employee.setStreet(rs.getString(4));
                employee.setAppartment_number(rs.getString(5));
                employee.setZip(rs.getString(6));
                employee.setPhonenumber(rs.getString(7));
                employee.setEmail(rs.getString(8));
                allEmployees.add(employee);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createFlight(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ;
            String sqlQuery = "SELECT * FROM Flights";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                flights flight = new flights();
                flight.setFlight_number(rs.getInt(1));
                flight.setDeparture(rs.getTime(2));
                flight.setFlight_duration(rs.getInt(3));
                flight.setDeparture_gate(rs.getInt(4));
                flight.setDeparture_gate(rs.getInt(5));
                for (Employees e : allEmployees) {
                    if (e.getPersonalNumber() == rs.getInt(6))
                        flight.setPilot(e);
                }
                for (Employees e : allEmployees) {
                    if (e.getPersonalNumber() == rs.getInt(7))
                        flight.setCo_pilot(e);
                }

                allFlights.add(flight);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }
}
