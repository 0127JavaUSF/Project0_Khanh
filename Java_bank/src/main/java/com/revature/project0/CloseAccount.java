package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseAccount {
	private final String url = "jdbc:postgresql://localhost:5432/Java_Bank";
	private String userName;
	private String passWord;
	private int account_number;
	public CloseAccount () {
		super ();
	}
	
	public void closeAccount (String u, String p) throws ClassNotFoundException {
		userName = u;
		passWord = p;
		Connection conn;
		Statement stmt, stmt2, stmt3, stmt4;
		try {
			 Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, "postgres", "1234");  
			stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				if (userName.equals(rs.getString(1)) && passWord.equals(rs.getString(2))) {
					account_number = rs.getInt(3);
				}
			}
			stmt2 = conn.createStatement();
			stmt2.executeUpdate("UPDATE customer SET account_number = NULL WHERE user_name = '" +userName+ "'");
			
			stmt3 = conn.createStatement();
			int close = stmt3.executeUpdate("DELETE FROM account WHERE account_number = " +account_number);
			if (close ==1 ) {
				System.out.println ("Account Closed");
			} else
				System.out.println ("Unable to close account");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
