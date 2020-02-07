package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserValidation {
	private final String url = "jdbc:postgresql://localhost:5432/Java_Bank";
	private String userName;
	private String passWord;
	public static boolean validation = false;
	
	
	public boolean checkValidation (String u, String p) {
		userName = u;
		passWord = p;
		
		Connection conn;
		try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, "postgres", "1234");
            String sql = "SELECT user_name, password FROM customer";
            Statement stmt = conn.createStatement ();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	if (userName.equals(rs.getString(1)) && passWord.equals(rs.getString(2))) {
            		validation = true;	
            	}
            		
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
		} 
			
		return validation;
	}
		
}