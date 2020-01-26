import java.util.Scanner;
/**
 * StringImplemenation class has features to compare strings, reverse of string, case changing of string and to find largest word in a given string. 
 * @author Abhijit
 *
 */


public class StringImplementation {

	public static void main(String[] args) {

		System.out.println("Enter your choice\n1.To compare two strings 2.To reverse a string 3.To change uppercase into lowercase and vice versa\n"
				+ "Enter any other integer to find largest word in string ");
		try {
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			if(option == 1) {
				System.out.println("Enter First Input");
				Scanner input1 = new Scanner(System.in);
				String choice1 = input1.nextLine();
				System.out.println("Enter Second Input");
				Scanner input2 = new Scanner(System.in);
				String choice2 = input2.nextLine();
				System.out.println(stringCompare(choice1,choice2));
			} else {
				System.out.println("Enter String");
				Scanner input1 = new Scanner(System.in);
				String choice = input1.nextLine();
				if(option == 2) {
					System.out.print("Reverse of given string is: ");
					System.out.println(reverseString(choice));
				} else if(option == 3) {
					System.out.print("String after case changed: ");
					System.out.println(toCaseChange(choice));
				} else {
					System.out.print("largest word in given string is: ");
					char[] largestWord ; 
					largestWord = largestWord(choice);
					for(int i = 0; i < largestWord.length; i++) {
						System.out.print(largestWord[i]);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Error in input! Please restart application and enter defined inputs in integer");
		}
	}
	
	/**
	 * Compares two String 
	 * @param text1 is first string
	 * @param text2 is second string
	 * @return 0 if Strings are unequal
	 * @return 1 if Strings are equal
	 */
	
	static int stringCompare(String text1, String text2) {
		if(text1.length() == text2.length()) {
			for(int i = 0; i < text1.length(); i++) {
				if(text1.charAt(i) == text2.charAt(i)) {
					continue;
				} else {
					return 0;
				}
			}
		} else {
			return 0;
		}
		return 1;
	}
	
	/**
	 * Reverse the input String
	 * @param text takes String as input
	 * @return reversed String
	 */

	static char[] reverseString(String text) {
		int size = text.length();
		char array[] = new char[size];
		for(int i = 0; i < size; i++) {
			array[size - i - 1] = text.charAt(i);
		}		
		return array;
	}
	
	/**
	 * Convert uppercase of given string in lowercase and lowercase into uppercase
	 * @param text takes input as String
	 * @return converted String
	 */
	
	static char[] toCaseChange(String text) {
		int size = text.length();
		int asciiA = 65, asciiZ = 90, asciiSmallA = 97, asciiSmallZ = 122, convertCase = 32;
		char array[] = new char[size];
		for(int i = 0; i < size; i++) {
			char ch = text.charAt(i);
			int asciiValue = (int)ch;
			if( (asciiValue >= asciiSmallA) && (asciiValue <= asciiSmallZ) ) {
				array[i] = (char)(asciiValue - convertCase);
			} else if( (asciiValue >= asciiA) && (asciiValue <= asciiZ) ) {
				array[i] = (char)(asciiValue + convertCase);
			} else {
				array[i] = (char)(asciiValue);
			}
		}		
		return array;
	}

	/**
	 * Gives largest word in the input String, if more than two largest words then return the word that comes late 
	 * @param text takes input String
	 */
	
	static char[] largestWord(String text) {
		int size = text.length();
		int ascii = 0;
		int count = 0, endIndex = 0, maxCount = 0;
		for(int i = 0; i < size; i++) {
			char ch = text.charAt(i);
			ascii = (int)ch;
			if(ascii != 32) {
				count = count + 1;
				if(count >= maxCount) {
					maxCount = count;
					endIndex = i;
				} else {
					continue;
				}
			} else {
				count = 0;
			}
		}
		char[] largestWord = new char[maxCount];
		int index = 0;
		int start = endIndex - maxCount + 1;
		for(int i = start; i <= endIndex; i++) {
			largestWord[index] = text.charAt(i);
			index++;
		}
		return largestWord;
	}
	
}
