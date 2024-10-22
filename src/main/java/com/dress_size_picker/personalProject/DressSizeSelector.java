package com.dress_size_picker.personalProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DressSizeSelector {


	void begin() {
		double bust;
		double waist;
		double hips;

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter your measurements (inches):");

			System.out.print("Bust: ");
			bust = scanner.nextDouble();

			System.out.print("Waist: ");
			waist = scanner.nextDouble();

			System.out.print("Hips: ");
			hips = scanner.nextDouble();

			String size = pickSize(bust, waist, hips);
			if (size.equals("U")) {
				System.out.println("Our sizes range from S-XL. Unfortunately, we do not have a dress in your size.");
			} else {
				System.out.println("Your dress size is " + size);
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter a valid number!");
			scanner.nextLine();
			begin();
		} catch (Exception e) {
			// Catch any other unexpected exceptions
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}

//		System.out.println("Enter your measurements (inches):");
//		System.out.print("Bust: ");
//		bust = scanner.nextDouble();
//
//		System.out.print("Waist: ");
//		waist = scanner.nextDouble();
//
//		System.out.print("Hips: ");
//		hips = scanner.nextDouble();
//
//		String size = pickSize(bust, waist, hips);
//		if (size.equals("U")) {
//			System.out.println("Our sizes range from S-XL. Unfortunately, we do not have a dress in your size.");
//		} else {
//		System.out.println("Your dress size is " + size);
//		}


	private String pickSize(double bust, double waist, double hips) {
		int derivedBust = pickBustSize(bust);
		int derivedWaist = pickWaistSize(waist);
		int derivedHips = pickHipSize(hips);

		// if one of derivedBust, derivedWaist or derivedHips is -1, return U.
		if (derivedBust == -1 || derivedWaist == -1 || derivedHips == -1) {
			return "U";
		}
		int maxSize = Math.max(derivedBust, Math.max(derivedWaist, derivedHips));
		// convert 1 to S
		if (maxSize == 1) {
			return "S";
		}
		// convert 2 to M
		else if (maxSize == 2) {
			return "M";
		}
		// convert 3 to L
		else if (maxSize == 3) {
			return "L";
		}
		// convert 4 to XL
		else {
			return "XL";
		}

	}

	private int pickBustSize(double bust) {
		// compare b against S,M,L,XL values
		if (28 <= bust && bust <= 32) {
			return 1;
		}
		// if 28 <= b <= 32, return 1 (S)
		else if (32 < bust && bust <= 39) {
			return 2;
		}
		// if 32 < b <= 39, return 2 = M
		else if (39 < bust && bust <= 44) {
			return 3;
		}
		// if 39 < b <= 44, return 3 = L
		else if (44 < bust && bust <= 50) {
			return 4;
		}
		// if 44 < b <= 50, return 4 = XL
		else {
			return -1;
		}
		// else -1 = U
	}

	private int pickWaistSize(double waist) {
		// compare w against a chart
		// if 22 <= w <= 29, return S
		if (22 < waist && waist <= 29) {
			return 1;
		}
		// if 29 < w <= 35, return M
		else if (29 < waist && waist <= 35) {
			return 2;
		}
		// if 35 < w <= 40, return L
		else if (35 < waist && waist <= 40) {
			return 3;
		}
		// if 40 < w <= 52, return XL
		else if (40 < waist && waist <= 52) {
			return 4;
		} else {
			return -1;
		}
	}

	private int pickHipSize(double hips) {
		// compare h against a chart
		// if 38 <= h <= 42, return S
		if (38 < hips && hips <= 42) {
			return 1;
		}
		// if 42 < h <= 49, return M
		else if (42 < hips && hips <= 49) {
			return 2;
		}
		// if 49 < h <= 54, return L
		else if (49 < hips && hips <= 54) {
			return 3;
		}
		// if 54 < h <= 60, return XL
		else if (54 < hips && hips <= 60) {
			return 4;
		} else {
			return -1;
		}
	}



}


