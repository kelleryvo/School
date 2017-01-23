package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class Pencil extends Pen {
	
	/**
	 * The Penil for Drawing
	 *
	 * @param	thickness	Thickness of the Pencil
	 * @param	red			Red of RGB
	 * @param	green		Green of RGB
	 * @param	blue		Blue of RBG
	 * 
	 */
	//Constructor
	public Pencil(double thickness, int red, int green, int blue) {
		super(thickness, red,green, blue);
	}
	public Pencil(double thickness, int red, int green, int blue, double transparency) {
		super(thickness, red,green, blue, transparency);
	}

	@Override
	public String drawLine() {
		// Draw line
		return "Pencil line drawed! ("+getColour().getColour()+", "+getThickness()+")";
	}

	@Override
	public String drawCircle() {
		// Draw circle
		return "Pencil circle drawed! ("+getColour().getColour()+", "+getThickness()+")";
	}

}
