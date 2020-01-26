package recursion;
public class LCM_HCF {

	
	public static void main(String[] args) {
		System.out.println(hcf(150,350));
		System.out.println(lcm(105,150));

	}

	/**
	 * To calculate HCF of two numbers
	 * @param inputX
	 * @param inputY
	 * @return hcf of input X and input Y
	 */
	
	static int hcf(int inputX, int inputY) {
		int computedValue = 0;
		if(inputX >= inputY) {
			int rem = inputX % inputY;
			if(rem != 0) {
				return hcf(inputY, rem);
			} else {
				return inputY;
			}
		} else {
			return hcf(inputY, inputX);
		}
	}
	
	/**
	 * To calculate LCM of two numbers
	 * @param inputX
	 * @param inputY
	 * @return lcm of inputX and inputY
	 */
	
	static int lcm(int inputX, int inputY) {
		return (inputX * inputY) / hcf(inputX, inputY);
	}

}
