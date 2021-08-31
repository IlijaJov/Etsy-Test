package random;

import java.util.Random;

public class RandomData {

	public static void main(String[] args) {
	}

	// Setting up a method that returns random name
	public static String randomName() {
		// Setting up a list with names
		String names[] = { "William", "Sophia", "Elijah", "Isabella", "James", "Dean", "Charlotte", "Benjamin",
				"Amelia", "Lucas", "Mia", "Mason" };

		// Returning a random name from list using Random function
		return (names[new Random().nextInt(names.length)]);
	}

	// Setting up a method that returns random item
	public static String randomItem() {
		
		// Setting up a list with items
		String items[] = { "keychain", "braclet", "wallet", "necklace", "shirt", "sunglasses" };
		
		// Returning a random item from list using Random function
		return (items[new Random().nextInt(items.length)]);
	}

	// Setting up a method that returns random password
	public static String randomPassword() {
		// Setting up a string that contains all letters and numbers
		String TextString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz1234567890";

		// Setting up a string builder that will be 8 characters long
		StringBuilder sb = new StringBuilder(8);

		// Setting up a for loop with 8 iterations
		for (int i = 0; i < 8; i++) {

			// Setting up a method that chooses random character from string using math
			// function
			int index = (int) (TextString.length() * Math.random());

			// Adding selected character to string builder
			sb.append(TextString.charAt(index));
		}
		// Returning string builder as string
		return sb.toString();
	}

	// Setting up a method that returns random email
	public static String randomEmail() {
		// Setting up a string that contains all letters and numbers
		String TextString = "abcdefghijklmnopqrstuvxyz1234567890";

		// Setting up a string builder that will be 8 characters long
		StringBuilder sb = new StringBuilder(8);

		// Setting up a for loop with 8 iterations
		for (int i = 0; i < 8; i++) {

			// Setting up a method that chooses random character from string using math
			// function
			int index = (int) (TextString.length() * Math.random());

			// Adding selected character to string builder
			sb.append(TextString.charAt(index));
		}
		// Returning string builder plus @gmail.com as string
		return sb.toString() + "@gmail.com";
	}

	// Setting up a method that returns random number
	public static String randomNumber() {

		// Defining min and max value
		int min = 1;
		int max = 8;

		// Choosing a random number from defined range with math function
		int randomNum = (int) (Math.random() * (max - min)) + min;

		// Returning random number as string
		return Integer.toString(randomNum);

	}

	// Setting up a method that returns random min number
	public static String randomMinNumber() {

		// Defining min and max value
		int min = 0;
		int max = 100;

		// Choosing a random min number from defined range with math function
		int minNumber = (int) (Math.random() * (max - min + 1) + min);

		// Returning random min number as string
		return Integer.toString(minNumber);
	}

	// Setting up a method that returns random name
	public static String randomMaxNumber() {

		// Defining min and max value
		int min = 100;
		int max = 200;

		// Choosing a random max number from defined range with math function
		int maxNumber = (int) (Math.random() * (max - min + 1) + min);

		// Returning random max number as string
		return Integer.toString(maxNumber);
	}

}
