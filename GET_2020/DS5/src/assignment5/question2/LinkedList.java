package assignment5.question2;


import assignment5.question1.Employee;
/**
 * 
 * @author Abhijit
 *
 */
public class LinkedList {
	
	private Employee head ;
	private Employee tempHead ;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tempHead = null;
		this.setSize(0);
	}

	public Employee getHead() {
		return head;
	}


	public void setHead(Employee head) {
		this.head = head;
	}
	
	/**
	 * 
	 * @return Tail Node of Linked List
	 */
	public Employee getEnd() {
		Employee current = head;
		while(current.getNext()!=null)
			current = current.getNext();
		return current;
	}
	
	/**
	 * 
	 * @param emp1 Employee one 
	 * @param emp2 Employee two
	 * @return Employee whose salary is maximum
	 */
	public Employee maxEmployee(Employee emp1, Employee emp2) {
		if(emp1.getSalary() > emp2.getSalary()) {
			return emp1;
		} else if(emp1.getSalary() == emp2.getSalary()) {
			if(emp1.getAge() < emp2.getAge())
				return emp1;
			return emp2;
		}
		return emp2;
	}

	public void setData(Employee first , Employee second) {
		first.setEmpId(second.getEmpId());
		first.setName(second.getName());
		first.setSalary(second.getSalary());
		first.setAge(second.getAge());
	}
	
	public void swapData(Employee first,Employee second) {
		Employee temp = new Employee(first.getEmpId(),first.getName(),
				first.getSalary(),first.getAge());
		
		setData(first, second);
		setData(second, temp);
	}
	/**
	 * Function to add Node in Linked List.
	 * @param data  Value of Node
	 * @return  True if node is added otherwise False
	 */
	boolean addEmployee(Employee employee) {
		
		if(head == null) {
			head = employee;
		} else {
			Employee current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(employee);
			
		}
		setSize(getSize() + 1);
		return true;
	}
	
	
	/**
	 * 
	 * @param employee
	 * @return Insert Employee in sorted Linked List
	 */
	boolean insertInSortedOrder(Employee employee) {
		if(tempHead == null) {;
			tempHead = employee;
			tempHead.setNext(null);
			return true;
		} else {
			Employee current = tempHead;
			Employee pre = null;
			
			while(current != null &&
					maxEmployee(current,employee).equals(current)) {
				pre = current;
				current = current.getNext();
			}
			if(pre == null) {
				employee.setNext(current);
				tempHead = employee;
			} else {
				pre.setNext(employee);
				employee.setNext(current);
			}
			
			return true;
		}
	}	


	/**
	 * Sort the Linked List in Descending order of Salary
	 * @param head
	 * 
	 */
	public void sortList(Employee head) {
		tempHead = null;
		Employee current = head;
		while(current != null) {
			Employee next = current.getNext();
			insertInSortedOrder(current);
			if(next != null)
				current = next;
			else
				break;
		}
		this.head = tempHead;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Returns Pivot Value for Quick Sort
	 * @param start
	 * @param end
	 * @return pivot node
	 */
	Employee paritionLast(Employee start, Employee end) 
	{ 
		if(start == end || 
		start == null || end == null) 
			return start; 

		Employee pivot_prev = start; 
		Employee curr = start; 
		Employee pivot = end; 

		while(!start.equals(end)) 
		{ 
			if(maxEmployee(start, pivot).equals(start)) 
			{ 
				// keep tracks of last modified item 
				pivot_prev = curr; 
				swapData(start, curr);
				curr = curr.getNext(); 
			} 
			start = start.getNext(); 
		} 

		
		Employee temp = new Employee(curr.getEmpId(),curr.getName(),
				curr.getSalary(),curr.getAge());

		setData(curr, pivot);
		setData(end,temp);
		return pivot_prev; 
	} 

	/**
	 * Quick Sort Implementation
	 * @param start
	 * @param end
	 */
	void sort(Employee start, Employee end) 
	{ 
		if(start == end ) 
			return; 
			
		Employee pivot_prev = paritionLast(start, end); 
		if(pivot_prev!=null) {
		System.out.println("pivot-> "+pivot_prev.getEmpId());
		System.out.println("start-> " +start.getEmpId());
		System.out.println("End-> " +end.getEmpId());
		}
		sort(start, pivot_prev); 
		
		if( pivot_prev != null && 
			pivot_prev == start ) 
			sort(pivot_prev.getNext(), end); 
			
		else if(pivot_prev != null && 
				pivot_prev.getNext() != null) 
			sort(pivot_prev.getNext().getNext(), end); 
	} 


	/**
	 * Display the linked list.
	 */
	public void display() {
		
		Employee current = head;
		while(current != null) {
			System.out.println(current.toString());
			current = current.getNext();
		}
		
	}
}