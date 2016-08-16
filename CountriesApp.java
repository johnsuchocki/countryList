package com.listofcountries;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		boolean userQuit = false;
		String menuInput = null;

		System.out.println("Welcome to Countries List");

		do {// "User has not quit" loop
			boolean inputValid = false;

			do {// "User input has not happened or is invalid" loop
				System.out.println("Menu:");
				System.out.println("Push (1) to display master list");
				System.out.println("Push (2) to add to list");
				System.out.println("Push (3) to delete from list");
				System.out.println("Push (4) to exit");
				menuInput = userInput.nextLine();
				inputValid = Validator.validateMenu(menuInput);
			} while (!(inputValid));

			switch (menuInput) {
			case "1": // Display master list
				ArrayList<String> masterListArray = new ArrayList<>();
				masterListArray = ReadWriteDelete.readMasterList();
				System.out.println("");
				System.out.println("Listed below are countries and capitals:");
				for (int i = 0; i < masterListArray.size(); i++) {
					System.out.println(masterListArray.get(i));
				}
				System.out.println("");
				break;
				
			case "2": // Add to master list
				String listInput;
				System.out.println("");
				System.out.println("WARNING: All inputs must be entered in country then capital pairs!");
				System.out.println("What country would you like to add to the list?");
				listInput = userInput.nextLine();
				ReadWriteDelete.writeCountryList(listInput);
				System.out.println("");
				System.out.println("What is the capital of that country?");
				listInput = userInput.nextLine();
				ReadWriteDelete.writeCapitalList(listInput);
				System.out.println("Input recieved.");
				System.out.println("");
				ReadWriteDelete.pushToMasterList();
				break;
				
			case "3": // Delete from master list
				int deleteInput;
				ArrayList<String> masterListDelete = new ArrayList<>();
				masterListDelete = ReadWriteDelete.readMasterList();
				
				System.out.println("Here are the country/capitals.");
				System.out.println("Enter the number corresponding to the row you would like to delete:");
				for (int i = 0; i < masterListDelete.size(); i++) {
					System.out.println(i + " " + masterListDelete.get(i));
				}
				deleteInput = Integer.parseInt(userInput.nextLine());
				if (deleteInput > (masterListDelete.size() - 1)) {
					System.out.println("Invalid input.");
					System.out.println("There is no row corresponding to that value.");
					System.out.println("");
				} else {
				ReadWriteDelete.deleteFromMasterList(deleteInput);
				}
				break;
				
			case "4": // Exit
				System.out.println("You have exited the Countries App.");
				System.out.println("See you next time!");
				userQuit = true;
				break;
			}

		} while (!(userQuit));

		userInput.close();
	}// main method

}// class
