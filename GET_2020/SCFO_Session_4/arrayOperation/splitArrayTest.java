package arrayOperation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class splitArrayTest {
	ArrOperation arrayOperationObj = new ArrOperation();

	@Test
	public void expression() {
		int[] array = {1, 1, 1, 2, 1};
		int result = arrayOperationObj.splitArray(array);
		assertEquals(3, result);
	}

	@Test
	public void expression1() {
		int[] array = {2, 1, 1, 2, 1};
		int result = arrayOperationObj.splitArray(array);
		assertEquals(-1, result);
	}

	@Test
	public void expression2() {
		int[] array = {1, 2, 1, 4};
		int result = arrayOperationObj.splitArray(array);
		assertEquals(3, result);
	}

	@Test
	public void expression3() {
		int[] array = {};
		try {
			assertEquals("size of array is zero", 1, arrayOperationObj.splitArray(array) );
		} catch (AssertionError e) {
			System.out.println("finished");
		}
	}
}
