package com.java.crudoperation;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;



public class GetMobile {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			connection  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcprogram","postgres","root");
			
			Statement statement = connection.createStatement();
			
		    ResultSet resultSet =	statement.executeQuery("select * from mobile");
		    
		    while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getDouble(4));
				System.out.println(resultSet.getInt(5));
				System.out.println(resultSet.getInt(6));
			}
		    
			 
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
