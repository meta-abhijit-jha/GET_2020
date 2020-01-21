package arrayOperation;
import java.util.Scanner;

/**
 * Class ArrOperation has features to count clumps, fix an array by inputX and inputY, split an array and also to count maximum mirror image
 * @author Abhijit
 *
 */

public class ArrOperation {

	/**
	 * 
	 * @param inputArray takes array as input
	 * @return number of clumps(2 or more adjacent integers are same) in the same array
	 */

	static int countClumps(int[] inputArray) {
		int count = 0, clumps = 0;
		for(int i = 0; i < inputArray.length - 1; i++) {
			if(inputArray[i] == inputArray[i+1]) {
				count++;
			} else {
				count = 0;
			} if(count == 1) {
				clumps++;
			}
		}
		return clumps;
	}

	/**
	 * 
	 * @param inputArray takes array as input
	 * @param inputX is the value whose position can't be changed
	 * @param inputY is the value which comes just after inputX
	 * @return fixedArray which is after fixing array according to inputX and inputY 
	 */

	static int[] fixXY(int[] inputArray, int inputX, int inputY) {
		int fixedArray[] = new int[inputArray.length];
		int index = 0;
		int swapArray[] = new int[inputArray.length];
		if (inputArray.length == 0) {
			throw new AssertionError();
		}
		if(inputArray[inputArray.length-1] != inputX) {
			for(int i = 0; i < inputArray.length; i++) {
				if(inputArray[i] == inputX) {
					fixedArray[i] = inputArray[i];
					fixedArray[i + 1] = inputY;
				} else if(inputArray[i] == inputY) {
					continue;
				} else {
					swapArray[index] = inputArray[i];
					index++;
				}
			}
			index = 0;
			for(int i = 0; i < inputArray.length; i++) {
				if(fixedArray[i] == 0) {
					fixedArray[i] = swapArray[index];
					index++;
				}
			}
		} else {
			throw new AssertionError();
		}
		return fixedArray;
	}

	/**
	 * 
	 * @param inputArray is the array we take as input
	 * @return the position where array split into equal halves of sum
	 */

	static int splitArray(int[] inputArray) {
		int total = 0, value = 0;
		for(int i = 0; i < inputArray.length; i++) {
			total = total + inputArray[i];
		}
		if(total % 2 == 0) {
			for(int i = 0; i < inputArray.length; i++) {
				value = value + inputArray[i];
				if(value == (total / 2)) {
					return i + 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param inputArray takes array as input
	 * @return maximum mirror image in the given inputArray
	 */

	static int maxMirror(int[] inputArray) {
		int count = 0, i = 0, j = 0, maxCount = -1;
		for (i = 0; i < inputArray.length; i++) {
			count = 0;
			int indexFromStart = i;
			for (j = inputArray.length - 1; j >= 0 && indexFromStart<inputArray.length; j--) {
				if (inputArray[indexFromStart] == inputArray[j]) {
					indexFromStart++;
					count++;
				} else {
					if(count > maxCount ) {
						maxCount = count;
					}
					count = 0;
					indexFromStart = i + 1;
					if(inputArray[i] == inputArray[j]) {
						count += 1;
					}
				}
			}
			if(count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

}
