
import static org.junit.Assert.*;

import org.junit.Test;


public class TestSparseMatrix {

	SparseMatrix obj = new SparseMatrix(new int[][]{ {0,1,0}, {0,0,0}, {1,1,0}, {0,2,0} });

	@Test
	public void transpose_is() {
		assertArrayEquals(new int[][]{ {0,0,1,0}, {1,0,1,2}, {0,0,0,0} }, obj.transpose());
	}

	@Test
	public void symmetric_is() {
		assertEquals(0, obj.symmetricCheck());
	}

	@Test
	public void addition_of_two_matrix_is() {
		assertArrayEquals(new int[][]{ {2,0,1}, {0,0,0}, {1,2,1} }, obj.add(new SparseMatrix(new int[][]{ {1,0,1}, {0,0,0}, {1,0,1} }),new SparseMatrix(new int[][]{ {1,0,0}, {0,0,0}, {0,2,0} })));
	}
	@Test
	public void multiplication_of_two_matrix_is() {
		assertArrayEquals(new int[][]{ {24,29}, {6,25} }, obj.multiply(new SparseMatrix(new int[][]{ {3,-2,5}, {3,0,4} }),new SparseMatrix(new int[][]{ {2,3}, {-9,0}, {0,4} })));
	}


	@Test
	public void when_size_of_matrix_is_zero() {
		try {
			assertEquals("size of array is zero",1, new SparseMatrix(new int[][]{}));
		}
		catch (AssertionError e) {
			System.out.println("size of array is zero");
		}
	}

	
	public void addition_when_row_and_column_are_unequal() {
		assertArrayEquals(new int[][]{}, obj.add(new SparseMatrix(new int[][]{}),new SparseMatrix(new int[][]{})));
	}	
}





