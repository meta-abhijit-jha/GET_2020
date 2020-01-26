import java.util.*;

/**
 * Class area can calculate area of triangle, rectangle, square and circle.
 * @author Abhijit
 *
 */

public class Area {

	public static void main(String[] args) {
		System.out.println("***********Area of different shapes***********");
		chooseOption();
	}

	/**
	 * To recursively display chooseOption Menu 
	 */
	
	static void chooseOption() {
		System.out.println("\nEnter your choice\n1.Triangle 2.Rectangle 3.Square 4.Circle");
		try {
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch(choice) {
				case 1 : {
					System.out.print("Enter width: ");
					Scanner input1 = new Scanner(System.in);
					double width = input1.nextDouble();
					System.out.print("\nEnter height: ");
					Scanner input2 = new Scanner(System.in);
					double height = input2.nextDouble();
					System.out.printf("Area of triangle: %.2f\n",areaTriangle(width, height));
					break;
				}
				case 2 : {
					System.out.print("Enter width: ");
					Scanner input1 = new Scanner(System.in);
					double width = input1.nextDouble();
					System.out.print("\nEnter height: ");
					Scanner input2 = new Scanner(System.in);
					double height = input2.nextDouble();
					System.out.printf("Area of rectangle is: %.2f\n",areaRectangle(width, height));
					break;
				}
				case 3 : {
					System.out.print("Enter width: ");
					Scanner input1 = new Scanner(System.in);
					double width = input1.nextDouble();
					System.out.printf("Area of square is: %.2f\n",areaSquare(width));
					break;
				}
				case 4 : {
					System.out.print("Enter radius: ");
					Scanner input1 = new Scanner(System.in);
					double radius = input1.nextDouble();
					System.out.printf("Area of circle is: %.2f\n",areaCircle(radius));
					break;
				}
				default : {
					System.out.println("\nPlease choose the correct option");
					chooseOption();
					break;
				}
			}
			chooseOption();
		} catch(InputMismatchException ex) {
			System.out.println("Restart application and enter correct input");
		}
	}
	
	/**
	 * To calculate area of Triangle
	 * @param width of triangle
	 * @param height of triangle from it's base
	 * @return area of triangle
	 */
	
	static double areaTriangle(double width, double height) {
		return (0.5 * width) * height;
	}
	
	/**
	 * To calculate area of Rectangle
	 * @param width of rectangle
	 * @param height of rectangle
	 * @return area of rectangle
	 */
	
	static double areaRectangle (double width, double height) {
		return width * height;
	}
	
	/**
	 * To calculate area of Square
	 * @param width is the side of a square
	 * @return area of the square
	 */
	
	static double areaSquare(double width) {
		return width * width;
	}
	
	/**
	 * To calculate area of Circle
	 * @param radius of the circle
	 * @return area of the circle
	 */
	
	static double areaCircle(double radius) {
		return 3.14 * (radius * radius);         // Value of Pi is taken as 3.14 in this case
	}
	
}
