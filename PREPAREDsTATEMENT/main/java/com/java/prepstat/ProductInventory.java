package com.java.prepstat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductInventory {
	
	public void saveProduct(int id, String name, String brand, double price, int quantity) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productinventory?user=postgres&password=root");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setDouble(4, price);
			preparedStatement.setInt(5, quantity);
			
			preparedStatement.execute();
			
			System.out.println("data Saved successfully....!");
			
			
			
			
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
	public void updateProduct() {
		
	}
	public void deleteProduct() {
		
	}
	public void findProductById() {
		
	}
	public void getAllProduct() {
		
	}

}
