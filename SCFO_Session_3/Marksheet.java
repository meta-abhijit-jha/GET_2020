import java.util.*;
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
				double gradeArray[] = new double[numOfStudents];
				for(int i = 0; i < numOfStudents; i++) {
					Scanner input1 = new Scanner(System.in);
					gradeArray[i] = input1.nextDouble();
					if ( (gradeArray[i] > 100.0) || (gradeArray[i] < 0.0) ) {
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
		} catch(InputMismatchException ex) {
			System.out.println("Restart application and enter correct input");
		} catch(ArithmeticException ey) {
			System.out.println("Arithmetic Error! Please check all inputs");
		}
	}

	/**
	 * To show chooseOption menu recursively
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of students
	 */

	static void chooseOption(int numOfStudents, double[] gradeArray) {
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
	 * To calculate average of grades
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return average grade of students
	 */
	
	static double average(int numOfStudents, double[] gradeArray) {
		double total = 0;
		for(int i = 0; i < numOfStudents; i++) {
			total = total + gradeArray[i];
		}
		return total / numOfStudents;
	}
	
	/**
	 * To calculate maximum grade among students
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return maximum grade among the students
	 */
	
	static double maximumGrade(int numOfStudents, double[] gradeArray) {
		double max = 0;
		for(int i = 0; i < numOfStudents; i++) {
			if(gradeArray[i] > max ) {
				max = gradeArray[i];
			}
		}
		return max;
	}

	/**
	 * To calculate minimum grade among students
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return minimum grade among the students
	 */
	
	static double minimumGrade(int numOfStudents, double[] gradeArray) {
		double min = 100;
		for(int i = 0; i < numOfStudents; i++) {
			if(gradeArray[i] < min ) {
				min = gradeArray[i];
			}
		}
		return min;
	}
	
	/**
	 * To calculate passing percentage of students
	 * @param numOfStudents for number of students in array
	 * @param gradeArray for grades of those students
	 * @return percentage of students passed in float
	 */

	static double studentPassingPercentage(int numOfStudents, double[] gradeArray) {
		double count = 0;
		for(int i = 0; i < numOfStudents; i++) {
			if(gradeArray[i] >= 40 ) {
				count++;
			}
		}
		return (count / numOfStudents) * 100;
	}

}