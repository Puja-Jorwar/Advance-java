package com.java.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithScanner {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/preparedstatement?user=postgres&password=root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			
			preparedStatement.setInt(1, 101);
		
			
			preparedStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
