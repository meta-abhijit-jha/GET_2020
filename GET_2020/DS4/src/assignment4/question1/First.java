package assignment4.question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Abhijit
 *
 */
public class First {

	
	
	public static void main(String[] args) {
		
		List <Employee> employees = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no. of employees : ");
		int noOfEmployees = sc.nextInt();
		
		String empId ;
		String name;
		String address;
		int i = 1;
		
		while(noOfEmployees > 0) {
			System.out.println("Enter Details of "+i+ "Employee empId , name , address: ");
			empId = sc.next();
			sc.nextLine();
			name = sc.nextLine();
			address = sc.nextLine();
			
			Employee emp = new Employee(empId, name, address);
			
			if( employees.contains(emp) ) 
				System.out.println("Employee Already Added with Given id.");
			else {
				employees.add(emp);
				System.out.println("Employee Added.");
				i += 1;
				noOfEmployees -= 1;
			}	
		}
		
		Collections.sort(employees);
		
		for(Employee emp : employees) {
			System.out.println( emp.toString() );
		}
		
		sc.close();

	}

}
