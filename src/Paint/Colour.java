package Paint;

public abstract class Colour {
	private int red;
	private int green;
	private int blue;
	
	//Constructors
	public Colour(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	/**
	 * 
	 * @return values of Object Colour
	 */
	//Methods
	public int getRed(){
		return red;
	}
	public int getGreen(){
		return green;
	}
	public int getBlue(){
		return blue;
	}
	
	public void setRed(int red){
		this.red = red;
	}
	public void setGreen(int green){
		this.green = green;
	}
	public void setBlue(int blue){
		this.blue = blue;
	}
	
	//public abstract String setColour();
	public abstract String getColour();
}
