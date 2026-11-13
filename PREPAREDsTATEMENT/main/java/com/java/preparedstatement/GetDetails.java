package com.java.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDetails {
	public static void main(String[] args) {
		Connection  connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			String urlString = "jdbc:postgresql://localhost:5432/preparedstatement?user=postgres&password=root";
			connection = DriverManager.getConnection(urlString);
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id = ?");
			
			preparedStatement.setInt(1, 101);
			
			ResultSet resultSet =  preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getLong(3));
				System.out.println(resultSet.getDouble(4));
					
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection .close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
