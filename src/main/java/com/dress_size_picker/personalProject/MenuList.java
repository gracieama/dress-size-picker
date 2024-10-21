package com.dress_size_picker.personalProject;

import java.util.Scanner;

public class MenuList {

	// declaring variables

	Scanner scanner = new Scanner(System.in);

	// method to display menulist

	public void displayMenu() {
		System.out.println("==========================================================");
		System.out.println("                1. Find your dress size.                  ");
		System.out.println("                2. Order a dress.                         ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("                        5. Exit.                          ");
		System.out.println("==========================================================");
	}

	public void selection() {
		System.out.print("Enter your selection: ");
		int selection = scanner.nextInt();

		if (selection == 1) {
			DressSizeSelector selector = new DressSizeSelector();
			selector.begin();
		}

		else if (selection == 2) {
			DressOrder order = new DressOrder();
			order.makeOrder();
		}

		else if (selection == 3) {

		}

		else if (selection == 4) {

		}

		else {
			System.out.println("*** Thank you for visiting Dress Size Picker MenuList! ***");
			System.exit(0);
		}

	}

}
