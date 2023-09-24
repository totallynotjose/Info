package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import biomon.Game;

/**
 * This class serves as graphical representation of the main menu.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This label includes the information about the high score.
	 */
	private JLabel textlabel;
	/**
	 * This ImageIcon is the icon shown in the upper left corner of the frame.
	 */
	private ImageIcon iconimageicon;
	/**
	 * This ImageIcon is the picture in the middle of the screen.
	 */
	private ImageIcon logoimageicon;
	/**
	 * This background panel enables the use of a background image.
	 */
	private BackgroundPanel backgroundpanel;
	/**
	 * This label is used for the Biomon logo in the middle of the screen.
	 */
	private JLabel logolabel;
	/**
	 * This button starts a new game.
	 */
	private JButton startbutton;
	/**
	 * This button continues an existing save file.
	 */
	private JButton continuebutton;
	/**
	 * This button closes the program.
	 */
	private JButton closebutton;
	/**
	 * This integer is used to communicate between the model and control. 
	 */
	public int gameInput;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the frame.
	 */
	public MainMenu() {

		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");
		logoimageicon = new ImageIcon("Logo.png");
		backgroundpanel = new BackgroundPanel();
		textlabel = new JLabel();
		logolabel = new JLabel();
		startbutton = new JButton("Start New Game");
		continuebutton = new JButton("Continue Game");
		closebutton = new JButton("Close Program");
		gameInput = 0;

		// label for high score
		textlabel.setText("High Score: [n]");
		textlabel.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		textlabel.setForeground(Color.WHITE);
		textlabel.setBounds(287, 212, 200, 50);
		textlabel.setOpaque(false);
		this.add(textlabel);

		// label for Biomon logo
		logolabel.setIcon(logoimageicon);
		logolabel.setOpaque(false);
		logolabel.setBounds(55, 45, logoimageicon.getIconWidth(), logoimageicon.getIconHeight());
		this.add(logolabel);

		// button for starting game
		startbutton.setBounds(250, 260, 200, 50);
		startbutton.setFocusable(false);
		startbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		startbutton.setBackground(Color.WHITE);
		startbutton.setForeground(Color.DARK_GRAY);
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				new StarterChoiceMenu();
			}
		});
		this.add(startbutton);

		// button for continuing game
		continuebutton.setBounds(250, 320, 200, 50);
		continuebutton.setFocusable(false);
		continuebutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		continuebutton.setBackground(Color.WHITE);
		continuebutton.setForeground(Color.DARK_GRAY);
		continuebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				Game.startGame(0);
			}
		});
		this.add(continuebutton);

		// button for closing game
		closebutton.setBounds(250, 380, 200, 50);
		closebutton.setFocusable(false);
		closebutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		closebutton.setBackground(Color.WHITE);
		closebutton.setForeground(Color.DARK_GRAY);
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
			}
		});
		this.add(closebutton);

		// settings for JFrame
		this.setIconImage(iconimageicon.getImage());
		this.setTitle("Biomon");
		this.setSize(700, 480);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(backgroundpanel);
		this.setVisible(true);

	}
}