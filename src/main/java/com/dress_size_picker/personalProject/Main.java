package com.dress_size_picker.personalProject;

public class Main{

	public static void main(String[] args) {

		MenuList menulist = new MenuList();

		System.out.println("**********Welcome to Dress Size Picker MenuList!**********");
		System.out.println("*************What would you like to do today?*************");

		while (true) {
			menulist.displayMenu();

			menulist.selection();

			System.out.println("*************What else would you like to do?***************");

		}

	}

}