package com.java.crudoperation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteMobile {
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/jdbcprogram";
			String userName = "postgres";
			String password = "root";
			connection = DriverManager.getConnection(url,userName,password);
			
			Statement statement = connection.createStatement();
			
			String queryString = "delete from mobile where id = 101";
			
			boolean res = statement  .execute(queryString);
			System.err.println(res);
			System.out.println("deleted");
			
			
		} catch (ClassNotFoundException | SQLException e){
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
