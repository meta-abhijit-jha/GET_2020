package recursion;
public class LCM_HCF {

	
	public static void main(String[] args) {
		System.out.println(hcf(105,150));
		System.out.println(lcm(105,150));

	}

	/**
	 * 
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
			int swapXY = inputY;
			inputY = inputX;
			inputX = swapXY;
			return hcf(inputX, inputY);
		}
	}
	
	/**
	 * 
	 * @param inputX
	 * @param inputY
	 * @return lcm of inputX and inputY
	 */
	
	static int lcm(int inputX, int inputY) {
		return (inputX * inputY) / hcf(inputX, inputY);
	}

}
