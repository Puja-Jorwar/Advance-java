package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductInventory {
	String url = "jdbc:postgresql://localhost:5432/productinventory?user=postgres&password=root";
	Connection connection = null;

	public void saveProduct(int id, String name, String brand, double price, int quantity) {

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url);
			PreparedStatement statement = connection.prepareStatement("insert into product values(?,?,?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, brand);
			statement.setDouble(4, price);
			statement.setInt(5, quantity);

			boolean res = statement.execute();
			System.out.println("Data Saved Successfully....");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateProduct(int id) {
		Connection connection = null;

		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");

			preparedStatement.setInt(1, id);

			boolean res = preparedStatement.execute();

			if (res) {
				ResultSet resultSet = preparedStatement.getResultSet();

				if (resultSet.next()) {
					System.out.println("1.Update Name \n 2. Update Brand \n 3. Update Price \n 4. Update Quantity");

					System.out.println("Enter field to update");

					int key = scanner.nextInt();
					switch (key) {
					case 1: {
						PreparedStatement statement2 = connection
								.prepareStatement("update product set name = ? where id = ?");

						System.out.println("eneter new name");
						String name = scanner.next();
						statement2.setString(1, name);
						statement2.setInt(2, id);

						int execute = statement2.executeUpdate();

						if (execute == 1) {
							System.out.println("Name updated Successfully....");
						} else {
							System.out.println("Try Again.....");
						}

					}

						break;
					case 2: {
						PreparedStatement statement2 = connection
								.prepareStatement("update product set brand = ? where id = ?");

						System.out.println("eneter new brand");
						String brand = scanner.next();
						statement2.setString(1, brand);
						statement2.setInt(2, id);

						int execute = statement2.executeUpdate();

						if (execute == 1) {
							System.out.println("Brand updated Successfully....");
						} else {
							System.out.println("Try Again.....");
						}

					}
						break;
					case 3: {
						PreparedStatement statement2 = connection
								.prepareStatement("update product set price = ? where id = ?");

						System.out.println("eneter new price");
						double price = scanner.nextDouble();
						statement2.setDouble(1, price);
						statement2.setInt(2, id);

						int execute = statement2.executeUpdate();

						if (execute == 1) {
							System.out.println("Name updated Successfully....");
						} else {
							System.out.println("Try Again.....");
						}

					}
						break;
					case 4: {
						PreparedStatement statement2 = connection
								.prepareStatement("update product set quantity = ? where id = ?");

						System.out.println("eneter new quantity");
						int quantity = scanner.nextInt();
						statement2.setInt(1, quantity);
						statement2.setInt(2, id);

						int execute = statement2.executeUpdate();

						if (execute == 1) {
							System.out.println("Name updated Successfully....");
						} else {
							System.out.println("Try Again.....");
						}

					}
						break;

					default: {

						System.out.println("invalid choice....!");
					}
						break;
					}

				} else {
					System.out.println("id not found");
				}

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(int id) {
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
			
			preparedStatement.setInt(1, id);

			int res = preparedStatement.executeUpdate();
			if (res > 0) {

				System.out.println(id + " deleted successfully");

			} else {
				System.out.println("Id not Found...!");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void findProductById(int id) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getDouble(4));
				System.out.println(resultSet.getInt(5));
			} else {
				System.out.println("id not found");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void getAllProduct() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getDouble(4));
				System.out.println(resultSet.getInt(5));

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}