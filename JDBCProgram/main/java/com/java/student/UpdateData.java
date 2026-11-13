package com.java.student;

//import java.sql.DriverManager;
//import java.sql.Connection;
import java.sql.*;

public class UpdateData {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
		
		//load the driver software
		Class.forName("org.postgresql.Driver");
	
		//establish the connection
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcprogram","postgres","root");
		System.out.println(con);
		
		//create statement
		Statement s = con.createStatement();
		
		//execute the query
		boolean res = s.execute("update student set email='manisha@gmail.com' where id = 101"); //sql query
		System.out.println(res);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();//checked exception
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
