package Controller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Paint.Brush;
import Paint.Colour;
import Paint.ColourFull;
import Paint.ColourTransparency;
import Paint.Draw;
import Paint.Pencil;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class Control {

	public static void main(String[] args) {
		Brush xy = new Brush(5, 234, 123, 240);
		print(xy.drawCircle());

		Pencil ab = new Pencil(6, 100, 255, 97);
		print(ab.drawLine());
		
		//Polymorphism
		Draw cd = new Brush(6, 200, 100, 255, 0.5);
		print(cd.drawLine());
		cd = new Pencil(6, 144, 200, 0, 0.7);
		print(cd.drawCircle());
		
		ColourFull clr = new ColourFull(255,123,99);
		//print(clr.setColour());
		print(clr.getColour());
		
		Colour trx = new ColourTransparency(123, 234, 255, 0.5);
		//print(trx.setColour());
		
		trx = new ColourFull(255,255,255);
		//Test 7jad
		 
		createAndShowGUI();
	}
	
	public static void print(Object content){
		System.out.println(content);
	}
	
    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    } 
}
