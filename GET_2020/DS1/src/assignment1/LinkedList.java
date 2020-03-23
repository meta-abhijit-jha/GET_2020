package assignment1;

import java.util.Scanner;
import java.util.Random; 

public class LinkedList {
	
	private Node head = null;
	private int size = 0;
	
	boolean addNode(int data) {
		Node newNode = new Node(data, null);
		
		if(head == null) {
			head = newNode;
		} else {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
			
		}
		size += 1;
		return true;
	}
	
	public boolean isCyclePresent() {
		Node slow = head;
		Node fast = null;
		
		if(head.getNext() !=  null) {
			fast = head.getNext();
		} else {
			return false;
		}
		
		while(fast != null) {
			if( slow.equals(fast) )
				return true;
			slow = slow.getNext();
			fast = fast.getNext();
			if(fast.getNext() == null)
				return false;
			fast = fast.getNext();
		}
		return false;
	}
	
	
	void solveQuery(int left , int right, int rotation) {
		int length = right - left + 1;
		rotation = rotation % length;
		int stop = rotation + left - 1;
		if(right > size) {
			System.out.println("\nOperation Not Possible");
			return ;
		}
		else if(rotation == 0){
			return;
		}
		else {
			int count = 1;
			Node current = head;
			Node preleft = null;
			Node leftNode = null;
			Node stopNode = null;
			Node rightNode = null;
			
			while(count <= right) {
				
				if(count == left - 1) 
					preleft = current;
				
				if(count == stop)
					stopNode = current;

				if(count == right)
					rightNode = current;
				
				current = current.getNext();
				count += 1;
			}
			
			if(preleft != null) {
				leftNode = preleft.getNext();
			} else {
				leftNode = head;
			}
			

			if(preleft == null) {
				head = stopNode.getNext();
			} else
				preleft.setNext(stopNode.getNext());
			
			stopNode.setNext(rightNode.getNext());
			rightNode.setNext(leftNode);
	
		}
	}
	
		public void makeCyclicList() {
			Random rand = new Random();
			Node current = head;
			Node pre = null;
			int i = rand.nextInt(size);
			if(i == 0)
				i += 1;
			while(current.getNext() != null) {
				if(i == 0){
					pre = current;
				}
				current = current.getNext();
				i -= 1;
			}
			current.setNext(pre);
		}
		
		public void showList() {
			Node current = head;
			while(current != null) {
				System.out.print(current.getData()+"-->");
				current = current.getNext();
			}
		}
		
	
	public static void main(String [] args) {
		LinkedList list = new LinkedList();
		int choice = 0, data = 0, left, right, rotation;
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i < 10; i++)
			list.addNode(i);
		while(choice != 6) {
			System.out.println("\n1:Add node\n2:show List\n3:Query\n4:Make cyclic list\n5:Detect Cycle\n6:Exit\n");
			choice = sc.nextInt();
			switch(choice) {
				case 1 : System.out.println("\nEnter Data : ");
					data = sc.nextInt();
					list.addNode(data);
					break;
					
				case 2 : list.showList();
					break;
					
				case 3 : System.out.println("\nEnter L,R,Rotation : ");
					left = sc.nextInt();
					right = sc.nextInt();
					rotation = sc.nextInt();
					list.showList(); // List before Rotation
					list.solveQuery(left, right, rotation);
					System.out.println(); 
					list.showList(); // List After Rotation
					break;
					
				case 4 : list.makeCyclicList();
					break;
				case 5 : System.out.println(list.isCyclePresent());
					break;				
			}
		}
	}

}
