package com.java.student;

import java.sql.*;

public class InsertInTable {
	
	
	//load The Driver
	Class.forName("org.postgresql.Driver");
	
	//establish the connection
	
	Connection con = DriverManager.getConnection("jdbc:postegresql://localhost:5432/jdbcprogram","postgres","root");
	
	//Create Statement
	Statement s = con.createStatement();
	
	//execute query
	boolean res = s.execute("insert into student values(105,'Teja',23435,97.3,'teja@gmail.com')");
	
	
	

}
