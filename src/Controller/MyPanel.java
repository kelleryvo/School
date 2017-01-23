package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * 
 * @author Schaeppi und Keller
 * @version 1.0
 *
 */
public class MyPanel extends JPanel {

	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 100;
	private int squareH = 100;

	public MyPanel() {
		
		setBorder(BorderFactory.createLineBorder(Color.white));

		//Mausklick
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});

		//Mausbewegung
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
				
			}
		});

	}

	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if ((squareX != x) || (squareY != y)) {
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			revalidate();
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}

	//Screen Size
	public Dimension getPreferredSize() {
		return new Dimension(800, 500);
	}

	//Startup View
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.WHITE);
		g.drawString("This is my custom Panel!", 10, 20);
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}
