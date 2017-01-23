package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class Brush extends Pen {
	/**
	 * The Brush for Drawing
	 *
	 * @param	thickness	Thickness of the Brush
	 * @param	red			Red of RGB
	 * @param	green		Green of RGB
	 * @param	blue		Blue of RBG
	 * 
	 */
	//Constructor
	public Brush(double thickness, int red, int green, int blue) {
		super(thickness, red, green, blue);
	}
	public Brush(double thickness, int red, int green, int blue, double transparency) {
		super(thickness, red, green, blue, transparency);
	}

	@Override
	public String drawLine() {
		// Draw line
		return "Brush Line Drawed!("+getColour().getColour()+", "+getThickness()+")";
		
	}

	@Override
	public String drawCircle() {
		// Draw circle
		return "Brush Circle drawed! ("+getColour().getColour()+", "+getThickness()+")";
		
	}
}
