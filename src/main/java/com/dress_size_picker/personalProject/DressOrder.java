package com.dress_size_picker.personalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DressOrder {

	TreeMap<Integer, String> dressType = new TreeMap<>();
	TreeMap<Integer, String> dressColor = new TreeMap<>();
	TreeMap<Integer, String> dressSize = new TreeMap<>();

	Scanner scanner = new Scanner(System.in);

	public DressOrder() {
		dressType.put(1, "Corporate dress");
		dressType.put(2, "Cocktail dress");
		dressType.put(3, "Casual dress");

		dressColor.put(1, "Black");
		dressColor.put(2, "Navy Blue");

		dressSize.put(1, "S");
		dressSize.put(2, "M");
		dressSize.put(3, "L");
		dressSize.put(4, "XL");

	}

	String getDressType() {
		System.out.println("We have the following dress types.");
		for (Map.Entry<Integer, String> map : dressType.entrySet()) {
			System.out.println(map.getKey() + ". " + map.getValue());

		}
		System.out.print("Please select a dress type: ");
		try {
			Integer dressTypeKey = scanner.nextInt();
			scanner.nextLine();
			String selectedType = dressType.get(dressTypeKey);
			// if customer enters invalid selection (not 1,2,3) the key returns null, since
			// the selection does not exist as a key within the map.
			if (selectedType == null) {
				throw new InputMismatchException("Error");
			}
			System.out.println("You have selected a " + selectedType + ".");
			return selectedType;
		} catch (InputMismatchException e) {
			System.out.println("Error: You selected an invalid dresstype!");
			if (e.getMessage() == null) {
				scanner.nextLine();
			}
			return getDressType();
		}
	}

	String getDressColor(String dressType) {
		System.out.println("We have " + dressType + "es in the following colors:");
		for (Map.Entry<Integer, String> map : dressColor.entrySet()) {
			System.out.println(map.getKey() + ". " + map.getValue());

		}
		System.out.print("Please select a dress color: ");
		try {
			Integer dressColorKey = scanner.nextInt();
			scanner.nextLine();
			String selectedColor = dressColor.get(dressColorKey);
			if (selectedColor == null) {
				throw new InputMismatchException("Error");
			}
			System.out.println("You have selected a " + selectedColor + " " + dressType + ".");
			return selectedColor;
		} catch (InputMismatchException e) {
			System.out.println("Error: You selected an invalid dresscolor!");
			if (e.getMessage() == null) {
				scanner.nextLine();
			}
			return getDressColor(dressType);
		}
	}

	String getDressSize(String dressType, String dressColor) {
		System.out.println("We have " + dressColor + " " + dressType + "es in the following sizes:");
		for (Map.Entry<Integer, String> map : dressSize.entrySet()) {
			System.out.println(map.getKey() + ". " + map.getValue());

		}
		System.out.print("Please select a dress size: ");

		try {
			Integer dressSizeKey = scanner.nextInt();
			scanner.nextLine();
			String selectedSize = dressSize.get(dressSizeKey);
			if (selectedSize == null) {
				throw new InputMismatchException("Error");
			}
			System.out
					.println("You have selected a " + dressColor + " " + dressType + " in size " + selectedSize + ".");
			return selectedSize;
		} catch (InputMismatchException e) {
			System.out.println("Error: You selected an invalid dress-size!");
			if (e.getMessage() == null) {
				scanner.nextLine();
			}
			return getDressSize(dressType, dressColor);
		}
	}

	String getCustomerName() {
		System.out.print("Enter your name: ");
		String customerName = scanner.nextLine();
		return customerName;
	}

	String getCustomerAddress() {
		System.out.print("Enter your address: ");
		String customerAddress = scanner.nextLine();
		return customerAddress;
	}

	void printOrder(String dressType, String dressColor, String dressSize, String customerName,
			String customerAddress) {
		System.out.println("\nDear " + customerName + ",");
		System.out.println("You have ordered a " + dressColor + " " + dressType + " in size " + dressSize + ".");
		System.out.println("Your order will be delivered to " + customerAddress + ".\n");
	}

	private static void saveOrder(String dressType, String dressColor, String dressSize, String customerName,
			String customerAddress) {
		String order = "";
		order += "dressType: " + dressType + "\n";
		order += "dressColor: " + dressColor + "\n";
		order += "dressSize: " + dressSize + "\n";
		order += "customerName: " + customerName + "\n";
		order += "customerAddress: " + customerAddress + "\n\n";
		// create a file that stores the customer order information
		try {
			// initialize counter
			int counter = 1;
			String fileName = "order.txt";

			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			// Count the number of existing orders
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("Order ")) {
					counter++;
				}
			}
			reader.close();
			FileWriter writer = new FileWriter("order.txt", true);
			writer.append("Order " + counter + ".\n");
			writer.append(order);
			writer.close();
		} catch (IOException e) {
			System.out.println("Something went wrong while creating the file: ");
			e.printStackTrace();
		}
	}

	void makeOrder() {
		String dressTypeSelected = getDressType();
		String dressColorSelected = getDressColor(dressTypeSelected);
		String dressSizeSelected = getDressSize(dressTypeSelected, dressColorSelected);
		String name = getCustomerName();
		String address = getCustomerAddress();

		printOrder(dressTypeSelected, dressColorSelected, dressSizeSelected, name, address);
		saveOrder(dressTypeSelected, dressColorSelected, dressSizeSelected, name, address);
	}
}
