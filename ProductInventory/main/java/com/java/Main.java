package com.java;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ProductInventory inventory = new ProductInventory();

		while (true) {

			System.out.println(
					" 1. Save Product\n 2. Update Product\n 3. Delete Product\n 4. Find Product By Id\n 5. GetAllProduct\n 6. Logout");

			System.out.println("Select the Choice...");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter the id:");
				int id = scanner.nextInt();
				System.out.println("Enter the name:");
				String name = scanner.next();
				System.out.println("Enter the brand:");
				String brand = scanner.next();
				System.out.println("Enter the price:");
				double price = scanner.nextDouble();
				System.out.println("Enter the available quantity:");
				int quantity = scanner.nextInt();

				inventory.saveProduct(id, name, brand, price, quantity);
				System.out.println("Data saved successfully.");

			}
				break;
			case 2: {
				System.out.print("enter id :");
				
				int id = scanner.nextInt();
				inventory.updateProduct(id);

			}
				break;
			case 3: {
				System.out.println("Enter id to delete: ");
				int id = scanner.nextInt();
				inventory.deleteProduct(id);
				

			}
				break;
			case 4: {
				System.out.println("enter id:");
				int  id = scanner.nextInt();
				
				inventory.findProductById(id);

			}
				break;
			case 5: {
				inventory.getAllProduct();
				System.out.println("Data access successfully!");
			}
				break;
			case 6: {
				System.out.println("Logout successfully");
				System.exit(0);
			}
				break;

			default:
				System.out.println("Invalid Choice...");
				break;
			}
		}
	}
}