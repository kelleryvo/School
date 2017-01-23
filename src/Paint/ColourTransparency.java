package Paint;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class ColourTransparency extends Colour {

	private double transparency;
	
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

	@Override
	public String getColour() {
		return "rgba("+getRed() + ", " + getGreen() + ", " + getBlue()+ ", " + getTransparency() + ")";
	}

}
