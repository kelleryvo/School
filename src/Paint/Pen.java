package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public abstract class Pen implements Draw{
	private Colour colour;
	private double thickness;
	
	//Constructor
	public Pen(double thickness, int red, int green, int blue){
		this.colour = new ColourFull(red,green,blue);
		this.thickness = thickness;
	}
	public Pen(double thickness, int red, int green, int blue, double transparency){
		this.colour = new ColourTransparency(red,green,blue,transparency);
		this.thickness = thickness;
	}
	
	//Methods
	public Colour getColour(){
		return colour;
	}
	
	public void setColour(Colour colour){
		this.colour = colour;
	}
	
	public double getThickness(){
		return thickness;
	}
	
	public void setThickness(double thickness){
		this.thickness = thickness;
	}
	
	public abstract String drawLine();
	public abstract String drawCircle();
}
