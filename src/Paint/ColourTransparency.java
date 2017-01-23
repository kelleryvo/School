package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class ColourTransparency extends Colour {

	private double transparency;
	
	/**
	 * Gets the RGB from the Superclass
	 *
	 * @param	red 			The red color of RBGA-Code
	 * @param	green 			The green color of RBGA-Code
	 * @param	blue 			The blue color of RBGA-Code
	 * @param	transparency 	The transparency of RGBA
	 */
	public ColourTransparency(int red, int green, int blue, double transparency) {
		super(red,green,blue);
		setTransparency(transparency);
	}
	
	public double getTransparency(){
		return transparency;
	}
	
	public void setTransparency(double transparency){
		this.transparency = transparency;
	}
	
	/*@Override
	public Boolean setColour(int red, int green, int blue, double transparency) {
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
		this.setTransparency(transparency);
		
		return true;
	}*/

	/**
	 * Gets the full RGBA-Code
	 *
	 * @param	getColour()		A String with the full RGBA-Code
	 * @return	RGBA-Code
	 */
	@Override
	public String getColour() {
		return "rgba("+getRed() + ", " + getGreen() + ", " + getBlue()+ ", " + getTransparency() + ")";
	}

}
