package com.java.crudoperation;


import java.sql.*;

public class InsertMobile {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/jdbcprogram";
			String userName= "postgres";
			String password = "root";
			
			connection = DriverManager.getConnection(url,userName,password);
			
			Statement statement = connection.createStatement();
			
			String query = "insert into mobile values(103,'iphone16','Apple', 75000.0, 12, 128)";
			
			boolean res = statement.execute(query);
			
			String updateConString = "update contact set mobno = 21434 where name='Puja'";
			
			boolean b = statement.execute(updateConString);
			
			System.out.println(res);
			System.out.println("mobile inserted");
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
