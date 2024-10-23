package com.dress_size_picker.personalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrderFile {
	private String fileName = "order.txt";
	
	public void saveOrder(String dressType, String dressColor, String dressSize, String customerName,
			String customerAddress) {
		String order = "";
		order += "dressType: " + dressType + "\n";
		order += "dressColor: " + dressColor + "\n";
		order += "dressSize: " + dressSize + "\n";
		order += "customerName: " + customerName + "\n";
		order += "customerAddress: " + customerAddress + "\n\n";
		// create a file that stores the customer order information
		try {
			int nextId = getNextId();
			FileWriter writer = new FileWriter(fileName, true);
			writer.append("Order " + nextId + ".\n");
			writer.append(order);
			writer.close();
		} catch (IOException e) {
			System.out.println("Something went wrong while creating the file: ");
			e.printStackTrace();
		}
	}

	private int getNextId() throws IOException {
		// initialize counter
		int nextId = 1;

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		// Count the number of existing orders
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("Order ")) {
				nextId++;
			}
		}
		reader.close();
		return nextId;
	}

}
