package com.java.crudoperation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMobile {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver"); //ClassNotFoundException
			
			String url = "jdbc:postgresql://localhost:5432/jdbcprogram";
			String userNameString = "postgres";
			String password = "root";
			
			
			connection = DriverManager.getConnection(url,userNameString,password); //SQLException
			
			Statement statement = connection.createStatement();	
			
			String query = "update mobile set price = 87000.0 where id = 103"; 
			
			boolean res = statement.execute(query);
			System.out.println(res);
			
			
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
