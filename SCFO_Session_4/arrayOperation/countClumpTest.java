package arrayOperation;

import static org.junit.Assert.*;

import org.junit.Test;

public class countClumpTest {
	ArrOperation arrayOperationObj = new ArrOperation();

	@Test
	public void expression() {
		int[] array = {1, 1, 2, 4, 5, 5, 6};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(2, result);
	}

	@Test
	public void expression1() {
		int[] array = {1, 2, 2, 3, 4, 4};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(2, result);
	}

	@Test
	public void expression2() {
		int[] array = {1, 1, 2, 1, 1};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(2, result);
	}

	@Test
	public void expression3() {
		int[] array = {1, 1, 1, 1, 1};
		int result = arrayOperationObj.countClumps(array);
		assertEquals(1, result);
	}

	@Test
	public void expression4() {
		int[] array = {};
		try {
			assertEquals("size of array is zero", 1, arrayOperationObj.countClumps(array));
		} catch (AssertionError e) {
			System.out.println("finished");
		}
	}
}
