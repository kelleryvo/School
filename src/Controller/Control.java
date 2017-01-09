package Controller;

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
	}
	
	public static void print(Object content){
		System.out.println(content);
	}
	
	//Ueberladung von Methoden
	public static void countOverload(int start){
		while(start<100){
			start++;
			print(start);
		}
	}
	
	public static void countOverload(int start, int end){
		while(start<end){
			start++;
			print(start);
		}
	}
	
	public static void countOverload(int start, String text){
		print(text);
		while(start<100){
			start++;
			print(start);
		}
	}
}
