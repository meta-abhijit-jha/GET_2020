package assignment3.question2;

import java.util.Scanner;
/**
 * 
 * @author Abhijit
 *
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueueImpl priorityQueue = new PriorityQueueImpl(5);
		Scanner sc = new Scanner(System.in);
		int choice = 0;   
	    while(choice != 6)   
	    {     
	        System.out.println("\n*************************Main Menu*****************************");  
	        System.out.println("1.insert an element\n2.Delete an element\n3.Display the queue\n"
	        		+ "4.Is Queue Full\n5.Is queue Empty\n6.Exit");  
	        System.out.println("\nEnter your choice ?");  
	        choice = sc.nextInt();
	        switch(choice)  
	        {  
	            case 1: System.out.println("Enter Data : ");
	            		int data = sc.nextInt();
	            		priorityQueue.enqueue(data);
	    	            break;  
	        
	            case 2:  System.out.println("Deleted : "+priorityQueue.dequeue());
		            	break;  
		           
	            case 3: System.out.println("Queue is : ");
	            		priorityQueue.display();
	            		break;
	            case 4: System.out.println(priorityQueue.isFull());
	            		break;
	            case 5: System.out.println(priorityQueue.isEmpty());
        				break;
	            case 6: sc.close();
	            		break;
	            default:   
	            	System.out.println("\nEnter valid choice??\n");  
	        }
	    }
		
	}

}
