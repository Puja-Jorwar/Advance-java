package com.java.crudoperation;
`

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Task {
	
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcprogram","postgres","root");
			
			Statement statement = connection.createStatement();
			
			
			//Save the Contact
			String saveContactString = "insert into contact values('Aaju',435798)";
			
			boolean res = statement.execute(saveContactString);
			System.out.println(res);
			System.out.println("contact saved");
			
			
			//Update the Contact
			String updateConString = "update contact set mobno = 21434 where name='Raju'";
			
			boolean b = statement.execute(updateConString);
			
			System.out.println(b);
			System.out.println("contact updated");
			
			//Get the Contact
			String getCString = "select * from contact";
			
			ResultSet res1 = statement.executeQuery(getCString);
			
			while(res1.next()) {
				System.out.println(res1.getString(1));
				System.out.println(res1.getInt(2));
			}
			
			
			
			
			
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
