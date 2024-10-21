package com.dress_size_picker.personalProject;

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
		Integer dressTypeKey = scanner.nextInt();
		System.out.println("You have selected a " + dressType.get(dressTypeKey) + ".");
		return dressType.get(dressTypeKey);
	}

	String getDressColor(String dressType) {
		System.out.println("We have " + dressType + "es in the following colors:");
		for (Map.Entry<Integer, String> map : dressColor.entrySet()) {
			System.out.println(map.getKey() + ". " + map.getValue());

		}
		System.out.print("Please select a dress color: ");
		Integer dressColorKey = scanner.nextInt();
		System.out.println("You have selected a " + dressColor.get(dressColorKey) + " " + dressType + ".");
		return dressColor.get(dressColorKey);
	}

	String getDressSize(String dressType, String dressColor) {
		System.out.println("We have " + dressColor + " " + dressType + "es in the following sizes:");
		for (Map.Entry<Integer, String> map : dressSize.entrySet()) {
			System.out.println(map.getKey() + ". " + map.getValue());

		}
		System.out.print("Please select a dress size: ");
		Integer dressSizeKey = scanner.nextInt();
		scanner.nextLine();
		System.out.println("You have selected a " + dressColor + " " + dressType + " in size "
				+ dressSize.get(dressSizeKey) + ".");
		return dressSize.get(dressSizeKey);
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
		System.out.println("Dear " + customerName + ",");
		System.out.println("You have ordered a " + dressColor + " " + dressType + " in size " + dressSize + ".");
		System.out.println("Your order will be delivered to " + customerAddress);
	}

	void makeOrder() {
		String dressTypeSelected = getDressType();
		String dressColorSelected = getDressColor(dressTypeSelected);
		String dressSizeSelected = getDressSize(dressTypeSelected, dressColorSelected);
		String name = getCustomerName();
		String address = getCustomerAddress();


		printOrder(dressTypeSelected, dressColorSelected, dressSizeSelected, name, address);
	}
}
