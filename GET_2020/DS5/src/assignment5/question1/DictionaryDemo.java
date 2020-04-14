package assignment5.question1;

import java.util.List;
import java.util.Scanner;

public class DictionaryDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Dictionary<Employee> dEmployees = new Dictionary<Employee>();
		
		dEmployees.insert(5, new Employee("1", "a", 1000, 20));
		dEmployees.insert(7, new Employee("2", "b", 700, 21));
		dEmployees.insert(3, new Employee("3", "c", 800, 22));
		dEmployees.insert(4, new Employee("4", "d", 9000, 20));
		dEmployees.insert(1, new Employee("5", "e", 2000, 19));
		dEmployees.insert(9, new Employee("6", "f", 1500, 18));
		dEmployees.insert(7, new Employee("7", "g", 1200, 23));
		dEmployees.insert(8, new Employee("8", "h", 1000, 25));
		dEmployees.insert(2, new Employee("9", "i", 1600, 24));
	
		
		
		int key;
		String empId ;
		String name;
		int  salary;
		int age;
		
		int choice = 0;
		
		while(choice != 6) {
			
			System.out.println("\n1:Add key - value pair\n2:Delete a key - value pair\n3:Find value by key\n4:Sorted List"
					+ " of Key-value Pairs\n5: Sorted List between keys k1 and k2\n6:Exit");
			
			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 : System.out.println("Enter key : "+ "Employee empId , name , salary, Age: ");
				key = sc.nextInt();
				empId = sc.next();
				sc.nextLine();       
				name = sc.nextLine();
				salary = sc.nextInt();
				age = sc.nextInt();
				Employee employee = new Employee(empId,name,salary,age);
				dEmployees.insert(key, employee);	
				break;
			case 2:
				System.out.println("Enter key which is to be deleted: ");
				key = sc.nextInt();
				Node<Employee> deleted =  dEmployees.delete(key);
				System.out.println(deleted.getKey() + ", " + deleted.getValue().toString());
				break;
			case 3:
				System.out.println("Enter key to find value : ");
				key = sc.nextInt();
				Node<Employee> emp = dEmployees.find(key);
				if(emp!=null) {
					System.out.println("Key : "+emp.key + " Value is "+emp.value.toString());
				}
				break;
			case 4:
				dEmployees.clearAll();
				List<Node<Employee>> list = dEmployees.inorder(dEmployees.getRoot());
				for(Node<Employee> value : list) {
					System.out.println(value.key + " , " + value.value);
				}
				break;
			case 5:
				int key1,key2;
				System.out.println("Enter min key : ");
				key1 = sc.nextInt();
				System.out.println("Enter max key : ");
				key2 = sc.nextInt();
				dEmployees.clearAll();
				List<Node<Employee>> sublist = dEmployees.sortedSubList(dEmployees.getRoot(),key1 , key2);
				for(Node<Employee> value : sublist) {
					System.out.println(value.key + " , " + value.value);
				}
				break;
			case 6:
				sc.close();
				break;
			default:
				
				System.out.println("Enter Valid Input");
				}

		}
	}

}
