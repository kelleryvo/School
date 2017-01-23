package Paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class DrawingBoard extends JComponent {

	// ArrayLists that contain each shape drawn along with
	// that shapes stroke and fill

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	ArrayList<Color> shapeFill = new ArrayList<Color>();
	ArrayList<Color> shapeStroke = new ArrayList<Color>();
	ArrayList<Float> transPercent = new ArrayList<Float>();

	Point drawStart, drawEnd;

	// Monitors events on the drawing area of the frame
	
	/**
	 * Defines the start and end point
	 *
	 * @param	drawStart 		Start point for drawing shapes
	 * @param	drawEnd			End point for drawing shapes
	 */
	public DrawingBoard() {

		this.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				if (Paint.DrawingGUI.getCurrentActionType() != 1) {

					// When the mouse is pressed get x & y position

					drawStart = new Point(e.getX(), e.getY());
					drawEnd = drawStart;
					repaint();

				}

			}

			public void mouseReleased(MouseEvent e) {

				if (Paint.DrawingGUI.getCurrentActionType() != 1) {

					// Create a shape using the starting x & y
					// and finishing x & y positions

					Shape aShape = null;

					if (Paint.DrawingGUI.getCurrentActionType() == 2) {
						aShape = drawLine(drawStart.x, drawStart.y, e.getX(), e.getY());
					} else

					if (Paint.DrawingGUI.getCurrentActionType() == 3) {
						aShape = drawEllipse(drawStart.x, drawStart.y, e.getX(), e.getY());
					} else

					if (Paint.DrawingGUI.getCurrentActionType() == 4) {

						// Create a new rectangle using x & y coordinates

						aShape = drawRectangle(drawStart.x, drawStart.y, e.getX(), e.getY());
					}

					// Add shapes, fills and colors to there ArrayLists

					shapes.add(aShape);
					shapeFill.add(Paint.DrawingGUI.getFillColor());
					shapeStroke.add(Paint.DrawingGUI.getStrokeColor());

					// Add transparency value to ArrayList

					transPercent.add(Paint.DrawingGUI.getTransparentVal());

					drawStart = null;
					drawEnd = null;

					// repaint the drawing area

					repaint();

				}

			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {

				// If this is a brush have shapes go on the screen quickly

				if (Paint.DrawingGUI.getCurrentActionType() == 1) {

					int x = e.getX();
					int y = e.getY();

					Shape aShape = null;

					// Make stroke and fill equal to eliminate the fact that
					// this is an ellipse

					Paint.DrawingGUI.setStrokeColor(Paint.DrawingGUI.getFillColor());

					aShape = drawBrush(x, y, 5, 5);

					shapes.add(aShape);
					shapeFill.add(Paint.DrawingGUI.getFillColor());
					shapeStroke.add(Paint.DrawingGUI.getStrokeColor());

					// Add the transparency value

					transPercent.add(Paint.DrawingGUI.getTransparentVal());
				}

				// Get the final x & y position after the mouse is dragged

				drawEnd = new Point(e.getX(), e.getY());
				repaint();
			}
		});
	}

	public void paint(Graphics g) {
		// Class used to define the shapes to be drawn
		
		Paint.DrawingGUI.setGraphSettings((Graphics2D) g);

		// Antialiasing cleans up the jagged lines and defines rendering rules

		Paint.DrawingGUI.getGraphSettings().setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Defines the line width of the stroke

		Paint.DrawingGUI.getGraphSettings().setStroke(new BasicStroke(4));

		// Iterators created to cycle through strokes and fills
		Iterator<Color> strokeCounter = shapeStroke.iterator();
		Iterator<Color> fillCounter = shapeFill.iterator();

		// Iterator for transparency

		Iterator<Float> transCounter = transPercent.iterator();

		for (Shape s : shapes) {

			// Sets the shapes transparency value

			Paint.DrawingGUI.getGraphSettings().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transCounter.next()));

			// Grabs the next stroke from the color arraylist
			Paint.DrawingGUI.getGraphSettings().setPaint(strokeCounter.next());

			Paint.DrawingGUI.getGraphSettings().draw(s);

			// Grabs the next fill from the color arraylist
			Paint.DrawingGUI.getGraphSettings().setPaint(fillCounter.next());

			Paint.DrawingGUI.getGraphSettings().fill(s);
		}

		// Guide shape used for drawing
		if (drawStart != null && drawEnd != null) {
			// Makes the guide shape transparent

			Paint.DrawingGUI.getGraphSettings().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40f));

			// Make guide shape gray for professional look

			Paint.DrawingGUI.getGraphSettings().setPaint(Color.LIGHT_GRAY);

			Shape aShape = null;

			if (Paint.DrawingGUI.getCurrentActionType() == 2) {
				aShape = drawLine(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
			} else

			if (Paint.DrawingGUI.getCurrentActionType() == 3) {
				aShape = drawEllipse(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
			} else

			if (Paint.DrawingGUI.getCurrentActionType() == 4) {

				// Create a new rectangle using x & y coordinates

				aShape = drawRectangle(drawStart.x, drawStart.y, drawEnd.x, drawEnd.y);
			}

			Paint.DrawingGUI.getGraphSettings().draw(aShape);
		}
	}

	private Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {
		// Get the top left hand corner for the shape
		// Math.min returns the points closest to 0

		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);

		// Gets the difference between the coordinates and

		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);

		return new Rectangle2D.Float(x, y, width, height);
	}

	// The other shapes will work similarly
	// More on this in the next tutorial

	private Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2) {
		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);

		return new Ellipse2D.Float(x, y, width, height);
	}

	private Line2D.Float drawLine(int x1, int y1, int x2, int y2) {

		return new Line2D.Float(x1, y1, x2, y2);
	}

	private Ellipse2D.Float drawBrush(int x1, int y1, int brushStrokeWidth, int brushStrokeHeight) {

		return new Ellipse2D.Float(x1, y1, brushStrokeWidth, brushStrokeHeight);

	}

}
