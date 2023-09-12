package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import biomon.Biomon;
import biomon.Enums;
import biomon.Game;
import biomon.services.SaveService;

/**
 * This class serves as graphical representation of the menu with which the
 * player can choose what to do after a successful battle.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class SaveOrContinue extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This label includes the sentence "YOU WON!".
	 */
	private JLabel text1label;
	/**
	 * This label includes the sentence "SAVE OR CONTINUE!".
	 */
	private JLabel text2label;
	/**
	 * This label includes the occasional sentence "YOUR BIOMON EVOLVED!".
	 */
	private JLabel evolutionlabel
	/**
	 * This ImageIcon is the icon shown in the upper left corner of the frame.
	 */;
	private ImageIcon iconimageicon;
	/**
	 * This background panel enables the use of a background image.
	 */
	private BackgroundPanel backgroundpanel;
	/**
	 * This button continues the program.
	 */
	private JButton continuebutton;
	/**
	 * This button saves the progress and returns to the main menu.
	 */
	private JButton savebutton;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public SaveOrContinue() {
		
		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");
		backgroundpanel = new BackgroundPanel();
		text1label = new JLabel();
		text2label = new JLabel();
		evolutionlabel = new JLabel();
		savebutton = new JButton("Save and return to Main Menu");
		continuebutton = new JButton("Continue Game");
		
		// label informing the player that their Biomon has evolved
		if (Game.biomonInstance.getLevel() == 4 || Game.biomonInstance.getLevel() == 9) {
		evolutionlabel.setText("YOUR BIOMON EVOLVED!");
		evolutionlabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
		evolutionlabel.setForeground(Color.WHITE);
		evolutionlabel.setBounds(50, 25, 700, 100);
		evolutionlabel.setOpaque(false);
		this.add(evolutionlabel);
		}
		
		// label informing the player of their win
		text1label.setText("YOU WON!");
		text1label.setFont(new Font("Bahnschrift", Font.BOLD, 50));
		text1label.setForeground(Color.WHITE);
		text1label.setBounds(230, 75, 700, 100);
		text1label.setOpaque(false);
		this.add(text1label);
		
		// label asking the player whether to save and return to the main menu or continue
		text2label.setText("SAVE OR CONTINUE?");
		text2label.setFont(new Font("Bahnschrift", Font.BOLD, 50));
		text2label.setForeground(Color.WHITE);
		text2label.setBounds(100, 125, 700, 100);
		text2label.setOpaque(false);
		this.add(text2label);

		// button for saving and returning to the main menu
		savebutton.setBounds(200, 280, 300, 50);
		savebutton.setFocusable(false);
		savebutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		savebutton.setBackground(Color.WHITE);
		savebutton.setForeground(Color.DARK_GRAY);
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveService.saveBiomonToFile(Game.biomonInstance);
				Game.game = Enums.RunningStates.PAUSE;
				SaveOrContinue.this.dispose();
				new MainMenu();
			}
		});
		this.add(savebutton);
		
		// button for continuing the game
		continuebutton.setBounds(200, 340, 300, 50);
		continuebutton.setFocusable(false);
		continuebutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		continuebutton.setBackground(Color.WHITE);
		continuebutton.setForeground(Color.DARK_GRAY);
		continuebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.game = Enums.RunningStates.RUNNING;
				Game.enemyInstance = new Biomon(Game.biomonInstance.getLevel());
				SaveOrContinue.this.dispose();
				Game.fightMenu = new FightMenu();
			}
		});
		this.add(continuebutton);

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
}}
