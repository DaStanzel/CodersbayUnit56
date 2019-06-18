package com.codersbay.airporttwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection connectDB() {
	 // Diese Eintraege werden zum 
    // Verbindungsaufbau benoetigt. 
    final String hostname = "localhost"; 
    final String dbname = "codersbay_airlines";
    final String user = "root"; 
    final String password = ""; 

    Connection conn = null; 
  

    try { 
    	System.out.println("* Treiber laden"); 
  	    Class.forName("org.gjt.mm.mysql.Driver"); 
    } 
    catch (Exception e) { 
        System.err.println("Unable to load driver."); 
        e.printStackTrace(); 
    }
    
    
    try { 
	    System.out.println("* Verbindung aufbauen"); 
	    String url = "jdbc:mysql://"+hostname+"/"+dbname; 
	    conn = DriverManager.getConnection(url, user, password); 
	    


    } 
    catch (SQLException sqle) { 
        System.out.println("SQLException: " + sqle.getMessage()); 
        System.out.println("SQLState: " + sqle.getSQLState()); 
        System.out.println("VendorError: " + sqle.getErrorCode()); 
        sqle.printStackTrace(); 
    } 
    return conn;
	
 } // ende: public static void connectDB() 

public static void closeDB(Connection conn) { 
	try {
		System.out.println("* Datenbank-Verbindung beenden"); 
		conn.close(); 
	 } 
    catch (SQLException sqle) { 
        System.out.println("SQLException: " + sqle.getMessage()); 
        System.out.println("SQLState: " + sqle.getSQLState()); 
        System.out.println("VendorError: " + sqle.getErrorCode()); 
        sqle.printStackTrace(); 
    } 
}


}
