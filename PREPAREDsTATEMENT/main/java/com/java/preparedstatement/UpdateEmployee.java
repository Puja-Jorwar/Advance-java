package com.java.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/preparedstatement?user=postgres&password=root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("update employee set sal = ? where id = ?");
			
			preparedStatement.setDouble(1, 10.23);
			preparedStatement.setInt(2, 101);
			
			int res = preparedStatement.executeUpdate();
			System.out.println(res);
			System.out.println("Data updated");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
