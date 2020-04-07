package assignment4.question2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 
 * @author Abhijit
 *
 */
public class UniqueCharacters {

	Map<String, Integer> cache = new HashMap<String, Integer>();

	public int countUniqueCharacters(String string) {

		Map<Character, Integer> countCharacters = new HashMap<Character, Integer>();

		if ( cache.containsKey(string) ) {
			System.out.println( "From cache :" + cache.get(string) );
			return cache.get(string);
		}

		for (int i = 0; i < string.length(); i++) {
			if ( countCharacters.containsKey( string.charAt(i) ) ) {
				countCharacters.put( string.charAt(i), countCharacters.get( string.charAt(i) ) + 1 );
			} else {
				countCharacters.put( string.charAt(i), 1 );
			}
		}
		if ( countCharacters.containsKey(' ') )
			countCharacters.remove(' ');
		
		cache.put( string, countCharacters.size() );
		return countCharacters.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UniqueCharacters obj = new UniqueCharacters();

		int choice = 0;
		while (choice != 2) {
			try {
				System.out.println("1. Count Unique Chars in a String\n2.Exit");
				System.out.println("\nEnter your choice ?");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter String : ");
					String string = sc.nextLine();
					System.out.println( "Unique Characters: "+ obj.countUniqueCharacters(string) );
					break;

				case 2:
					sc.close();
					break;
				default:
					System.out.println("\nEnter valid choice??\n");
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Enter Valid Input.");
			}

		}
	}

}
