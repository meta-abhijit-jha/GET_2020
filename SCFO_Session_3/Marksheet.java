import java.util.Scanner;
/**
 * Marksheet class has features to calculate average, maximum grade, minimum grade and percentage of students passed for given grades of different students
 * @author Abhijit
 *
 */

public class Marksheet {

	public static void main(String[] args) {
		System.out.println("***********Marksheet***********");
		System.out.println("Please enter number of students");
		try {
			Scanner input = new Scanner(System.in);
			int numOfStudents = input.nextInt();
			if(numOfStudents > 0) {
				System.out.println("Enter their marks serial wise");
				int gradeArray[] = new int[numOfStudents];
				for(int i = 0; i < numOfStudents; i++) {
					Scanner input1 = new Scanner(System.in);
					gradeArray[i] = input1.nextInt();
					if ( (gradeArray[i] > 100) || (gradeArray[i] < 0) ) {
						System.out.println("Error in input, please re-enter grade between 0-100");
						i = i - 1;
					}
				}
				System.out.println("SerialNo. Grades");
				for(int i = 0; i < numOfStudents; i++) {
					System.out.println(" "+(i + 1)+".        "+gradeArray[i]);
				}
				chooseOption(numOfStudents, gradeArray);
			} else {
				System.out.println("Number of students can't be zero, Please restart the application");
			}
		} catch(Exception ex) {
			System.out.println("Restart application and enter correct input");
		}
	}

	/**
	 * To show chooseOption menu recursively
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of students
	 */

	static void chooseOption(int numOfStudents, int[] gradeArray) {
		System.out.println("Enter your choice\n1.Average 2.Maximum Grade 3.Minimum Grade 4.Percentage of Student Passed");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
			case 1 : {
				System.out.print("Average of grades is: ");
				System.out.printf("%.2f\n",average(numOfStudents, gradeArray));
				break;
			}
			case 2 : {
				System.out.println("Maximum grade is: "+maximumGrade(numOfStudents, gradeArray));
				break;
			}
			case 3 : {
				System.out.println("Minimum grade is: "+minimumGrade(numOfStudents, gradeArray));
				break;
			}
			case 4 : {
				System.out.print("Percentage of students passed is: ");
				System.out.printf("%.2f\n",studentPassingPercentage(numOfStudents, gradeArray));
				break;
			}
			default : {
				System.out.println("Please choose the correct option");
				chooseOption(numOfStudents, gradeArray);
				break;
			}
		}
		chooseOption(numOfStudents, gradeArray);
	}
	
	/**
	 * 
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return average grade of students
	 */
	
	static float average(int numOfStudents, int[] gradeArray) {
		float total = 0;
		for(int i = 0; i < numOfStudents; i++) {
			total = total + gradeArray[i];
		}
		float average = (float)(total / numOfStudents);
		return average;
	}
	
	/**
	 * 
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return maximum grade among the students
	 */
	
	static int maximumGrade(int numOfStudents, int[] gradeArray) {
		int max = 0;
		for(int i = 0; i < numOfStudents; i++) {
			if(gradeArray[i] > max ) {
				max = gradeArray[i];
			}
		}
		return max;
	}

	/**
	 * 
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return minimum grade among the students
	 */
	
	static int minimumGrade(int numOfStudents, int[] gradeArray) {
		int min = 100;
		for(int i = 0; i < numOfStudents; i++) {
			if(gradeArray[i] < min ) {
				min = gradeArray[i];
			}
		}
		return min;
	}
	
	/**
	 * 
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return percentage of students passed in float
	 */

	static float studentPassingPercentage(int numOfStudents, int[] gradeArray) {
		float count = 0;
		for(int i = 0; i < numOfStudents; i++) {
			if(gradeArray[i] >= 40 ) {
				count++;
			}
		}
		float passPercentage = (float)( (count / numOfStudents) * 100 );
		return passPercentage;
	}

}