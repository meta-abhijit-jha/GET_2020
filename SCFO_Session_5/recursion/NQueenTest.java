package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {
	NQueensProblem obj = new NQueensProblem();

	@Test
	public void when_negative_number_ispassed() {
		int n = -4;
		try {
			assertEquals("size of array is less than or equal tozero",1,obj.checkValid(n));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}

	@Test
	public void when_array_column_sizeofarray_arepassed() {
		int n = 6;
		int [][] board = new int[n][n];
		boolean res = obj.nQProblem(board , 0, n);
		assertEquals(true , res);
	}

	@Test
	public void when_array_column_sizeofarray_arepassed1() {
		int n = 2;
		int [][] board = new int[n][n];
		boolean res = obj.nQProblem(board , 0, n);
		assertEquals(false , res);
	}
}
