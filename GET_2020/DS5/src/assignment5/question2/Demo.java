package assignment5.question2;

import java.util.Scanner;

import assignment5.question1.Employee;

public class Demo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LinkedList employeesList = new LinkedList();
		
		employeesList.addEmployee(new Employee("1","a",2000,13));
		employeesList.addEmployee(new Employee("2","b",2000,11));
		employeesList.addEmployee(new Employee("3","c",2000,12));
		employeesList.addEmployee(new Employee("4","d",2000,15));

		String empId ;
		String name;
		int  salary;
		int age;
		
		int choice = 0;
		
		while(choice != 5) {
			
			System.out.println("\n1:Add Employee to List\n2:Insertion Sort The List by salary\n3.Quick Sort\n4:Display List\n5:Exit");
			
			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 : System.out.println("Enter Employee empId , name , salary, Age: ");
				empId = sc.next();
				sc.nextLine();       
				name = sc.nextLine();
				salary = sc.nextInt();
				age = sc.nextInt();
				Employee employee = new Employee(empId,name,salary,age);
				employeesList.addEmployee(employee);
				break;
				
			case 2:
				employeesList.sortList(employeesList.getHead());
				employeesList.display();
				break;
			case 3:
				employeesList.sort(employeesList.getHead(), employeesList.getEnd());
				break;
			case 4:
				employeesList.display();
				break;
				
			case 5:
				sc.close();
				break;

			default:
				System.out.println("Enteor Valid Input");
			}	
		
		}


	}

}
