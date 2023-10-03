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
import services.HighscoreSaveService;

/**
 * This class serves as graphical representation of the main menu.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class MainMenuView extends JFrame {

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
	private BackgroundPanelView backgroundpanel;
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
	 * This integer is used as a high score.
	 */
	public int highscore = 0;
	/**
	 * This boolean checks whether a biomon instance exists in Game.
	 */
	public static boolean biomonInstanceCreated = false;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public MainMenuView() {
	
		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");
		logoimageicon = new ImageIcon("Logo.png");
		backgroundpanel = new BackgroundPanelView();
		textlabel = new JLabel();
		logolabel = new JLabel();
		startbutton = new JButton("Start New Game");
		continuebutton = new JButton("Continue Game");
		closebutton = new JButton("Close Program");
		gameInput = 0;
		
		// initializing of high score
		// is 0 if there is no pre-existing high score and the saved integer if there is
		// if the player achieves a new high score a new high score is saved
		if (!HighscoreSaveService.isHighscoreSaveFileExisting()) {
			highscore = 0;
			HighscoreSaveService.createHighscoreSaveFile();
			HighscoreSaveService.saveHighscoreToFile(highscore);
		} else {
			highscore = HighscoreSaveService.readHighscoreFromFile();
			if (biomonInstanceCreated == true) {
				if (GameController.biomonInstance.getLevel() > highscore) {
					highscore = GameController.biomonInstance.getLevel();
					HighscoreSaveService.saveHighscoreToFile(highscore);
				}
			}
		}

		// label for high score
		textlabel.setText("High Score: " + highscore);
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
				if (JOptionPane.showOptionDialog(null, "Do you want to start a new game?", "Start New Game?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					MainMenuView.this.dispose();
					new StarterChoiceMenuView();
				}
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
				if (JOptionPane.showOptionDialog(null, "Do you want to continue an existing game?", "Continue Game?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					MainMenuView.this.dispose();
					GameController.startGame(0);
				}
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
				if (JOptionPane.showOptionDialog(null, "Do you want to close the program?", "Close Program?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					MainMenuView.this.dispose();
				}
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
