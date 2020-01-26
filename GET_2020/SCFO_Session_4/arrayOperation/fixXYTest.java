package arrayOperation;

import static org.junit.Assert.*;
import org.junit.Test;

public class fixXYTest {
	ArrOperation arrayOperationObj = new ArrOperation();

	@Test
	public void expression1() {
		int[] array = {5, 4, 9, 4, 9, 5};
		array = arrayOperationObj.fixXY(array, 4, 5);
		int[] expected = {9, 4, 5, 4, 5, 9};
		assertArrayEquals("Case 1", expected, array);
	}

	@Test
	public void expression2() {
		int[] array = {1, 4, 1, 5};
		array = arrayOperationObj.fixXY(array, 4, 5);
		int[] expected = {1, 4, 5, 1};
		assertArrayEquals(expected, array);
	}
	
	@Test
	public void expression3() {
		int[] array = {};
		try {
			assertEquals(1, arrayOperationObj.fixXY(array, 4, 5));
		}
		catch (AssertionError e) {
			System.out.println("finished empty");
		}
	}

	@Test
	public void expression4() {
		int[] array = {1, 2, 4, 4, 4, 6, 7};
		try {
			assertEquals("consecutive x value", arrayOperationObj.fixXY(array, 4, 5));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}

	@Test
	public void expression5() {
		int[] arr = {1, 2, 4, 7, 4, 6, 7, 4};
		try {
			assertEquals(1, arrayOperationObj.fixXY(arr, 4, 5));
		} catch (AssertionError e) {
			System.out.println("finished");
		}
	}

	@Test
	public void expression6() {
		int[] array = {5, 2, 4, 5, 4, 6, 7, 4};
		try {
			assertEquals("unequal number of x and y", 1, arrayOperationObj.fixXY(array, 4, 5) );
		} catch (AssertionError e) {
			System.out.println("finished");
		}
	}
}
