package server.DBcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	
	public static Connection conn;
	
	public DBConnector() {
		createConnection();
	}
	
	
	private void createConnection() {
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	      System.out.println("Driver definition succeed");
	    } catch (Exception ex) {
	      System.out.println("Driver definition failed");
	    } 
	    try {
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost/assigment2?serverTimezone=IST","root","Aa123456");
	      System.out.println("SQL connection succeed");
	    } catch (SQLException ex) {
	      System.out.println("SQLException: " + ex.getMessage());
	      System.out.println("SQLState: " + ex.getSQLState());
	      System.out.println("VendorError: " + ex.getErrorCode());
	    } 
	  }
	
	public void closeConnection() {
		try {
			if(!conn.isClosed())
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}