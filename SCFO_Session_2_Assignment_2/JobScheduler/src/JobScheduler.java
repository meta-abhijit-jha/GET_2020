/**
 * Class JobScheduler contains features for calculation of Completion Time, Waiting Time, Turn Around Time after applying FCFS Algorithm by given array of inputs
 * @method fcfs() to implement First Come First Serve Algorithm, it takes arrival time and burst time of each process in Array as input.
 * @method avgWaitingTime() to Calculate average waiting time
 * @method maxWaitingTime() to Calculate maximum waiting time
 *
 */

import java.util.Scanner;
public class JobScheduler {

	public static void main(String[] args) {
		System.out.println("FCFS Job Scheduler\n");
		fcfs();
	}

	static void fcfs() {
		System.out.println("Enter number of processes");
		try { 
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			System.out.println("Enter Array");
			int inputArray[][] = new int[num][2];
			for(int i = 0, j = 0; i < num; i++) {
				Scanner input1 = new Scanner(System.in);
			    inputArray[i][j] = input1.nextInt();
			    Scanner input2 = new Scanner(System.in);
			    inputArray[i][j + 1] = input2.nextInt();
			}
			System.out.println("\narrival  burst\n time    time");
			for(int i = 0, j = 0; i < num; i++) {
				System.out.println("  ["+inputArray[i][j]+"]    ["+inputArray[i][j + 1]+"]");
				System.out.print("\n");
			}
			int completion[] = new int[num];
			int turnAround[] = new int[num];
			int waiting[] = new int[num];
			for(int i = 0, j=0; i < num; i++) {
				if(i == 0) {
					completion[i] = inputArray[i][j + 1] + inputArray[i][j];
					waiting[i] = 0;
				} else {
					if(completion[i - 1] >= inputArray[i][j]) {
						waiting[i] = completion[i - 1] - inputArray[i][j];
						completion[i] = completion[i - 1] + inputArray[i][j + 1];
					} else {
						waiting[i] = 0;
						completion[i] = inputArray[i][j + 1] + inputArray[i][j];
					}
				}
				turnAround[i] = completion[i] - inputArray[i][j];
				System.out.println("Process number "+(i + 1));
				System.out.println("Completion time: "+completion[i]);
				System.out.println("Waiting time: "+waiting[i]);
				System.out.println("Turn Around time: "+turnAround[i]+"\n");
			}
			System.out.println("Average Waiting time "+avgWaitingTime(waiting,num));
			System.out.println("Maximum waiting time period "+maxWaitingTime(waiting,num));
		}catch(Exception ex) {
			System.out.println("Please enter correct input");
			fcfs();
		}
	}

	static float avgWaitingTime(int[] waiting, int num) {
		float total = 0;
		float avg = 0;
		for(int i = 0; i < num; i++) {
			total = total + waiting[i];
		}
		avg = total / num;
		return avg;
	}

	static int maxWaitingTime(int[] waiting,int num) {
		int max = 0;
		for(int i = 0; i < num; i++) {
			if(waiting[i] > max) {
				max = waiting[i];
			}
		}
		return max;
	}
}