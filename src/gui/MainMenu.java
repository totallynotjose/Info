package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import biomon.Enums;
import biomon.Game;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel textlabel;
	ImageIcon iconimageicon;
	ImageIcon logoimageicon;
	BackgroundPanel backgroundpanel;
	JLabel logolabel;
	JButton startbutton;
	JButton continuebutton;
	JButton closebutton;

	public int gameInput;

	public MainMenu() {

		iconimageicon = new ImageIcon("Icon.png");
		logoimageicon = new ImageIcon("Logo.png");
		backgroundpanel = new BackgroundPanel();
		textlabel = new JLabel();
		logolabel = new JLabel();
		startbutton = new JButton("S t a r t   N e w   G a m e");
		continuebutton = new JButton("C o n t i n u e   G a m e");
		closebutton = new JButton("C l o s e   P r o g r a m");
		gameInput = 0;

		textlabel.setText("H i g h s c o r e :   [ n ]");
		textlabel.setFont(new Font("Agency FB", Font.BOLD, 18));
		textlabel.setForeground(Color.WHITE);
		textlabel.setBounds(280, 210, 200, 50);
		textlabel.setOpaque(false);
		this.add(textlabel);

		logolabel.setIcon(logoimageicon);
		logolabel.setOpaque(false);
		logolabel.setBounds(55, 45, logoimageicon.getIconWidth(), logoimageicon.getIconHeight());
		this.add(logolabel);

		startbutton.setBounds(250, 260, 200, 50);
		startbutton.setFocusable(false);
		startbutton.setFont(new Font("Agency FB", Font.BOLD, 16));
		startbutton.setBackground(Color.WHITE);
		startbutton.setForeground(Color.DARK_GRAY);
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				Game.startGame(1);
				do {
					Game.writeCurrentBiomonStats();

					Game.fight();

				} while (Game.game != Enums.RunningStates.GAME_OVER);
				
				System.out.println("The game has ended.");
			}
		});
		this.add(startbutton);

		continuebutton.setBounds(250, 320, 200, 50);
		continuebutton.setFocusable(false);
		continuebutton.setFont(new Font("Agency FB", Font.BOLD, 16));
		continuebutton.setBackground(Color.WHITE);
		continuebutton.setForeground(Color.DARK_GRAY);
		continuebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
				Game.startGame(2);
				
				do {
					Game.writeCurrentBiomonStats();

					Game.fight();

				} while (Game.game != Enums.RunningStates.GAME_OVER);
				
				System.out.println("The game has ended.");
				
				MainMenu.this.dispose();
			}
		});
		this.add(continuebutton);
		
		closebutton.setBounds(250, 380, 200, 50);
		closebutton.setFocusable(false);
		closebutton.setFont(new Font("Agency FB", Font.BOLD, 16));
		closebutton.setBackground(Color.WHITE);
		closebutton.setForeground(Color.DARK_GRAY);
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.this.dispose();
			}
		});
		this.add(closebutton);

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
