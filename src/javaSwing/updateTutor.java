package javaSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateTutor {

	public void updatingTutor(String tutorID, String tutorFName, String tutorLName, String email, String phone, String course) {
		
		String url = "jdbc:mysql://localhost:3307/courses";
	    String baseUsername = "root";
	    String basePassword = "";
	    String id = tutorID;
	    String fname = tutorFName;
	    String lname = tutorLName;
	    String Email = email;
	    String number = phone;
	    String module = course;
	    try {
	    	Connection c = DriverManager.getConnection(url,baseUsername,basePassword);
	    	Statement s = c.createStatement();
	    	
	    	String query = " CREATE DATABASE IF NOT EXISTS courses";           

	        s.executeUpdate(query);
	        
	        String updateQuery = "UPDATE courses.teacher SET "
	                + "First_Name = '" + fname + "', "
	                + "Last_Name = '" + lname + "', "
	                + "Email = '" + Email + "', "
	                + "Phone = '" + number + "' ,"
	                + "Course = '"+module+"'"
	                + "WHERE ID = " + id;

	        s.executeUpdate(updateQuery);
	        s.close();
	        c.close();
	    } catch (SQLException e) {
	    	System.out.print(e);
	    }
		
		
	}
}
