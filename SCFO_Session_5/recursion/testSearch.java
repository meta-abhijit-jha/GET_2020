package recursion;

import static org.junit.Assert.*;
import org.junit.Test;

public class testSearch {
	Search searchObj = new Search();

	@Test
	public void expression1() {
		int[] inputArray = {1, 2, 3, 4, 5, 6};
		int element = 4, startIndex = 0, endIndex = inputArray.length - 1;
		int result = searchObj.binarySearch(inputArray, element, startIndex, endIndex);
		assertEquals(3, result);
	}

	@Test
	public void expression2() {
		int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8};
		int element = 8, startIndex = 0, endIndex = inputArray.length - 1;
		int result = searchObj.binarySearch(inputArray, element, startIndex, endIndex);
		assertEquals(7, result);
	}

	@Test
	public void expression3() {
		int[] inputArray = {1, 2, 3, 4, 5, 6};
		int element = 1, startIndex = 0, endIndex = inputArray.length - 1;
		int result = searchObj.binarySearch(inputArray, element, startIndex, endIndex);
		assertEquals(0, result);
	}

	@Test
	public void expression4() {
		int[] inputArray = {1, 2, 3, 4, 5, 6,7};
		int element = 0, startIndex = 0, endIndex = inputArray.length - 1;
		int result = searchObj.binarySearch(inputArray, element, startIndex, endIndex);
		assertEquals(-1, result);
	}

	@Test
	public void expression5() {
		int[] inputArray = {};
		int element = 5, startIndex = 0, endIndex = inputArray.length - 1;
		try {
			assertEquals("size of array is zero", 1, searchObj.binarySearch(inputArray, element, startIndex, endIndex));
		} catch (Exception ex) {
			System.out.println("Error in input");
		}
	}

	@Test
	public void expression6() {
		int[] inputArray = {6, 8, 5, 0, 9, 7};
		int element = 4, startIndex = 0;
		int result = searchObj.linearSearch(inputArray, element, startIndex);
		assertEquals(-1, result);
	}

	@Test
	public void expression7() {
		int[] inputArray = {6, 8, 5, 0, 9, 7};
		int element = 6, startIndex = 0;
		int result = searchObj.linearSearch(inputArray, element, startIndex);
		assertEquals(0, result);
	}

	@Test
	public void expression8() {
		int[] inputArray = {6, 8, 5, 0, 9, 7};
		int element = 7, startIndex = 0;
		int result = searchObj.linearSearch(inputArray, element, startIndex);
		assertEquals(5, result);
	}

	@Test
	public void expression9() {
		int[] inputArray = {6, 8, 5, 0, 9, 7};
		int element = 0, startIndex = 9;
		try {
			int result = searchObj.linearSearch(inputArray, element, startIndex);
			assertEquals(3, result);
		} catch (Exception ex) {
			System.out.println("wrong startIndex");
		}
	}

}
