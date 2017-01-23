package Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
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
		 
		//createAndShowGUI();
		
		new Paint.DrawingGUI();
	}
	
	/**
	 * Prints a given value as Object
	 *
	 * @param	content  	an Object with the value to print.
	 * @return  void
	 * @result  console 	Console-Output of given Content
	 */
	public static void print(Object content){
		System.out.println(content);
	}
	
    /*
    private static void createAndShowGUI() {
     
     
        System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Paint");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        
        JMenuBar menu = new JMenuBar();
        menu.add(new JMenu("Datei"));
        
        
        JMenuItem submenu = new JMenuItem("A text-only menu item");
        menu.add(submenu);
        
        f.setJMenuBar(menu);
        
        JToolBar tbar = new JToolBar();
        tbar.setSize(800, 20);
        tbar.add(new JButton("Drehen"));
        tbar.add(new JButton("Verkleinern"));
        tbar.add(new JButton("Vergrößern"));
        
        f.add(tbar, BorderLayout.PAGE_START);
        
        f.pack();
        f.setVisible(true);
    } 
    */
}
