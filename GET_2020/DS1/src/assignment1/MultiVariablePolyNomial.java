package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Abhijit
 *
 */

public class MultiVariablePolyNomial {
	private int number_of_var ;
	private int terms;
	private ArrayList<ArrayList<Integer>> deg;
	private ArrayList<Integer> cof;
	private String variable = "abcdefghijklmnopqrstuvwxyz";
	private char vars[] = variable.toCharArray();

	public MultiVariablePolyNomial(int number_of_var, int terms) {
		this.number_of_var = number_of_var;
		this.terms = terms;
		this.deg = new ArrayList<ArrayList<Integer>>();
		this.cof = new ArrayList<Integer>();
		
		for(int i = 0; i < number_of_var; i++) {
			deg.add(new ArrayList<Integer>());
		}

	}
	
	/**
	 * Function to add term in polynomial
	 * @param coef   Coefficient of term
	 * @param degrees List of  degrees of each variable
	 */
	public void addTerm(int coef, ArrayList<Integer>degrees) {
				
		cof.add(coef);
		for(int i = 0; i < number_of_var; i++) {
			deg.get(i).add(degrees.get(i));
		}
	}
	
	/**
	 * 
	 * @return  Degree of Polynomial
	 */
	public int getDegree() {
		int degree = 0;
		for(int term = 0; term < terms ; term ++ ) {
			int temp = 0;
			for(int d = 0; d < number_of_var; d ++ ) {
				temp += deg.get(d).get(term);
			}
			if(degree < temp) {
				degree = temp;
			}
		}
		return degree;
	}
	
	/**
	 * Function to display the polynomial
	 */
	public void display() {
		int termind = 0;
		
		for(int coef : cof) {

			if(termind > 0 && coef >= 0)
				System.out.print(" + ");
			
			System.out.print(coef);
			
			for(int ind = 0; ind < number_of_var; ind ++ ) {				
				int degree = deg.get(ind).get(termind);
				
				if(degree>0){
					System.out.print(vars[ind]+"^"+degree);
				}
			}
			
			
			termind += 1;
			
		}	
	}
	
	
	/**
	 * 
	 * Main function
	 */
	public static void main(String [] args) {
		System.out.println("Enter no. of variables in Polynomial: ");
		int numberOfVariables;
		Scanner sc = new Scanner(System.in);
		
		numberOfVariables = sc.nextInt();
		
		System.out.println("Enter no. of terms : ");
		int terms;
		terms = sc.nextInt();
		
		MultiVariablePolyNomial mpoly = new MultiVariablePolyNomial(numberOfVariables,terms);
		
		int coef;
		
		ArrayList<Integer> degrees = new ArrayList<Integer>();
		for(int k = 0; k < numberOfVariables; k ++ )
			degrees.add(0);
		
		for(int cof = 0; cof < terms; cof ++) {
			System.out.println("Enter "+(cof+1)+" term Coefficent : ");
			coef = sc.nextInt();
			for(int var = 0; var < numberOfVariables; var ++) {
				System.out.println((var+1)+"'s degree : ");
				int temp = sc.nextInt();
				degrees.set(var, temp);
				

			}
			mpoly.addTerm(coef, degrees);
			
		}
		int choice = 1 ;
		while(choice != 0) {
			System.out.println("\n1.Show poly\n2.Degree of poly\n0:Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1: mpoly.display();
						break;
				case 2: System.out.println("Degree  : "+mpoly.getDegree());
						break;
				default:
					sc.close();
			}
		}
		
		
	}
	
	

}
