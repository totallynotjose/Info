package view;

import javax.swing.*;

import Controller.GameController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import services.FightService;

/**
 * This class serves as graphical representation of the menu with which the
 * player can choose what to do in battle.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class FightMenuView extends JFrame {
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
	private BackgroundPanelView backgroundpanel;
	/**
	 * This label includes the information about the player's Biomon.
	 */
	private JLabel playertextlabel;
	/**
	 * This label includes the information about the opponent's Biomon.
	 */
	private JLabel enemytextlabel;
	/**
	 * This label includes the information about what attack the player chose.
	 */
	private JLabel playerattacklabel;
	/**
	 * This label includes the information about what attack the enemy chose.
	 */
	public static JLabel enemyattacklabel;
	/**
	 * This label includes the information about if the player got a critical hit.
	 */
	public static JLabel playercritlabel;
	/**
	 * This label includes the information about if the enemy got a critical hit.
	 */
	public static JLabel enemycritlabel;
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
	 * This button explains the normal attack to the player.
	 */
	private JButton helpattackbutton;
	/**
	 * This button explains the special attack to the player.
	 */
	private JButton helpspecialattackbutton;
	/**
	 * This button explains healing to the player.
	 */
	private JButton helphealbutton;
	/**
	 * This integer determines the current state of the HP bar of the player's
	 * Biomon at the beginning of each.
	 */
	private int playercounter;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public FightMenuView() {

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

		backgroundpanel = new BackgroundPanelView();
		playertextlabel = new JLabel();
		enemytextlabel = new JLabel();
		playerattacklabel = new JLabel();
		enemyattacklabel = new JLabel();
		playercritlabel = new JLabel();
		enemycritlabel = new JLabel();
		playerlabel = new JLabel();
		enemylabel = new JLabel();
		playerbar = new JProgressBar();
		enemybar = new JProgressBar();
		attack1button = new JButton("attack");
		attack2button = new JButton("special attack");
		healbutton = new JButton("heal");
		helpattackbutton = new JButton("?");
		helpspecialattackbutton = new JButton("?");
		helphealbutton = new JButton("?");

		// initializing the playercounter by determining the percentage of maximum HP
		playercounter = 100 * GameController.biomonInstance.getCurrentHP() / GameController.biomonInstance.getMaxHP();

		// label with the information about the player's Biomon
		playertextlabel.setText(FightService.writeCurrentBiomonStats(GameController.biomonInstance));
		playertextlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		playertextlabel.setForeground(Color.WHITE);
		playertextlabel.setBounds(20, 10, 700, 50);
		playerlabel.setOpaque(true);
		this.add(playertextlabel);

		// label with the information about the opponent's Biomon
		enemytextlabel.setText(FightService.writeCurrentBiomonStats(GameController.enemyInstance));
		enemytextlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		enemytextlabel.setForeground(Color.WHITE);
		enemytextlabel.setBounds(470, 10, 700, 50);
		enemylabel.setOpaque(true);
		this.add(enemytextlabel);

		// label with information about what attack the player chose
		playerattacklabel.setText("");
		playerattacklabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		playerattacklabel.setForeground(Color.WHITE);
		playerattacklabel.setBounds(245, 150, 200, 50);
		this.add(playerattacklabel);

		// label with information about what attack the enemy chose
		enemyattacklabel.setText("");
		enemyattacklabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		enemyattacklabel.setForeground(Color.WHITE);
		enemyattacklabel.setBounds(350, 225, 200, 50);
		this.add(enemyattacklabel);

		// label with information about if the player got a critical hit
		playercritlabel.setText("");
		playercritlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		playercritlabel.setForeground(Color.WHITE);
		playercritlabel.setBounds(245, 175, 200, 50);
		this.add(playercritlabel);

		// label with information about if the enemy got a critical hit
		enemycritlabel.setText("");
		enemycritlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		enemycritlabel.setForeground(Color.WHITE);
		enemycritlabel.setBounds(350, 250, 200, 50);
		this.add(enemycritlabel);

		// switch to determine which ImageIcon to use for the player's Biomon
		switch (GameController.biomonInstance.getType()) {
		case 1:
			if (GameController.biomonInstance.getLevel() < 4) {
				playerlabel.setIcon(fluffy1Mimageicon);
				playerlabel.setBounds(0, 100, fluffy1Mimageicon.getIconWidth(), fluffy1Mimageicon.getIconHeight());
			} else if (GameController.biomonInstance.getLevel() < 9 && GameController.biomonInstance.getLevel() >= 4) {
				playerlabel.setIcon(fluffy2Mimageicon);
				playerlabel.setBounds(0, 100, fluffy2Mimageicon.getIconWidth(), fluffy2Mimageicon.getIconHeight());
			} else {
				playerlabel.setIcon(fluffy3Mimageicon);
				playerlabel.setBounds(0, 100, fluffy3Mimageicon.getIconWidth(), fluffy3Mimageicon.getIconHeight());
			}
			break;
		case 2:
			if (GameController.biomonInstance.getLevel() < 4) {
				playerlabel.setIcon(slimy1Mimageicon);
				playerlabel.setBounds(0, 100, slimy1Mimageicon.getIconWidth(), slimy1Mimageicon.getIconHeight());
			} else if (GameController.biomonInstance.getLevel() < 9 && GameController.biomonInstance.getLevel() >= 4) {
				playerlabel.setIcon(slimy2Mimageicon);
				playerlabel.setBounds(0, 100, slimy2Mimageicon.getIconWidth(), slimy2Mimageicon.getIconHeight());
			} else {
				playerlabel.setIcon(slimy3Mimageicon);
				playerlabel.setBounds(0, 100, slimy3Mimageicon.getIconWidth(), slimy3Mimageicon.getIconHeight());
			}
			break;
		default:
			if (GameController.biomonInstance.getLevel() < 4) {
				playerlabel.setIcon(crispy1Mimageicon);
				playerlabel.setBounds(0, 100, crispy1Mimageicon.getIconWidth(), crispy1Mimageicon.getIconHeight());
			} else if (GameController.biomonInstance.getLevel() < 9 && GameController.biomonInstance.getLevel() >= 4) {
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
		switch (GameController.enemyInstance.getType()) {
		case 1:
			if (GameController.enemyInstance.getLevel() < 4) {
				enemylabel.setIcon(fluffy1imageicon);
				enemylabel.setBounds(440, 100, fluffy1imageicon.getIconWidth(), fluffy1imageicon.getIconHeight());
			} else if (GameController.enemyInstance.getLevel() < 9 && GameController.enemyInstance.getLevel() >= 4) {
				enemylabel.setIcon(fluffy2imageicon);
				enemylabel.setBounds(440, 100, fluffy2imageicon.getIconWidth(), fluffy2imageicon.getIconHeight());
			} else {
				enemylabel.setIcon(fluffy3imageicon);
				enemylabel.setBounds(440, 100, fluffy3imageicon.getIconWidth(), fluffy3imageicon.getIconHeight());
			}
			break;
		case 2:
			if (GameController.enemyInstance.getLevel() < 4) {
				enemylabel.setIcon(slimy1imageicon);
				enemylabel.setBounds(440, 100, slimy1imageicon.getIconWidth(), slimy1imageicon.getIconHeight());
			} else if (GameController.enemyInstance.getLevel() < 9 && GameController.enemyInstance.getLevel() >= 4) {
				enemylabel.setIcon(slimy2imageicon);
				enemylabel.setBounds(440, 100, slimy2imageicon.getIconWidth(), slimy2imageicon.getIconHeight());
			} else {
				enemylabel.setIcon(slimy3imageicon);
				enemylabel.setBounds(440, 100, slimy3imageicon.getIconWidth(), slimy3imageicon.getIconHeight());
			}
			break;
		default:
			if (GameController.enemyInstance.getLevel() < 4) {
				enemylabel.setIcon(crispy1imageicon);
				enemylabel.setBounds(440, 100, crispy1imageicon.getIconWidth(), crispy1imageicon.getIconHeight());
			} else if (GameController.enemyInstance.getLevel() < 9 && GameController.enemyInstance.getLevel() >= 4) {
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
		attack1button.setBounds(10, 380, 155, 50);
		attack1button.setFocusable(false);
		attack1button.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		attack1button.setBackground(Color.WHITE);
		attack1button.setForeground(Color.DARK_GRAY);
		attack1button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerattacklabel.setText("Normal attack!");

				FightService.myAttack = 1;
				GameController.fight();

				playerbar.setValue(100 * GameController.biomonInstance.getCurrentHP() / GameController.biomonInstance.getMaxHP());
				enemybar.setValue(100 * GameController.enemyInstance.getCurrentHP() / GameController.enemyInstance.getMaxHP());

				playertextlabel.setText(FightService.writeCurrentBiomonStats(GameController.biomonInstance));
				enemytextlabel.setText(FightService.writeCurrentBiomonStats(GameController.enemyInstance));
			}
		});
		this.add(attack1button);

		// button for a special attack
		// will trigger the fight method and update HP bars as well as the info
		attack2button.setBounds(242, 380, 155, 50);
		attack2button.setFocusable(false);
		attack2button.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		attack2button.setBackground(Color.WHITE);
		attack2button.setForeground(Color.DARK_GRAY);
		attack2button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerattacklabel.setText("Special attack!");
				FightService.myAttack = 2;

				GameController.fight();

				playerbar.setValue(100 * GameController.biomonInstance.getCurrentHP() / GameController.biomonInstance.getMaxHP());
				enemybar.setValue(100 * GameController.enemyInstance.getCurrentHP() / GameController.enemyInstance.getMaxHP());

				playertextlabel.setText(FightService.writeCurrentBiomonStats(GameController.biomonInstance));
				enemytextlabel.setText(FightService.writeCurrentBiomonStats(GameController.enemyInstance));
			}
		});
		this.add(attack2button);

		// button for healing
		// will trigger the fight method and update HP bars as well as the info
		healbutton.setBounds(475, 380, 155, 50);
		healbutton.setFocusable(false);
		healbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		healbutton.setBackground(Color.WHITE);
		healbutton.setForeground(Color.DARK_GRAY);
		healbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerattacklabel.setText("Heal!");
				FightService.myAttack = 3;

				GameController.fight();

				playerbar.setValue(100 * GameController.biomonInstance.getCurrentHP() / GameController.biomonInstance.getMaxHP());
				enemybar.setValue(100 * GameController.enemyInstance.getCurrentHP() / GameController.enemyInstance.getMaxHP());

				playertextlabel.setText(FightService.writeCurrentBiomonStats(GameController.biomonInstance));
				enemytextlabel.setText(FightService.writeCurrentBiomonStats(GameController.enemyInstance));
			}
		});
		this.add(healbutton);

		// button for informing the player
		helpattackbutton.setBounds(165, 380, 45, 50);
		helpattackbutton.setFocusable(false);
		helpattackbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		helpattackbutton.setBackground(Color.WHITE);
		helpattackbutton.setForeground(Color.DARK_GRAY);
		helpattackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"An attack that deals damage regardless of typing. There can be critical hits!",
						"Attack Explained", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(helpattackbutton);

		// button for informing the player
		helpspecialattackbutton.setBounds(397, 380, 45, 50);
		helpspecialattackbutton.setFocusable(false);
		helpspecialattackbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		helpspecialattackbutton.setBackground(Color.WHITE);
		helpspecialattackbutton.setForeground(Color.DARK_GRAY);
		helpspecialattackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"An attack that deals damage depending on your and the opponent's type.",
						"Special Attack Explained", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(helpspecialattackbutton);

		// button for informing the player
		helphealbutton.setBounds(630, 380, 45, 50);
		helphealbutton.setFocusable(false);
		helphealbutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		helphealbutton.setBackground(Color.WHITE);
		helphealbutton.setForeground(Color.DARK_GRAY);
		helphealbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This command will heal your biomon with 50 % of its maximum HP.",
						"Healing Explained", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(helphealbutton);

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