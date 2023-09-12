package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import biomon.Fight;
import biomon.Game;

/**
 * This class serves as graphical representation of the menu with which the
 * player can choose what to do in battle.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class FightMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This ImageIcon is the icon shown in the upper left corner of the frame.
	 */
	private ImageIcon iconimageicon;

	/**
	 * These are all the ImageIcons for the Biomon.
	 */
	private ImageIcon fluffy1imageicon;
	private ImageIcon fluffy2imageicon;
	private ImageIcon fluffy3imageicon;
	private ImageIcon fluffy1Mimageicon;
	private ImageIcon fluffy2Mimageicon;
	private ImageIcon fluffy3Mimageicon;
	private ImageIcon slimy1imageicon;
	private ImageIcon slimy2imageicon;
	private ImageIcon slimy3imageicon;
	private ImageIcon slimy1Mimageicon;
	private ImageIcon slimy2Mimageicon;
	private ImageIcon slimy3Mimageicon;
	private ImageIcon crispy1imageicon;
	private ImageIcon crispy2imageicon;
	private ImageIcon crispy3imageicon;
	private ImageIcon crispy1Mimageicon;
	private ImageIcon crispy2Mimageicon;
	private ImageIcon crispy3Mimageicon;

	/**
	 * This background panel enables the use of a background image.
	 */
	private BackgroundPanel backgroundpanel;
	/**
	 * This label includes the information about the player's Biomon.
	 */
	private JLabel playertextlabel;
	/**
	 * This label includes the information about the opponent's Biomon.
	 */
	private JLabel enemytextlabel;
	/**
	 * This label includes the ImageIcon of the player's Biomon.
	 */
	private JLabel playerlabel;
	/**
	 * This label includes the ImageIcon of the opponent's Biomon.
	 */
	private JLabel enemylabel;
	/**
	 * This is the HP bar of the player's Biomon.
	 */
	private JProgressBar playerbar;
	/**
	 * This is the HP bar of the opponent's Biomon.
	 */
	private JProgressBar enemybar;
	/**
	 * This button attacks the opponent's Biomon with a regular attack.
	 */
	private JButton attack1button;
	/**
	 * This button attacks the opponent's Biomon with a special attack.
	 */
	private JButton attack2button;
	/**
	 * This button heals the player's Biomon.
	 */
	private JButton healbutton;
	/**
	 * This integer determines the current state of the HP bar of the player's
	 * Biomon at the beginning of each.
	 */
	int playercounter;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public FightMenu() {

		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");

		fluffy1imageicon = new ImageIcon("Fluffy1.png");
		fluffy2imageicon = new ImageIcon("Fluffy2.png");
		fluffy3imageicon = new ImageIcon("Fluffy3.png");
		fluffy1Mimageicon = new ImageIcon("Fluffy1M.png");
		fluffy2Mimageicon = new ImageIcon("Fluffy2M.png");
		fluffy3Mimageicon = new ImageIcon("Fluffy3M.png");

		slimy1imageicon = new ImageIcon("Slimy1.png");
		slimy2imageicon = new ImageIcon("Slimy2.png");
		slimy3imageicon = new ImageIcon("Slimy3.png");
		slimy1Mimageicon = new ImageIcon("Slimy1M.png");
		slimy2Mimageicon = new ImageIcon("Slimy2M.png");
		slimy3Mimageicon = new ImageIcon("Slimy3M.png");

		crispy1imageicon = new ImageIcon("Crispy1.png");
		crispy2imageicon = new ImageIcon("Crispy2.png");
		crispy3imageicon = new ImageIcon("Crispy3.png");
		crispy1Mimageicon = new ImageIcon("Crispy1M.png");
		crispy2Mimageicon = new ImageIcon("Crispy2M.png");
		crispy3Mimageicon = new ImageIcon("Crispy3M.png");

		backgroundpanel = new BackgroundPanel();
		playertextlabel = new JLabel();
		enemytextlabel = new JLabel();
		playerlabel = new JLabel();
		enemylabel = new JLabel();
		playerbar = new JProgressBar();
		enemybar = new JProgressBar();
		attack1button = new JButton("attack");
		attack2button = new JButton("special attack");
		healbutton = new JButton("heal");

		// initializing the playercounter by determining the percentage of maximum HP
		playercounter = 100 * Game.biomonInstance.getCurrentHP() / Game.biomonInstance.getMaxHP();

		// label with the information about the player's Biomon
		playertextlabel.setText(Fight.writeCurrentBiomonStats(Game.biomonInstance));
		playertextlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		playertextlabel.setForeground(Color.WHITE);
		playertextlabel.setBounds(20, 10, 700, 50);
		playerlabel.setOpaque(true);
		this.add(playertextlabel);

		// label with the information about the opponent's Biomon
		enemytextlabel.setText(Fight.writeCurrentBiomonStats(Game.enemyInstance));
		enemytextlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		enemytextlabel.setForeground(Color.WHITE);
		enemytextlabel.setBounds(470, 10, 700, 50);
		enemylabel.setOpaque(true);
		this.add(enemytextlabel);

		// switch to determine which ImageIcon to use for the player's Biomon
		switch (Game.biomonInstance.getType()) {
		case 1:
			if (Game.biomonInstance.getLevel() < 4) {
				playerlabel.setIcon(fluffy1Mimageicon);
				playerlabel.setBounds(0, 100, fluffy1Mimageicon.getIconWidth(), fluffy1Mimageicon.getIconHeight());
			} else if (Game.biomonInstance.getLevel() < 9 && Game.biomonInstance.getLevel() >= 4) {
				playerlabel.setIcon(fluffy2Mimageicon);
				playerlabel.setBounds(0, 100, fluffy2Mimageicon.getIconWidth(), fluffy2Mimageicon.getIconHeight());
			} else {
				playerlabel.setIcon(fluffy3Mimageicon);
				playerlabel.setBounds(0, 100, fluffy3Mimageicon.getIconWidth(), fluffy3Mimageicon.getIconHeight());
			}
			break;
		case 2:
			if (Game.biomonInstance.getLevel() < 4) {
				playerlabel.setIcon(slimy1Mimageicon);
				playerlabel.setBounds(0, 100, slimy1Mimageicon.getIconWidth(), slimy1Mimageicon.getIconHeight());
			} else if (Game.biomonInstance.getLevel() < 9 && Game.biomonInstance.getLevel() >= 4) {
				playerlabel.setIcon(slimy2Mimageicon);
				playerlabel.setBounds(0, 100, slimy2Mimageicon.getIconWidth(), slimy2Mimageicon.getIconHeight());
			} else {
				playerlabel.setIcon(slimy3Mimageicon);
				playerlabel.setBounds(0, 100, slimy3Mimageicon.getIconWidth(), slimy3Mimageicon.getIconHeight());
			}
			break;
		default:
			if (Game.biomonInstance.getLevel() < 4) {
				playerlabel.setIcon(crispy1Mimageicon);
				playerlabel.setBounds(0, 100, crispy1Mimageicon.getIconWidth(), crispy1Mimageicon.getIconHeight());
			} else if (Game.biomonInstance.getLevel() < 9 && Game.biomonInstance.getLevel() >= 4) {
				playerlabel.setIcon(crispy2Mimageicon);
				playerlabel.setBounds(0, 100, crispy2Mimageicon.getIconWidth(), crispy2Mimageicon.getIconHeight());
			} else {
				playerlabel.setIcon(crispy3Mimageicon);
				playerlabel.setBounds(0, 100, crispy3Mimageicon.getIconWidth(), crispy3Mimageicon.getIconHeight());
			}
			break;
		}
		playerlabel.setOpaque(false);
		this.add(playerlabel);

		// switch to determine which ImageIcon to use for the opponent's Biomon
		switch (Game.enemyInstance.getType()) {
		case 1:
			if (Game.enemyInstance.getLevel() < 4) {
				enemylabel.setIcon(fluffy1imageicon);
				enemylabel.setBounds(440, 100, fluffy1imageicon.getIconWidth(), fluffy1imageicon.getIconHeight());
			} else if (Game.enemyInstance.getLevel() < 9 && Game.enemyInstance.getLevel() >= 4) {
				enemylabel.setIcon(fluffy2imageicon);
				enemylabel.setBounds(440, 100, fluffy2imageicon.getIconWidth(), fluffy2imageicon.getIconHeight());
			} else {
				enemylabel.setIcon(fluffy3imageicon);
				enemylabel.setBounds(440, 100, fluffy3imageicon.getIconWidth(), fluffy3imageicon.getIconHeight());
			}
			break;
		case 2:
			if (Game.enemyInstance.getLevel() < 4) {
				enemylabel.setIcon(slimy1imageicon);
				enemylabel.setBounds(440, 100, slimy1imageicon.getIconWidth(), slimy1imageicon.getIconHeight());
			} else if (Game.enemyInstance.getLevel() < 9 && Game.enemyInstance.getLevel() >= 4) {
				enemylabel.setIcon(slimy2imageicon);
				enemylabel.setBounds(440, 100, slimy2imageicon.getIconWidth(), slimy2imageicon.getIconHeight());
			} else {
				enemylabel.setIcon(slimy3imageicon);
				enemylabel.setBounds(440, 100, slimy3imageicon.getIconWidth(), slimy3imageicon.getIconHeight());
			}
			break;
		default:
			if (Game.enemyInstance.getLevel() < 4) {
				enemylabel.setIcon(crispy1imageicon);
				enemylabel.setBounds(440, 100, crispy1imageicon.getIconWidth(), crispy1imageicon.getIconHeight());
			} else if (Game.enemyInstance.getLevel() < 9 && Game.enemyInstance.getLevel() >= 4) {
				enemylabel.setIcon(crispy2imageicon);
				enemylabel.setBounds(440, 100, crispy2imageicon.getIconWidth(), crispy2imageicon.getIconHeight());
			} else {
				enemylabel.setIcon(crispy3imageicon);
				enemylabel.setBounds(440, 100, crispy3imageicon.getIconWidth(), crispy3imageicon.getIconHeight());
			}
			break;
		}
		enemylabel.setOpaque(false);
		this.add(enemylabel);

		// the HP bar of the player's Biomon
		playerbar.setValue(playercounter);
		playerbar.setBounds(20, 50, 200, 15);
		playerbar.setFont(new Font("Bahnschrift", Font.BOLD, 0));
		playerbar.setForeground(new Color(0, 255, 0));
		playerbar.setBackground(new Color(50, 50, 50));
		playerbar.setStringPainted(true);
		this.add(playerbar);

		// the HP bar of the opponent's Biomon
		enemybar.setValue(100);
		enemybar.setBounds(470, 50, 200, 15);
		enemybar.setFont(new Font("Bahnschrift", Font.BOLD, 0));
		enemybar.setForeground(new Color(0, 255, 0));
		enemybar.setBackground(new Color(50, 50, 50));
		enemybar.setStringPainted(true);
		this.add(enemybar);

		// button for an ordinary attack
		// will trigger the fight method and update HP bars as well as the info
		attack1button.setBounds(10, 380, 200, 50);
		attack1button.setFocusable(false);
		attack1button.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		attack1button.setBackground(Color.WHITE);
		attack1button.setForeground(Color.DARK_GRAY);
		attack1button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fight.myAttack = 1;
				Game.fight();

				playerbar.setValue(100 * Game.biomonInstance.getCurrentHP() / Game.biomonInstance.getMaxHP());
				enemybar.setValue(100 * Game.enemyInstance.getCurrentHP() / Game.enemyInstance.getMaxHP());

				playertextlabel.setText(Fight.writeCurrentBiomonStats(Game.biomonInstance));
				enemytextlabel.setText(Fight.writeCurrentBiomonStats(Game.enemyInstance));
			}
		});
		this.add(attack1button);

		// button for a special attack
		// will trigger the fight method and update HP bars as well as the info
		attack2button.setBounds(242, 380, 200, 50);
		attack2button.setFocusable(false);
		attack2button.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		attack2button.setBackground(Color.WHITE);
		attack2button.setForeground(Color.DARK_GRAY);
		attack2button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fight.myAttack = 2;

				Game.fight();

				playerbar.setValue(100 * Game.biomonInstance.getCurrentHP() / Game.biomonInstance.getMaxHP());
				enemybar.setValue(100 * Game.enemyInstance.getCurrentHP() / Game.enemyInstance.getMaxHP());

				playertextlabel.setText(Fight.writeCurrentBiomonStats(Game.biomonInstance));
				enemytextlabel.setText(Fight.writeCurrentBiomonStats(Game.enemyInstance));
			}
		});
		this.add(attack2button);

		// button for healing
		// will trigger the fight method and update HP bars as well as the info
		healbutton.setBounds(475, 380, 200, 50);
		healbutton.setFocusable(false);
		healbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		healbutton.setBackground(Color.WHITE);
		healbutton.setForeground(Color.DARK_GRAY);
		healbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fight.myAttack = 3;

				Game.fight();

				playerbar.setValue(100 * Game.biomonInstance.getCurrentHP() / Game.biomonInstance.getMaxHP());
				enemybar.setValue(100 * Game.enemyInstance.getCurrentHP() / Game.enemyInstance.getMaxHP());

				playertextlabel.setText(Fight.writeCurrentBiomonStats(Game.biomonInstance));
				enemytextlabel.setText(Fight.writeCurrentBiomonStats(Game.enemyInstance));
			}
		});
		this.add(healbutton);

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