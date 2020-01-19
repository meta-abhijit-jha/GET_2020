import java.util.Scanner;
import java.lang.Math;

/**HexCalc Contains features for Arithmetic and comparison operations of hexadecimal numbers, it can also convert a HEX number into decimal.
 * @method main() contains Cases for different operations.
 * @method verifyInput1() will check a HEX number for it's validity.
 * @method hexToDec() will convert HEX into decimals and decToHex() does vice-versa of it.
 * @method comparison() compares two already verified Hex Strings.
 * 
 */


public class HexCalc {

	public static void main(String[] args) {
		int choice;
		int decimalOne = 0, decimalTwo = 0;
		System.out.println("*******HEX_CALCULATOR*******");
		System.out.println("Please Enter Appropriate Option");
		System.out.println("1.Add 2.Subtract 3.Multiply 4.Divide 5.HEXtoDecimal\nEnter any other integer for comparison of HEX numbers\n");
		try {
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			if(choice <= 4) {
				System.out.println("Enter first number");
				String hex1 = verifyInput();
				decimalOne = convertHexToDec(hex1);
				System.out.println("Enter second number");
				String hex2 = verifyInput();
				decimalTwo = convertHexToDec(hex2);
			}
			switch(choice) {
				case 1: {
					add(decimalOne,decimalTwo);
					break;
				}
				case 2: {
					subtract(decimalOne,decimalTwo);
					break;
				}
				case 3: {
					multiply(decimalOne,decimalTwo);
					break;
				}
				case 4: {
					divide(decimalOne,decimalTwo);
					break;
				}
				case 5: {
					System.out.println("Enter number you want to convert");
					String hex1 = verifyInput();
					System.out.println( "Converted number is : "+convertHexToDec(hex1) );
					break;
				}
				default: {
					comparison();
				}
			}
		} catch(Exception ex) {
			System.out.println("Please restart application with correct input");
		}
	}

	static void add(int first, int second) {
		int calc = first + second;
		System.out.println( "Addition of given numbers: "+convertDecToHex(calc) );
	}

	static void subtract(int first, int second) {
		int calc = first - second;
		System.out.println( "Subtraction of given numbers: "+convertDecToHex(calc) );
	}

	static void multiply(int first, int second) {
		int calc = first * second;
		System.out.println( "Multiplication of given numbers: "+convertDecToHex(calc) );
	}

	static void divide(int first, int second) {
		int calc = first / second;
		System.out.println( "Division of given numbers: " +convertDecToHex(calc) );
	}

	static String verifyInput() {
		String hex;
		int count = 0, asciiA = 65, asciiF = 70, asciiZero = 48, asciiNine = 57;
		Scanner input = new Scanner(System.in);
		hex = input.nextLine();
		for(int i = 0; i < hex.length(); i++) 
		{
			char ch = hex.charAt(i);
			int asciiValue = (int)ch;
			if( ((asciiValue >= asciiA) && (asciiValue <= asciiF)) || ((asciiValue >= asciiZero) && (asciiValue <= asciiNine)) ) {
				count = count + 1;
			} else {
				break;
			}

		}
		String s;
		if(count == hex.length()) {
			s = hex;
		} else {
			System.out.println("Wrong input enter string again");
			s = verifyInput();
		}
		return s;
	}

	static int convertHexToDec(String hex) {
		double power = 0;
		int decNum = 0;
		for(int i = hex.length() - 1; i >= 0; i--) {
			char ch = hex.charAt(i);
			int asciiValue = (int)ch;
			if(asciiValue >= 65) {
				decNum = decNum + (asciiValue - 55) * (int)Math.pow(16,power);  //asciiValue-55 will give value 10 for 'A' , 11 for 'B' and so on...
			} else {
				decNum = decNum + (asciiValue - 48) * (int)Math.pow(16,power);  //asciiValue-48 will give 0-9 values for string '0'.....'9' 
			}
			power = power + 1;
		}
		return decNum;
	}

	static String convertDecToHex(int dec) {
		String hex = "";
		char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int rem, value;
		value = (int)dec;
		while(value > 0)  
		{  
			rem = value % 16;   
			hex = hexchars[rem] + hex;   
			value = value / 16;  
		}  
		return hex;
	}

	static void comparison() {
		System.out.println("Please input first number");
		String hex1 = verifyInput();
		System.out.println("Please input second number");
		String hex2 = verifyInput();
		int countHex1 = 0, countHex2 = 0;
		for(int i = 0; i < hex1.length(); i++) {
			if(hex1.charAt(i) == '0'){
				countHex1++;	
			} else {
				break;
			}
		}
		for(int i = 0; i < hex2.length(); i++) {
			if(hex2.charAt(i) == '0'){
				countHex2++;	
			} else {
				break;
			}
		}
		if( (hex1.length() - countHex1) > (hex2.length() - countHex2) ) {
			System.out.println("First number is larger");
		} else if( (hex1.length() - countHex1) < (hex2.length() - countHex2) ) {
			System.out.println("Second number is larger");
		} else {
			for(int i = hex1.length() - countHex1 - 1; i < hex1.length(); i++) {
				if( (hex1.charAt(i) - countHex1) == (hex2.charAt(i) - countHex2) ) {
					continue;
				} else if( (hex1.charAt(i) - countHex1) > (hex2.charAt(i) - countHex2) ) {
					System.out.println("First number is larger");
					break;
				} else {
					System.out.println("Second number is larger");
					break;
				}
			}
		}
	}
}