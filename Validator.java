package com.listofcountries;

public class Validator {

	public static boolean validateMenu(String menuInput) {
		switch (menuInput) {
		case "1":
		case "2":
		case "3":
		case "4":
			return true;
		default:
			System.out.println("You input is invalid, please try again");
			return false;
		}
	}
}
