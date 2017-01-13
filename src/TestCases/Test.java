package TestCases;

import static org.junit.Assert.*;

import Paint.Brush;

public class Test {
	//Yvo was here! Hello Maan
	@org.junit.Test
	public void testBrushGetColour() {
		Brush b1 = new Brush(1,254,255, 81);
		assertEquals(989, b1.getColour().getGreen());
	}

}
