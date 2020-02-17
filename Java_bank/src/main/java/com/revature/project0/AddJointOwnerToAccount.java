package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddJointOwnerToAccount {
	private final String url = "jdbc:postgresql://localhost:5432/Java_Bank";
	private String userName;
	private String passWord;
	private String userName2;
	private int getAccount_number;
	public static boolean validation = false;
	
	public AddJointOwnerToAccount () {
		
		super ();
	}
	
	public void addOwner (String u, String p) throws ClassNotFoundException {
		@SuppressWarnings("resource")
		Scanner console = new Scanner (System.in);
		userName = u;
		passWord = p;
		int addowner = 0 ;
		Connection conn;
		Statement stmt, stmt2, stmt3 ;
		 try {
			  Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, "postgres", "1234");  
			stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer; ");
			while (rs.next()) {
				if (userName.equals(rs.getString(1)) && passWord.equals(rs.getString(2))) {
					getAccount_number = rs.getInt(3);
					System.out.println ("Enter Adding UserName: ");
					userName2 = console.nextLine();
				}
			}
			stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT user_name FROM customer;");
			while (rs2.next()) {
				if (userName2.equals(rs2.getString(1))) {
					stmt3 = conn.createStatement();
					stmt3.executeUpdate("UPDATE account SET customer2 = '" +userName2+ "' WHERE account_number = " +getAccount_number);
					addowner = 1;
				}
			}
			if (addowner == 1) {
				System.out.println ("Joint Owner Added " + userName2);
			}
		} 
		 catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 
	}
		
}
