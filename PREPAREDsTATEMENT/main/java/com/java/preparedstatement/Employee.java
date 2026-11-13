package com.java.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/preparedstatement?user=postgres&password=root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			
			
			
			preparedStatement.setInt(1, 102);
			preparedStatement.setString(2, "Smith");
			preparedStatement.setLong(3, 657876598);
			preparedStatement.setDouble(4, 7.4);
			
			boolean res= preparedStatement .execute();
			System.out.println(res);
			System.out.println("Employee added");
			
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
