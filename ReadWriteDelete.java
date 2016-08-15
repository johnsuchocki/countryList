package com.listofcountries;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class ReadWriteDelete {
	// This class contains methods related to reading, writing, and deleting
	// from the capital list, country list, and master list

	public static ArrayList<String> readMasterList() {
		ArrayList<String> masterListArray = new ArrayList<>();

		Path masterListPath = Paths.get(
				"\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\masterCountryCapitalList.txt");
		File masterListFile = masterListPath.toFile();

		try (BufferedReader in = new BufferedReader(new FileReader(masterListFile))) {

			String location;
			while ((location = in.readLine()) != null) {
				masterListArray.add(location);
			}
		} catch (IOException masterExecption) {
			masterExecption.printStackTrace();
		}
		return masterListArray;
	}// method

	public static ArrayList<String> readCountryList() {
		ArrayList<String> countryList = new ArrayList<>();

		Path countryListPath = Paths
				.get("\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\countryList.txt");
		File countryListFile = countryListPath.toFile();

		try (BufferedReader in = new BufferedReader(new FileReader(countryListFile))) {

			String country;
			while ((country = in.readLine()) != null) {
				countryList.add(country);
			}
		} catch (IOException countryException) {
			countryException.printStackTrace();
		}
		return countryList;
	}// method

	public static ArrayList<String> readCapitalList() {
		ArrayList<String> capitalList = new ArrayList<>();

		Path capitalListPath = Paths
				.get("\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\capitalList.txt");
		File capitalListFile = capitalListPath.toFile();

		try (BufferedReader in = new BufferedReader(new FileReader(capitalListFile))) {

			String capital;
			while ((capital = in.readLine()) != null) {
				capitalList.add(capital);
			}
		} catch (IOException capitalException) {
			capitalException.printStackTrace();
		}
		return capitalList;
	}// method

	public static void writeCountryList(String userInput) {

		Path countryListPath = Paths
				.get("\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\countryList.txt");
		File countryListFile = countryListPath.toFile();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(countryListFile, true)))) {

			out.println(userInput);

		} catch (IOException countryException) {
			countryException.printStackTrace();
		}

	}// method

	public static void writeCapitalList(String userInput) {
		Path capitalListPath = Paths
				.get("\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\capitalList.txt");
		File capitalListFile = capitalListPath.toFile();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(capitalListFile, true)))) {

			out.println(userInput);

		} catch (IOException capitalException) {
			capitalException.printStackTrace();
		}
	}// method

	public static void pushToMasterList() {
		Path masterListPath = Paths.get(
				"\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\masterCountryCapitalList.txt");
		File masterListFile = masterListPath.toFile();

		ArrayList<String> countryListArray = readCountryList();
		ArrayList<String> capitalListArray = readCapitalList();
		ArrayList<String> masterList = new ArrayList<>();

		// compiles an array list of country/capital pairs
		for (int i = 0; i < countryListArray.size(); i++) {
			masterList.add(countryListArray.get(i) + ", " + capitalListArray.get(i));
		}

		// adds every value from the array list into the master list file
		for (int i = 0; i < masterList.size(); i++) {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(masterListFile, true)))) {

				out.println(masterList.get(i));

			} catch (IOException masterException) {
				masterException.printStackTrace();
			}

		} // for loop

		// deletes the temporary holder files to prevent duplicate information
		Path countryListPath = Paths
				.get("\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\countryList.txt");
		File countryListFile = countryListPath.toFile();
		countryListFile.delete();

		Path capitalListPath = Paths
				.get("\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\capitalList.txt");
		File capitalListFile = capitalListPath.toFile();
		capitalListFile.delete();
	}// method

	public static void deleteFromMasterList(int deletor) {
		Path masterListPath = Paths.get(
				"\\Users\\admin\\jeeneon\\week3notes\\week3notes\\src\\com\\listofcountries\\masterCountryCapitalList.txt");
		File masterListFile = masterListPath.toFile();
		ArrayList<String> masterListDelete = new ArrayList<>();
		
		masterListDelete = ReadWriteDelete.readMasterList();
		
		masterListDelete.remove(deletor);
		System.out.println("Row removed.");
		System.out.println("");
		
		masterListFile.delete();
		
		for (int i = 0; i < masterListDelete.size(); i++) {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(masterListFile, true)))) {

				out.println(masterListDelete.get(i));

			} catch (IOException masterException) {
				masterException.printStackTrace();
			}
		}
	}// method

}// class
