package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUser {
	private final String url = "jdbc:postgresql://localhost:5432/Java_Bank";
	private String userName ;
	private String passWord ;
	
	public CreateUser () {
		
	}
	 public void addUser(String u, String p) throws ClassNotFoundException
	 {      
	   
	    userName = u;
	    passWord = p;
		 Connection conn;  
		 int answer = 0;
	    Statement stmt;         
	    try      
	    {             
	//get connection  
	    	Class.forName("org.postgresql.Driver");
	     conn = DriverManager.getConnection(url, "postgres", "1234");      
	     stmt = conn.createStatement();  
	     ResultSet rs = stmt.executeQuery("SELECT user_name FROM customer ");
		     while(rs.next()) {
		    	 if (userName.equals(rs.getString(1))) {
		    		 System.out.println ("User Name is already exist");
	         	} else
	         		answer = stmt.executeUpdate("INSERT INTO customer (user_name, password)" + " VALUES ('"+userName+"','"+passWord+"')");
			     if (answer == 1) {
			     System.out.println("User Account created.");   
			     }else 
			    	 System.out.println("fail to create new user account !!!");   
		     } conn.close();
		     
	     }            
	    catch (SQLException ex) {
	    }
	 }
	    
 }
