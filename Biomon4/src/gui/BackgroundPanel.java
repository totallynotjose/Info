package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * This class enables the use of a background image for each of the menus.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */


public class BackgroundPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is the image of the background.
	 */
	private Image background;
	
	/**
	 * This method transforms the image into an ImageIcon.
	 */
	BackgroundPanel(){
		this.setSize(700, 480);
		background = new ImageIcon("Background.png").getImage();
	}
	
	/**
	 * This method paints the image.
	 */
	public void paint (Graphics g) {
		 super.paint(g);
		 Graphics2D g2D = (Graphics2D) g;
		 
		 g2D.drawImage(background, 0, 0, null);
	}
}
