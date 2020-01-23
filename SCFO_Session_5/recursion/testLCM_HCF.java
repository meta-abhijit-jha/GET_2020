package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class testLCM_HCF {
	LCM_HCF lcmObj = new LCM_HCF();
	LCM_HCF hcfObj = new LCM_HCF();

	@Test
	public void expression1() {
		int inputX = 150, inputY = 105;
		int result = lcmObj.lcm(inputX, inputY);
		assertEquals(1050, result);
	}
	
	@Test
	public void expression2() {
		int inputX = 105, inputY = 150;
		int result = lcmObj.lcm(inputX, inputY);
		assertEquals(1050, result);
	}
	
	@Test
	public void expression3() {
		int inputX = 100, inputY = 100;
		int result = lcmObj.lcm(inputX, inputY);
		assertEquals(100, result);
	}
	
	@Test
	public void expression4() {
		int inputX = 150, inputY = 0;
		try {
			assertEquals(1, lcmObj.lcm(inputX, inputY));
		} catch (Exception e) {
			System.out.println("LCM is only valid for natural numbers");
		}
	}
	
	@Test
	public void expression5() {
		int inputX = 0, inputY = 0;
		try {
			assertEquals(1, lcmObj.lcm(inputX, inputY));
		} catch (Exception e) {
			System.out.println("LCM is only valid for natural numbers");
		}
	}
	
	@Test
	public void expression6() {
		int inputX = 150, inputY = 105;
		int result = hcfObj.hcf(inputX, inputY);
		assertEquals(15, result);
	}
	
	@Test
	public void expression7() {
		int inputX = 105, inputY = 150;
		int result = hcfObj.hcf(inputX, inputY);
		assertEquals(15, result);
	}
	
	@Test
	public void expression8() {
		int inputX = 100, inputY = 100;
		int result = hcfObj.hcf(inputX, inputY);
		assertEquals(100, result);
	}
	
	@Test
	public void expression9() {
		int inputX = 150, inputY = 0;
		try {
			assertEquals(1, hcfObj.hcf(inputX, inputY));
		} catch (Exception e) {
			System.out.println("HCF is only valid for natural numbers");
		}
	}
	
	@Test
	public void expression10() {
		int inputX = 0, inputY = 0;
		try {
			assertEquals(1, hcfObj.hcf(inputX, inputY));
		} catch (Exception e) {
			System.out.println("LCM is only valid for natural numbers");
		}
	}

}
