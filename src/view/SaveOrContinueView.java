package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.GameController;
import model.Biomon;
import ressources.Enums;
import services.SaveService;

/**
 * This class serves as graphical representation of the menu with which the
 * player can choose what to do after a successful battle.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class SaveOrContinueView extends JFrame {

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
	private JLabel evolutionlabel;
	/**
	 * This label includes the occasional sentence "YOU HAVE REACHED THE MAXIMUM LEVEL!".
	 */
	private JLabel winninglabel;
	/**
	 * This ImageIcon is the icon shown in the upper left corner of the frame.
	 */
	private ImageIcon iconimageicon;
	/**
	 * This background panel enables the use of a background image.
	 */
	private BackgroundPanelView backgroundpanel;
	/**
	 * This button saves the progress and returns to the main menu.
	 */
	private JButton savebutton;
	/**
	 * This button continues the program.
	 */
	private JButton continuebutton;
	/**
	 * This button lets the player return to the main menu after reaching the maximum level.
	 */
	private JButton returnbutton;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public SaveOrContinueView() {

		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");
		backgroundpanel = new BackgroundPanelView();
		text1label = new JLabel();
		text2label = new JLabel();
		evolutionlabel = new JLabel();
		winninglabel = new JLabel();
		savebutton = new JButton("Save and return to Main Menu");
		continuebutton = new JButton("Continue Game");
		returnbutton = new JButton("Return to Main Menu");

		// label informing the player that their Biomon has evolved
		if (GameController.biomonInstance.getLevel() == 4 || GameController.biomonInstance.getLevel() == 9) {
			evolutionlabel.setText("YOUR BIOMON EVOLVED!");
			evolutionlabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
			evolutionlabel.setForeground(Color.WHITE);
			evolutionlabel.setBounds(50, 75, 700, 100);
			evolutionlabel.setOpaque(false);
			this.add(evolutionlabel);
		}
		
		if (GameController.biomonInstance.getLevel() == 14) {
			winninglabel.setText("YOU'VE REACHED THE END!");
			winninglabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
			winninglabel.setForeground(Color.WHITE);
			winninglabel.setBounds(15, 75, 700, 100);
			winninglabel.setOpaque(false);
			this.add(winninglabel);
		}

		// label informing the player of their win
		text1label.setText("YOU WON!");
		text1label.setFont(new Font("Bahnschrift", Font.BOLD, 50));
		text1label.setForeground(Color.WHITE);
		text1label.setBounds(230, 25, 700, 100);
		text1label.setOpaque(false);
		this.add(text1label);

		// label asking the player whether to save and return to the main menu or
		// continue
		if (GameController.biomonInstance.getLevel() == 14) {
			text2label.setText("CONGRATULATIONS!");
		} else {
		text2label.setText("SAVE OR CONTINUE?");
		}
		text2label.setFont(new Font("Bahnschrift", Font.BOLD, 50));
		text2label.setForeground(Color.WHITE);
		text2label.setBounds(100, 125, 700, 100);
		text2label.setOpaque(false);
		this.add(text2label);

		// button for saving and returning to the main menu
		if (GameController.biomonInstance.getLevel() < 14) {
		savebutton.setBounds(200, 280, 300, 50);
		savebutton.setFocusable(false);
		savebutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		savebutton.setBackground(Color.WHITE);
		savebutton.setForeground(Color.DARK_GRAY);
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null,
						"Do you want to save and return to the main menu? You will not be healed the next round.",
						"Save Game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Yes", "No" }, "") == JOptionPane.YES_OPTION) {
					SaveService.saveBiomonToFile(GameController.biomonInstance);
					GameController.game = Enums.RunningStates.PAUSE;
					SaveOrContinueView.this.dispose();
					new MainMenuView();
				}
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
				if (JOptionPane.showOptionDialog(null,
						"Do you want to continue without saving? You will be partially healed the next round.",
						"Continue Game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Yes", "No" }, "") == JOptionPane.YES_OPTION) {
					GameController.biomonInstance.heal();
					GameController.game = Enums.RunningStates.RUNNING;
					GameController.enemyInstance = new Biomon(GameController.biomonInstance.getLevel());
					SaveOrContinueView.this.dispose();
					GameController.fightMenu = new FightMenuView();
				}
			}
		});
		this.add(continuebutton);
		} 
		
		else {
			returnbutton.setBounds(200, 280, 300, 50);
			returnbutton.setFocusable(false);
			returnbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
			returnbutton.setBackground(Color.WHITE);
			returnbutton.setForeground(Color.DARK_GRAY);
			returnbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						GameController.game = Enums.RunningStates.PAUSE;
						SaveOrContinueView.this.dispose();
						new MainMenuView();
					}
			});
			this.add(returnbutton);
		}
		
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
