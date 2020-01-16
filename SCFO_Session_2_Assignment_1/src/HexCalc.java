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

	public static void main(String[] args)
	{
		int choice;
		double decimalOne = 0, decimalTwo = 0;
		System.out.println("*******HEX_CALCULATOR*******");
		System.out.println("Please Enter Appropriate Option");
		System.out.println("1.Add 2.Subtract 3.Multiply 4.Divide 5.HEXtoDecimal\nEnter any other integer for comparison of HEX numbers\n");
		try{
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

	static void add(double first, double second) {
		double calc = first + second;
		System.out.println( convertDecToHex(calc) );
	}

	static void subtract(double first, double second) {
		double calc = first - second;
		System.out.println( convertDecToHex(calc) );
	}

	static void multiply(double first, double second) {
		double calc = first * second;
		System.out.println( convertDecToHex(calc) );
	}

	static void divide(double first, double second) {
		double calc = first / second;
		System.out.println( convertDecToHex(calc) );
	}

	static String verifyInput() {
		String hex;
		int count=0;
		Scanner input = new Scanner(System.in);
		hex = input.nextLine();
		for(int i = 0; i < hex.length(); i++) 
		{
			char ch = hex.charAt(i);
			int ascii = (int)ch;
			if( ((ascii >= 65) && (ascii <= 70)) || ((ascii >= 48) && (ascii <= 57)) ) {
				count = count+1;
			}else{
				break;
			}

		}

		String s;
		if(count==hex.length()){
			s= hex;

		}
		else{
			System.out.println("Wrong input enter string again");
			s=verifyInput();
		}
		return s;
	}

	static double convertHexToDec(String hex) {
		double decnum = 0,power = 0;
		for(int i = hex.length()-1; i >= 0; i--) {
			char ch = hex.charAt(i);
			double ascii = (int)ch;
			if(ascii >= 65) {
				decnum = decnum + (ascii - 55) * Math.pow(16,power);
				power = power + 1;
			} else {
				decnum = decnum + (ascii - 48) * Math.pow(16,power);
				power = power + 1;
			}
		}
		return decnum;
	}

	static String convertDecToHex(double dec) {
		String hex="";
		char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int rem,value;
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
		if( hex1.length() > hex2.length() ) {
			System.out.println("First number is larger");
		} else if( hex1.length() < hex2.length() ) {
			System.out.println("Second number is larger");
		} else {
			for(int i = 0; i < hex1.length(); i++) {
				if( hex1.charAt(i) == hex2.charAt(i) ) {
					continue;
				} else if( hex1.charAt(i) > hex2.charAt(i) ) {
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