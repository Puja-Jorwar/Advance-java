package com.java.student;


import java.sql.*;

public class DeleteData {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//load the driver
			Class.forName("org.postgres.Driver"); //classNotFoundException
			
			//establish the connection
			connection  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcdatabase","postgress","root");
			
			//create statement
			Statement statement = connection.createStatement();
			
			//execute the query
			boolean res = statement.execute("delete from student where id = 101");
			System.out.println(res);
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
