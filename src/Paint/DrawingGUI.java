package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Listeners.ListenForSlider;

public class DrawingGUI extends JFrame{
	
	JButton btnBrush, btnLine, btnEllipse, btnRectangle, btnBorderColor, btnFillColor;
	JLabel lblTransparency;
	static JSlider transSlider;
	
	DecimalFormat dec = new DecimalFormat("#.##");
	static Graphics2D graphSettings;
	static int currentActionType = 1;
	static float transparentVal = 1.0f;
	static Color strokeColor=Color.BLACK;
	static Color fillColor=Color.BLACK;

	//Konstruktor
	public DrawingGUI(){
		
		//GUI Einstellungen
        this.setSize(1000, 600);
        this.setTitle("Drawing Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Panel und Box f�r Buttons
        JPanel paButtons = new JPanel();
        Box boButtons = Box.createHorizontalBox();
        
        //Control Buttons erstellen
        btnBrush = createButton("./src/img/brush.png", 1);
        btnLine = createButton("./src/img/Line.png", 2);
        btnEllipse = createButton("./src/img/Ellipse.png", 3);
        btnRectangle = createButton("./src/img/Rectangle.png", 4);
        
        btnBorderColor = createButton("./src/img/border.png", 5, true);
        btnFillColor = createButton("./src/img/Fill.png", 6, false);
        
        //Buttons zu der Box hinzufuegen
        boButtons.add(btnBrush);
        boButtons.add(btnLine);
        boButtons.add(btnEllipse);
        boButtons.add(btnRectangle);
        boButtons.add(btnBorderColor);
        boButtons.add(btnFillColor);
        
        // Add the transparent label and slider
        
        lblTransparency = new JLabel("Transparent: 1");
        setTransSlider(new JSlider(1, 99, 99));
        ListenForSlider lForSlider = new ListenForSlider();
        getTransSlider().addChangeListener(lForSlider);
        boButtons.add(lblTransparency);
        boButtons.add(getTransSlider());
        
        //Button Box zu Panel hinzufuegen
        paButtons.add(boButtons);        
        this.add(paButtons, BorderLayout.SOUTH);
        
        // Make the drawing area take up the rest of the fram
        this.add(new DrawingBoard(), BorderLayout.CENTER);

        
        this.setVisible(true); 
	}
	
    public JButton createButton(String sIconPath, int iActionType){
    	JButton but = new JButton();
    	Dimension dim = new Dimension(50, 50);
    	
        but.setMaximumSize(dim);

        Icon butIcon = new ImageIcon(sIconPath);
        but.setIcon(butIcon);

        but.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				currentActionType = iActionType;
			}
        });
        
        return but;  
    }
    
    public JButton createButton(String iconFile, final int actionNum, final boolean stroke){
    	JButton theBut = new JButton();
        Icon butIcon = new ImageIcon(iconFile);
        theBut.setIcon(butIcon);
        
        theBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(stroke){					
					strokeColor = JColorChooser.showDialog(null,  "Pick a Stroke", Color.BLACK);
				} else {
					fillColor = JColorChooser.showDialog(null,  "Pick a Fill", Color.BLACK);
				}
				
			}
        });
        
        return theBut;  
    }
    
    //GET & SET

	public static JSlider getTransSlider() {
		return transSlider;
	}

	public void setTransSlider(JSlider transSlider) {
		this.transSlider = transSlider;
	}
	//CurrentActionType
	public static int getCurrentActionType(){
		return currentActionType;
	}
	public static void setCurrentActionType(int currentActionType){
		DrawingGUI.currentActionType= currentActionType;
	}
	//GraphSettings
	public static Graphics2D getGraphSettings(){
		return graphSettings;
	}
	public static void setGraphSettings(Graphics2D graphSettings){
		DrawingGUI.graphSettings = graphSettings;
	}
	//StrokeColor
	public static Color getStrokeColor(){
		return strokeColor;
	}
	public static void setStrokeColor(Color strokeColor){
		DrawingGUI.strokeColor = strokeColor;
	}
	//FillColor
	public static Color getFillColor(){
		return fillColor;
	}
	public static void setFillColor(Color fillColor){
		DrawingGUI.fillColor = fillColor;
	}
	//TransparentVal
	public static float getTransparentVal(){
		return transparentVal;
	}
	public static void setTransparentVal(float transparentVal){
		DrawingGUI.transparentVal = transparentVal;
	}
}
