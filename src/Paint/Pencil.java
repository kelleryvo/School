package Paint;

public class Pencil extends Pen {
	
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