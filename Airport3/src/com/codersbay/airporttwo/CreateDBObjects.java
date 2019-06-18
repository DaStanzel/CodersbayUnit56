package com.codersbay.airporttwo;

import com.codersbay.airporttwo.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateDBObjects {

    static ArrayList<Employees> allEmployees = new ArrayList<Employees>();
    static ArrayList<Flights> allFlights = new ArrayList<>();
    static ArrayList<Locations> allLocations = new ArrayList<>();
    static ArrayList<Gates> allGates = new ArrayList<>();
    static ArrayList<Classes> allClasses = new ArrayList<>();
    static ArrayList<Airports> allAirports = new ArrayList<>();
    static ArrayList<Flights_Stewards> allStewards = new ArrayList<>();
    static ArrayList<Luggage> allLuggage = new ArrayList<>();
    static ArrayList<Luggage_Types> allLuggageTypes = new ArrayList<>();
    static ArrayList<Terminals> allTerminals = new ArrayList<>();
    static ArrayList<Tickets> allTickets = new ArrayList<>();

    public static void createAll(Connection conn) {
        createLuggageTypes(conn);
        createLocation(conn);
        createEmployees(conn);
        createClasses(conn);
        createAirports(conn);
        createTerminals(conn);
        createGates(conn);
        createFlight(conn);
        createTickets(conn);
        createStewards(conn);
        createLuggage(conn);
    }

    public static void createLuggageTypes(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Luggage_Types";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Luggage_Types l = new Luggage_Types();
                l.setId(rs.getInt(1));
                l.setName(rs.getString(2));
                l.setDescription(rs.getString(3));
                allLuggageTypes.add(l);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createLocation(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Locations";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Locations l = new Locations();
                l.setZip(rs.getString(1));
                l.setCity(rs.getString(2));
                l.setCountry(rs.getString(3));
                l.setTimezone(rs.getString(4));

                allLocations.add(l);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createEmployees(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Employees";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setPersonnel_number(rs.getInt(1));
                employee.setFirst_name(rs.getString(2));
                employee.setLast_name(rs.getString(3));
                employee.setStreet(rs.getString(4));
                employee.setApartment_number(rs.getString(5));
                for (Locations l : allLocations) {
                    if (l.zip.equals(rs.getString(6)))
                        employee.setLocation(l);
                }
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

    public static void createClasses(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Classes";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Classes c = new Classes();
                c.setClass_id(rs.getInt(1));
                c.setName(rs.getString(2));
                allClasses.add(c);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createAirports(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Airports";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Airports a = new Airports();
                a.setIATA(rs.getString(1));
                for (Locations l : allLocations) {
                    if (l.zip.equals(rs.getString(2)))
                        a.setLocation(l);
                }
                a.setName(rs.getString(3));
                allAirports.add(a);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createTerminals(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Terminals";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Terminals t = new Terminals();
                t.setTerminal_id(rs.getInt(1));
                for (Airports a : allAirports) {
                    if (a.getIATA().equals(rs.getString(2)))
                        t.setAirport(a);
                }
                t.setName(rs.getString(3));
                allTerminals.add(t);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createGates(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Gates";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Gates g = new Gates();
                g.setGate_id(rs.getInt(1));
                for (Terminals t : allTerminals) {
                    if (t.terminal_id == rs.getInt(2))
                        g.setTerminal(t);
                }
                g.setName(rs.getString(3));
                allGates.add(g);
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

            String sqlQuery = "SELECT * FROM Flights";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Flights flight = new Flights();
                flight.setFlight_number(rs.getInt(1));
                flight.setDeparture(rs.getTime(2));
                flight.setFlight_duration(rs.getInt(3));
                for (Gates g : allGates) {
                    if (g.getGate_id() == rs.getInt(4))
                        flight.setDeparture_gate(g);
                }
                for (Gates g : allGates) {
                    if (g.getGate_id() == rs.getInt(5))
                        flight.setArrival_gate(g);
                }
                for (Employees e : allEmployees) {
                    if (e.getPersonnel_number() == rs.getInt(6))
                        flight.setPilot(e);
                }
                for (Employees e : allEmployees) {
                    if (e.getPersonnel_number() == rs.getInt(7))
                        flight.setCopilot(e);
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

    public static void createTickets(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Tickets";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Tickets t = new Tickets();
                t.setBoardingpass_number(rs.getInt(1));
                for (Flights f : allFlights) {
                    if (f.getFlight_number() == rs.getInt(2))
                        t.setFlight(f);
                }
                t.setSeat_number(rs.getInt(3));
                t.setPassenger_first_name(rs.getString(4));
                t.setPassenger_second_name(rs.getString(5));
                t.setPassanger_last_name(rs.getString(6));
                for (Classes c : allClasses) {
                    if (c.getClass_id() == rs.getInt(7))
                        t.setTicket_class(c);
                }
                t.setPrice(rs.getFloat(8));
                allTickets.add(t);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createStewards(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM flights_stewards";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Flights_Stewards s = new Flights_Stewards();
                for (Flights f : allFlights) {
                    if (f.getFlight_number() == rs.getInt(1))
                        s.setFlight(f);
                }
                for (Employees e : allEmployees) {
                    if (e.getPersonnel_number() == rs.getInt(2))
                        s.setEmployee(e);
                }
                allStewards.add(s);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }

    public static void createLuggage(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String sqlQuery = "SELECT * FROM Luggage";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Luggage l = new Luggage();
                l.setId(rs.getInt(1));
                for (Tickets t : allTickets) {
                    if (t.getBoardingpass_number() == (rs.getInt(2)))
                        l.setTicket(t);
                }
                for (Luggage_Types lt : allLuggageTypes) {
                    if (lt.getId() == rs.getInt(2))
                        l.setType(lt);
                }
                allLuggage.add(l);
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }
    }
}






