package com.java.prepstat;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		ProductInventory inventory = new ProductInventory();
		Scanner scanner = new Scanner(System.in);
		
	
		while(true) {
		System.err.println("Enter choice:");
		System.out.println("1.save product\n 2.Update product\n 3.Delelte Product\n 4.Find product by id\n 5.Get all product\n 6.logout");
		
		int choice = scanner.nextInt();
		
		
		
		
		switch (choice) {
		case 1:{
			System.out.println("enter id:");
			int id = scanner.nextInt();
			
			System.out.println("enter name:");
			String name = scanner.next();
			
			System.out.println("enter brand:");
			String brand = scanner.next();
			
			System.out.println("enter price: ");
			double price = scanner.nextDouble();
			
			System.out.println("enter quqntity: ");
			int quantity = scanner.nextInt();
			
			inventory.saveProduct(id, name, brand, price, quantity);
			System.out.println("data addded successfully......");
			
		}break;
		case 2:{
			
		}
		break;
		case 3:{
			
		}break;
		case 4:{
			
		}break;
		case 5:{
			
		}break;
		case 6:{
			
		}
		break;

		default:
			System.out.println("Invalid choice");
			break;
		}
		}
				
	}

}
