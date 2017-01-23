package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class ColourFull extends Colour {

	/**
	 * Gets the RGB from the Superclass
	 *
	 * @param	red 	The red color of RBG-Code
	 * @param	green 	The green color of RBG-Code
	 * @param	blue 	The blue color of RBG-Code
	 */
	public ColourFull(int red, int green, int blue) {
		super(red, green, blue);
	}

	/*@Override
	public Boolean setColour(int red, int green, int blue) {
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		
		return true;
	}*/

	/**
	 * Gets the full RGB-Code
	 *
	 * @param	getColour()		A String with the full RGB-Code
	 * @return	RGB-Code
	 */
	@Override
	public String getColour() {
		return "rgb("+getRed() + ", " + getGreen() + ", " + getBlue()+")";
	}

}
