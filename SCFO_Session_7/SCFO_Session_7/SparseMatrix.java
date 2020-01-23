import java.util.Arrays;
public final class SparseMatrix {

	private final int sparseArray[][];
	SparseMatrix(int[][] array){
		if ( array.length == 0 )
			throw new AssertionError();
		sparseArray = array.clone();
	}
	
	/**
	 * 
	 * @return copy of sparse array
	 */
	
	public int[][] getSparseArray() {
		return sparseArray.clone();
	}

	/**
	 * 
	 * @return triples(row, column, value) form of sparse matrix
	 */
	
	public int[][] storeNonZero() {
		int count = 0, tripleSize = 0;
		for(int i = 0; i < sparseArray.length; i++) {
			for(int j = 0; j < sparseArray[0].length; j++) {
				if(sparseArray[i][j] != 0) {
					tripleSize++;
				}
			}
		}
		int[][] triples = new int[3][tripleSize]; 
		for(int i = 0; i < sparseArray.length; i++) {
			for(int j = 0; j < sparseArray[0].length; j++) {
				if(sparseArray[i][j] != 0) {
					triples[0][count] = i;
					triples[1][count] = j;
					triples[2][count] = sparseArray[i][j];
					count++;
				}
			}
		}
		return triples;
	}

	/**
	 * 
	 * @return transpose from triples value
	 */
	
	public int[][] transpose() {
		int[][] transposeArray = new int[sparseArray[0].length][sparseArray.length];
		int rowIndex = 0, columnIndex = 1;
		int triples[][] = storeNonZero();
		for(int j = 0; j< triples[0].length; j++) {
			rowIndex = triples[1][j];
			columnIndex = triples[0][j];
			transposeArray[rowIndex][columnIndex] = triples[2][j]; 
		}
		return transposeArray;
	}

	/**
	 * 
	 * @return if symmetric returns 1 if not returns 0
	 */
	
	public int symmetricCheck() {
		int arr1[][] = sparseArray;
		int arr2[][] = transpose();
		if(Arrays.deepEquals(arr1, arr2)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @param s1 is first input matrix
	 * @param s2 is second input matrix
	 * @return addition of them but returns empty matrix if they are of unequal length
	 */

	public int[][] add(SparseMatrix s1, SparseMatrix s2) {
		int arr1[][] = s1.sparseArray;
		int arr2[][] = s2.sparseArray;
		int arr3[][] = new int[arr1.length][arr1[0].length];
		if((arr1.length == arr2.length) && (arr1[0].length == arr2[0].length)) {		
			for(int i = 0; i < arr1.length; i++) {
				for(int j = 0; j < arr1[0].length; j++) {
					arr3[i][j] = arr1[i][j] + arr2[i][j];
				}
			}
		}
		return arr3;
	}
	
	/**
	 * 
	 * @param s1 : first input matrix
	 * @param s2 : second input matrix
	 * @return multiplication iff they follow given condition if not returns empty array
	 */

	public int[][] multiply(SparseMatrix s1, SparseMatrix s2) {
		int arr1[][] = s1.sparseArray;
		int arr2[][] = s2.sparseArray;
		int arr3[][] = { {0,0}, {0,0} };
		if(arr1[0].length == arr2.length) {
			arr3 = new int[arr1.length][arr2[0].length];
			for (int i = 0; i < arr1.length; i++) { 
				for (int j = 0; j < arr2[0].length; j++) { 
					for (int k = 0; k < arr1[0].length; k++) { 
						arr3[i][j] += arr1[i][k] * arr2[k][j];
					}
				}
			}
		}
		return arr3;
	}
	
	public static void main(String[] args) {
		SparseMatrix s1 = new SparseMatrix(new int[][]{ {1,0,0}, {0,1,0}, {0,0,1} });
		int randomArray[][] = s1.transpose();
		System.out.println(s1.symmetricCheck()); 
		for(int i = 0; i < randomArray.length; i++) {
			for(int j = 0; j < randomArray[0].length; j++) {
				System.out.print(randomArray[i][j]+",");
			}
			System.out.println("\n");
		}
		SparseMatrix s2 = new SparseMatrix(new int[][]{ {0,0,0}, {3,1,0}, {4,0,1} });
		int addedArray[][] = s1.add(s1, s2);
		int multipliedArray[][] = s2.multiply(s1, s2);
		System.out.println("added array is:");
		for(int i = 0; i < addedArray.length; i++) {
			for(int j = 0; j < addedArray[0].length; j++) {
				System.out.print(addedArray[i][j]+",");
			}
			System.out.println("\n");
		}
		System.out.println("multiplied array is:");
		for(int i = 0; i < multipliedArray.length; i++) {
			for(int j = 0; j < multipliedArray[0].length; j++) {
				System.out.print(multipliedArray[i][j]+",");
			}
			System.out.println("\n");
		}
	}

}
