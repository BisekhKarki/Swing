package javaSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Result {
public static void  StudentResult(String name, String email, String module, String subject, String marks,String level) {
	 String url = "jdbc:mysql://localhost:3307/courses";
     String baseUsername = "root";
     String basePassword = "";
     String full = name;
     String mail = email;
     String mo = module;
     String sub = subject;
     String mark = marks;
     String lvl = level;
     

     try {
         Connection c = DriverManager.getConnection(url, baseUsername, basePassword);
         Statement s = c.createStatement();
         String query = " CREATE DATABASE IF NOT EXISTS courses";
         s.executeUpdate(query);
         String creation = "CREATE TABLE IF NOT EXISTS courses.Result(ID INT AUTO_INCREMENT PRIMARY KEY,Full_Name varchar(100), Email varchar(1000), Module varchar(1000), Subject varchar(120),level varchar(100), Marks varchar(1000))";
     	s.execute(creation);
     	String insertCourse = "INSERT INTO courses.Result (Full_Name, Email, Module, Subject,level, Marks) VALUES (?, ?, ?,?, ?, ?)";
    	PreparedStatement pstmt = c.prepareStatement(insertCourse);  // Use prepared statement
    	pstmt.setString(1, full);
    	pstmt.setString(2, mail);
    	pstmt.setString(3, mo);
    	pstmt.setString(4, sub);
    	pstmt.setString(5,lvl);
    	pstmt.setString(6, mark);
    	
    	pstmt.executeUpdate(); 
     		
         s.close();
         c.close();
     } catch (SQLException e) {
         System.out.println(e);
     }
	
	
}
}
