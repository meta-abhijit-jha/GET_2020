package assignment6;

public class Poly {
	private final int polyArray[][];	
	Poly(int[][] array) {
		if ( array.length == 0 )
			throw new AssertionError();
		polyArray = array.clone();
	}

	/**
	 * To get copy of Polynomial Array
	 * @return clone of polyArray
	 */
	
	public int[][] getPolyArray() {
		return polyArray.clone();
	}

	/**
	 * To Sort the array
	 * @param array 
	 * @return sorted array
	 */
	
	private int[][] sorting(int[][] array) {
		int swapDegree, swapCoefficient, len = array.length;
		for ( int i = 0; i < len - 1; i++ ) 
			for ( int j = 0; j < len - 1; j++ )
				if ( array[j][1] < array[j + 1][1] ) {
					swapCoefficient = array[j + 1][0];
					array[j + 1][0] = array[j][0];
					array[j][0] = swapCoefficient;
					swapDegree = array[j + 1][1];
					array[j + 1][1] = array[j][1];
					array[j][1] = swapDegree;
				}
		return array;
	}
	
	/**
	 * To evaluate and return the value of the polynomial for the given value of the variable
	 * @param num
	 * @return value according to variable
	 */

	public int evaluate(float num) {
		float totalSum = 0;
		for ( int i = 0; i < polyArray.length; i++ )
			totalSum += polyArray[i][0] * Math.pow(num, polyArray[i][1]);
		return (int)totalSum;
	}
	
	/**
	 * To count degree
	 * @return return the degree of the polynomial
	 */

	public int degree() {
		int[][] arr = sorting(this.polyArray);
		return arr[0][1];
	}
	
	/**
	 * To add two Polynomials
	 * @param obj1
	 * @param obj2
	 * @return sum of two polynomials
	 */

	public int[][] addPoly(Poly obj1, Poly obj2) {
		int array1[][] = sorting(obj1.polyArray), i = 0, j = 0, k = 0;
		int[][] array2 = sorting(obj2.polyArray);
		int addArray[][] = new int[array1.length + array2.length][2];

		while( i < array1.length && j < array2.length) {
			if ( array1[i][1] == array2[j][1] ) {
				addArray[k][0] = array1[i][0] + array2[j][0];
				addArray[k][1] = array1[i][1];
				i++;
				k++;
				j++;
			} else if ( array1[i][1] > array2[j][1]) {
				addArray[k][0] = array1[i][0];
				addArray[k][1] = array1[i][1];
				i++; 
				k++;
			} else {
				addArray[k][0] = array2[j][0];
				addArray[k][1] = array2[j][1];
				k++;
				j++;
			}
		}
		while ( i < array1.length ) {
			addArray[k][0] = array1[i][0];
			addArray[k][1] = array1[i][1];
			k++;
			i++;
		}
		while( j < array2.length ) {
			addArray[k][0] = array2[j][0];
			addArray[k][1] = array2[j][1];
			j++;
			k++;
		}
		for ( i = 0; i < addArray.length; i++ )
			System.out.println("additon " +addArray[i][0] + addArray[i][1]);
		return addArray;
	}
	
	/**
	 * To multiply two polynomials
	 * @param obj1
	 * @param obj2
	 * @return product of obj1 and obj2
	 */

	public int[][] multiplyPoly(Poly obj1, Poly obj2) {
		int array1[][] = sorting(obj1.polyArray), coefficient = 0, power = 0;
		int[][] array2 = sorting(obj2.polyArray);
		int size = array1[0][1] + array2[0][1];
		int multiArray[][] = new int[size + 1][2];
		for(int i = 0; i < array1.length; i++)
			for(int j = 0; j < array2.length; j++) {
				coefficient = array1[i][0] * array2[j][0];
				power = array1[i][1] + array2[j][1];
				multiArray[power][0] += coefficient;
				multiArray[power][1] = power;
			}
		for ( int i = 0; i < multiArray.length; i++ )
			System.out.println("multiply " +multiArray[i][0] + multiArray[i][1]);
		return multiArray;
	}

}
