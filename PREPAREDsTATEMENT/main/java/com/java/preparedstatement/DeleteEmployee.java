package com.java.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/preparedstatement?user=postgres&password=root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id = ?");
			
			preparedStatement.setInt(1, 101);
			
			boolean b =	preparedStatement.execute();
			System.out.println(b);
			System.out.println("record Deleted");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
