package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class serves as graphical representation of the game over screen with
 * which the player can choose what to do after being defeated in battle.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class GameOver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This label includes the sentence "GAME OVER!".
	 */
	private JLabel textlabel;
	/**
	 * This ImageIcon is the icon shown in the upper left corner of the frame.
	 */
	private ImageIcon iconimageicon;
	/**
	 * This background panel enables the use of a background image.
	 */
	private BackgroundPanel backgroundpanel;
	/**
	 * This button lets the player return to the main menu.
	 */
	private JButton returnbutton;
	/**
	 * This button lets the player close the program.
	 */
	private JButton closebutton;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public GameOver() {

		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");
		backgroundpanel = new BackgroundPanel();
		textlabel = new JLabel();
		returnbutton = new JButton("Return to Main Menu");
		closebutton = new JButton("Close Program");

		// label for the text
		textlabel.setText("GAME OVER!");
		textlabel.setFont(new Font("Bahnschrift", Font.BOLD, 78));
		textlabel.setForeground(Color.WHITE);
		textlabel.setBounds(120, 100, 480, 100);
		textlabel.setOpaque(false);
		this.add(textlabel);

		// button for returning to main menu
		returnbutton.setBounds(250, 280, 200, 50);
		returnbutton.setFocusable(false);
		returnbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		returnbutton.setBackground(Color.WHITE);
		returnbutton.setForeground(Color.DARK_GRAY);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Do you want to return to the main menu?",
						"Return to Main Menu?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Yes", "No" }, "") == JOptionPane.YES_OPTION) {
					GameOver.this.dispose();
					new MainMenu();
				}
			}
		});
		this.add(returnbutton);

		// button for closing program
		closebutton.setBounds(250, 340, 200, 50);
		closebutton.setFocusable(false);
		closebutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		closebutton.setBackground(Color.WHITE);
		closebutton.setForeground(Color.DARK_GRAY);
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Do you want to close the program?", "Close Program?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					GameOver.this.dispose();
				}
			}
		});
		this.add(closebutton);

		// settings for JFrame
		this.setIconImage(iconimageicon.getImage()); // changes icon of the frame
		this.setTitle("Biomon"); // sets title of frame to "Biomon"
		this.setSize(700, 480); // sets size of frame to 720 x 480 pixels
		this.setResizable(false); // sets size of frame to non-resizable
		this.setLocationRelativeTo(null); // sets frame to center of the screen
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets default close operation to exit on close
		this.add(backgroundpanel);
		this.setVisible(true); // sets frame to visible

	}
}
