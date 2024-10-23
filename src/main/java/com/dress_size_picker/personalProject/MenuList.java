package com.dress_size_picker.personalProject;

import java.util.Scanner;

public class MenuList {

	// declaring variables

	Scanner scanner = new Scanner(System.in);

	// method to display Menulist

	public void displayMenu() {
		System.out.println("==========================================================");
		System.out.println("                1. Find your dress size.                  ");
		System.out.println("                2. Order a dress.                         ");
		System.out.println("                     3. Exit.                             ");
		System.out.println("==========================================================");
	}

	public void selection() {

			System.out.print("Enter your selection: ");
			String selection = scanner.nextLine();
				// selection is valid
			if (selection.equals("1")) {
					DressSizeSelector selector = new DressSizeSelector();
					selector.begin();
				} else if (selection.equals("2")) {
					DressOrder order = new DressOrder();
					order.makeOrder();

				} else if (selection.equals("3")) {
					System.out.println("*** Thank you for visiting Dress Size Picker MenuList! ***");
					System.exit(0);
				} else {
					System.out.println("Error: Please select 1,2 or 3!");
					selection();
				}

		}
	}
