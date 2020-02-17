package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewAccount {
	private final String url = "jdbc:postgresql://localhost:5432/Java_Bank";
	private String accountType ;
	private String userName ;
	private int account_number;
	
	public NewAccount () {
		super ();
	}
	
	public void addAccount (String act_type, String u) throws ClassNotFoundException {
		userName = u;
		accountType = act_type;
		Connection conn;
		Statement stmt, stmt2;
		String setTableName;
		int answer = 0;
		
		  try {
			  Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, "postgres", "1234");  
			stmt = conn.createStatement(); 
			String sql1 = "INSERT INTO account (account_type, customer)" + " VALUES ('"+accountType+"' , '"+userName+"')";
		  ResultSet rs = stmt.executeQuery("SELECT user_name FROM customer;");
		  while(rs.next()) {
		  		if (userName.equals(rs.getString(1))) {	
		  			System.out.println ("Create new account ");
		  		}	
		  	}
		  		stmt.executeUpdate(sql1);
		  	stmt2 = conn.createStatement();	  
		  	ResultSet rs2 = stmt2.executeQuery("SELECT account_number FROM account WHERE customer = '" +userName+ "';");
		  	while (rs2.next()) {
		  		account_number = rs2.getInt(1);
		  		answer = 1;
		  	}
		  	if (answer == 1) {
		  		System.out.println("Account is created ");
		  	}
		  	
		  	String sql2 ="UPDATE customer SET account_number = " +account_number+ " WHERE user_name = '" +userName+ "';";
		  	stmt2.executeUpdate(sql2);
		  
		  	ResultSet rs3 = stmt.executeQuery("SELECT account_number FROM customer WHERE user_name = '"+userName+"'");
		  	while (rs3.next()) {
		  		setTableName = rs3.getString(1);
		  		System.out.println ("Your Account Number Is: " + setTableName );
		  	}
		  	
		  }
		  catch (SQLException ex) {
			  ex.printStackTrace();
		  }
	}
}
