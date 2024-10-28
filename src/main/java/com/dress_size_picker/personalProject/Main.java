package com.dress_size_picker.personalProject;

public class Main {

	public static void main(String[] args) {
		MenuList menulist = new MenuList();
		System.out.println(Colors.info("**********Welcome to Dress Size Picker MenuList!**********"));
		System.out.println(Colors.info("*************What would you like to do today?*************"));

		while (true) {
			menulist.displayMenu();
			menulist.selection();

			System.out.println(Colors.info("\n*************What else would you like to do?***************"));

		}

	}

}