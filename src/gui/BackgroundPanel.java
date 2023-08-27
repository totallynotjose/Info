package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class BackgroundPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image background;
	
	BackgroundPanel(){
		this.setSize(700, 480);
		background = new ImageIcon("Background.png").getImage();
	}
	
	public void paint (Graphics g) {
		 super.paint(g);
		 Graphics2D g2D = (Graphics2D) g;
		 
		 g2D.drawImage(background, 0, 0, null);
	}
}
