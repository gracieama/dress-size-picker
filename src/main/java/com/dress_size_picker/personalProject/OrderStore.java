package com.dress_size_picker.personalProject;

import java.io.BufferedReader;
import java.io.FileReader;

public class OrderStore {
	
	int getNextId() {
		// initialize counter
		int counter = 1;
					try {
						
						String fileName = "order.txt";
						BufferedReader reader;
						reader = new BufferedReader(new FileReader(fileName));
						// Count the number of existing orders
						String line;
						while ((line = reader.readLine()) != null) {
							if (line.startsWith("Order ")) {
								counter++;
							}
						}
						reader.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					return counter;
	}
}
