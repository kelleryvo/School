package TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import Paint.Colour;
import Paint.ColourFull;
import Paint.ColourTransparency;

public class ColourTests {

	
	@Test
	public void testCreateFullColour() {
		ColourFull c1 = new ColourFull(254,255,0);
		assertEquals(c1.getBlue(), 0);
	}
	
	@Test
	public void testCreateTransparencyColour() {
		ColourTransparency c1 = new ColourTransparency(254,255,0, 0.7);
		assertEquals(c1.getRed(), 254);
	}
	
	@Test
	public void testChangeColour() {
		Colour c1 = new ColourFull(254,255,0);
		c1 = new ColourFull(123,123,123);
		String output = c1.getColour();
		assertEquals("rgb(123, 123, 123)", output);
	}

}
