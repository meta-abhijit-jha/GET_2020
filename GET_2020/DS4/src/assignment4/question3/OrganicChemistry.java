package assignment4.question3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import assignment4.question3.Stack;
import assignment4.question3.StackImpl;

/**
 * 
 * @author Abhijit
 *
 */
public class OrganicChemistry {
	
	Map<Character,Integer> massOf = new HashMap<Character, Integer>();
	
	public int calculateMass(String formula) {
		massOf.put('O', 16);
		massOf.put('C', 12);
		massOf.put('H', 1);
		
	
		Stack<Integer> stack = new StackImpl<Integer>( formula.length() );
		
		int sum = 0;
		boolean flag = false;
		
		for(int index = 0 ; index < formula.length(); index++) {
			if( formula.charAt(index) == '(' || formula.charAt(index) == ')') {
				if(sum > 0)
					stack.push(sum);
				sum = 0;
				flag = false;
			}
			else if( Character.isDigit( formula.charAt(index) ) ) {
				int value = 0;
				int lastChar = index - 1;
				do {
					value = value * 10 +  ( Integer.valueOf( formula.charAt(index) ) - 48 );
					index += 1;
				} while( index < formula.length() && Character.isDigit( formula.charAt( index ) ) );
				
				index -= 1;
				int temp ;
				if(flag) {
					sum = sum + massOf.get( formula.charAt(lastChar) ) * (value - 1);
					flag = true;
				} else { 
					temp = stack.pop();
					temp =  temp * value;
					stack.push(temp);
					sum = 0;
					flag = false;
					}
				}
			else {
				sum += massOf.get( formula.charAt(index) );
				flag = true;
			}
			System.out.println( formula.charAt(index)+ " , "+sum );

		}
		
		int total = 0;
		if(flag)
			total = sum;
		
		while( !stack.isStackEmpty() ) {
			total += stack.pop();
		}
		return total;
	}

	public static void main(String[] args) {
		OrganicChemistry och = new OrganicChemistry();
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		while (choice != 2) {
			try {
				System.out.println("1.Calculate Mass of Formula\n2.Exit");
				System.out.println("\nEnter your choice ?");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter Formula : ");
					String formula = sc.nextLine();
					System.out.println( " Total Mass: "+ och.calculateMass(formula) );
					break;

				case 2:
					sc.close();
					break;
				default:
					System.out.println("\nEnter valid choice??\n");
				}
			} catch (Exception e) {
				System.out.println("Enter Valid Input.");
				sc.nextLine();
			}

		}
	}
}
