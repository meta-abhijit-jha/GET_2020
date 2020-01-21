package arrayOperation;
import java.util.Scanner;


public class ArrOperation {


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

	static int[] fixXY(int[] inputArray, int inputX, int inputY) {
		int fixedArray[] = new int[inputArray.length];
		int index = 0;
		int swapArray[] = new int[inputArray.length];
		try {
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
		} catch(Exception ex) {
			System.out.println("Assertion error");
		}
		return fixedArray;
	}

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
