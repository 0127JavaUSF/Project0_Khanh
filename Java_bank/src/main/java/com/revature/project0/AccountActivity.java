package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountActivity {
	private final String url = "jdbc:postgresql://localhost:5432/Java_Bank";
	private String userName;
	private int getAccountNumber;
	private double depositAmount;
	private double withdrawAmount;
	
	Scanner console = new Scanner (System.in);
	
	public AccountActivity () {
		super ();	
	}
	
	public void deposit (String u) {
		userName = u;
		Connection conn;
		Statement stmt, stmt2;
		try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "postgres", "1234");
            String sql = "SELECT * FROM account";
            stmt = conn.createStatement ();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	if (userName.equals(rs.getString(3)) || userName.equals(rs.getString(4))) {
            		getAccountNumber = rs.getInt(1);
            	}	
            	
            }
            System.out.println ("Enter Deposit Amount: ");
            depositAmount = console.nextDouble();
            stmt2 = conn.createStatement ();
           int rec = stmt2.executeUpdate("INSERT INTO transaction (deposit , account_number)" + " VALUES ("+depositAmount+" , "+getAccountNumber+");" );
            if (rec == 1) {
            	System.out.println ("Deposit Successful for the Amount: $" + depositAmount);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
		} 
	}
	
	public void withdraw (String u) {
		userName = u;
		Connection conn;
		Statement stmt, stmt2;
		try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "postgres", "1234");
            String sql = "SELECT * FROM account";
            stmt = conn.createStatement ();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	if (userName.equals(rs.getString(3)) || userName.equals(rs.getString(4))) {
            		 getAccountNumber = rs.getInt(1);
            	}		
            }
            System.out.println ("Enter Withdraw Amount: ");
            withdrawAmount = console.nextDouble();
            stmt2 = conn.createStatement ();
            int rec = stmt2.executeUpdate("INSERT INTO transaction (withdraw, account_number)" + " VALUES ("+withdrawAmount+" , "+getAccountNumber+");" );
            if (rec == 1) {
            	System.out.println ("Withdraw Amount: $" + withdrawAmount);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
		} 
	}
	
	public void viewBalance (String u) {
		userName = u;
		Connection conn;
		Statement stmt, stmt2;
		try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "postgres", "1234");
            String sql = "SELECT * FROM account";
            stmt = conn.createStatement ();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	if (userName.equals(rs.getString(3)) || userName.equals(rs.getString(4))) {
            		getAccountNumber = rs.getInt(1);
            	}		
            } 
            stmt2 = conn.createStatement ();
            ResultSet rs1 = stmt2.executeQuery("SELECT Sum (deposit) - Sum (withdraw) AS Balance FROM transaction WHERE account_number = " +getAccountNumber );
            while (rs1.next()) {
            System.out.println ("Your Account Balance Is: $ " + rs1.getDouble(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
		} 
	}
}


