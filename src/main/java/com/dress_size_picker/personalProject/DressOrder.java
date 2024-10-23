package com.dress_size_picker.personalProject;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DressOrder {

	TreeMap<Integer, String> dressType = new TreeMap<>();
	TreeMap<Integer, String> dressColor = new TreeMap<>();
	TreeMap<Integer, String> dressSize = new TreeMap<>();
	OrderFile file = new OrderFile();
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
			System.out.println(Colors.error("Error: You selected an invalid dresstype!"));
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
			System.out.println(Colors.error("Error: You selected an invalid dresscolor!"));
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
			System.out.println(Colors.error("Error: You selected an invalid dress-size!"));
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
		System.out.println(Colors.warm("\nDear " + customerName + ","));
		System.out.println(
				Colors.warm("You have ordered a " + dressColor + " " + dressType + " in size " + dressSize + "."));
		System.out.println(Colors.warm("Your order will be delivered to " + customerAddress + ".\n"));
	}

	void makeOrder() {
		String dressTypeSelected = getDressType();
		String dressColorSelected = getDressColor(dressTypeSelected);
		String dressSizeSelected = getDressSize(dressTypeSelected, dressColorSelected);
		String name = getCustomerName();
		String address = getCustomerAddress();

		printOrder(dressTypeSelected, dressColorSelected, dressSizeSelected, name, address);
		file.saveOrder(dressTypeSelected, dressColorSelected, dressSizeSelected, name, address);
	}
}
