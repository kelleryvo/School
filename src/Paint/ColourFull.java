package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class ColourFull extends Colour {

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

	@Override
	public String getColour() {
		return "rgb("+getRed() + ", " + getGreen() + ", " + getBlue()+")";
	}

}
