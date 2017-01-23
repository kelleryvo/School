package Listeners;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class ListenForSlider implements ChangeListener{
	
	// Called when the spinner is changed
	
	public void stateChanged(ChangeEvent e) {
	
		// Check if the source of the event was the button
	
		if(e.getSource() == Paint.DrawingGUI.getTransSlider()){
	
			// Change the value for the label next to the spinner
			// Use decimal format to make sure only 2 decimals are ever displayed
	
			transLabel.setText("Transparent: " + dec.format(transSlider.getValue() * .01) );
			
			// Set the value for transparency for every shape drawn after
			
			transparentVal = (float) (transSlider.getValue() * .01);
			
		}
	
	}
	
}