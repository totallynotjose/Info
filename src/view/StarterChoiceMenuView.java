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

/**
 * This class serves as graphical representation of the menu with which the
 * player's starter Biomon can be chosen.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class StarterChoiceMenuView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This ImageIcon is the icon shown in the upper left corner of the frame.
	 */
	private ImageIcon iconimageicon;
	/**
	 * This ImageIcon is the pixel artwork for the starter of the fluffy type.
	 */
	private ImageIcon fluffyimageicon;
	/**
	 * This ImageIcon is the pixel artwork for the starter of the slimy type.
	 */
	private ImageIcon slimyimageicon;
	/**
	 * This ImageIcon is the pixel artwork for the starter of the crispy type.
	 */
	private ImageIcon crispyimageicon;
	/**
	 * This background panel enables the use of a background image.
	 */
	private BackgroundPanelView backgroundpanel;
	/**
	 * This label includes information telling the player what to do.
	 */
	private JLabel textlabel;
	/**
	 * This label includes the fluffy imageicon.
	 */
	private JLabel fluffylabel;
	/**
	 * This label includes the slimy imageicon.
	 */
	private JLabel slimylabel;
	/**
	 * This label includes the crispy imageicon.
	 */
	private JLabel crispylabel;
	/**
	 * This button chooses fluffy as the starter.
	 */
	private JButton fluffybutton;
	/**
	 * This button chooses slimy as the starter.
	 */
	private JButton slimybutton;
	/**
	 * This button chooses crispy as the starter.
	 */
	private JButton crispybutton;
	/**
	 * This button explains the fluffy type to the player.
	 */
	private JButton helpfluffybutton;
	/**
	 * This button explains the slimy type to the player.
	 */
	private JButton helpslimybutton;
	/**
	 * This button explains the crispy type to the player.
	 */
	private JButton helpcrispybutton;

	/**
	 * This method creates a JFrame, initializes the components and adds them to the
	 * frame.
	 */
	public StarterChoiceMenuView() {

		// initializing of components
		iconimageicon = new ImageIcon("Icon.png");
		fluffyimageicon = new ImageIcon("Fluffy1.png");
		slimyimageicon = new ImageIcon("Slimy1.png");
		crispyimageicon = new ImageIcon("Crispy1.png");
		backgroundpanel = new BackgroundPanelView();
		textlabel = new JLabel();
		fluffylabel = new JLabel();
		slimylabel = new JLabel();
		crispylabel = new JLabel();
		fluffybutton = new JButton("Fluffy");
		slimybutton = new JButton("Slimy");
		crispybutton = new JButton("Crispy");
		helpfluffybutton = new JButton("?");
		helpslimybutton = new JButton("?");
		helpcrispybutton = new JButton("?");

		// label including information for player
		textlabel.setText("Choose one of the Biomon shown below by clicking on one of the buttons!");
		textlabel.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		textlabel.setForeground(Color.WHITE);
		textlabel.setBounds(62, 10, 700, 50);
		textlabel.setOpaque(false);
		this.add(textlabel);

		// label including the fluffy imageicon
		fluffylabel.setIcon(fluffyimageicon);
		fluffylabel.setOpaque(false);
		fluffylabel.setBounds(-20, 100, fluffyimageicon.getIconWidth(), fluffyimageicon.getIconHeight());
		this.add(fluffylabel);

		// label including the slimy imageicon
		slimylabel.setIcon(slimyimageicon);
		slimylabel.setOpaque(false);
		slimylabel.setBounds(230, 100, slimyimageicon.getIconWidth(), slimyimageicon.getIconHeight());
		this.add(slimylabel);

		// label including the crispy imageicon
		crispylabel.setIcon(crispyimageicon);
		crispylabel.setOpaque(false);
		crispylabel.setBounds(480, 100, crispyimageicon.getIconWidth(), crispyimageicon.getIconHeight());
		this.add(crispylabel);

		// button for choosing fluffy
		fluffybutton.setBounds(10, 380, 155, 50);
		fluffybutton.setFocusable(false);
		fluffybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		fluffybutton.setBackground(Color.WHITE);
		fluffybutton.setForeground(Color.DARK_GRAY);
		fluffybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Do you want to choose the fluffy type?", "Choose Fluffy Type?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					StarterChoiceMenuView.this.dispose();
					GameController.startGame(1);
				}
			}
		});
		this.add(fluffybutton);

		// button for choosing slimy
		slimybutton.setBounds(242, 380, 155, 50);
		slimybutton.setFocusable(false);
		slimybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		slimybutton.setBackground(Color.WHITE);
		slimybutton.setForeground(Color.DARK_GRAY);
		slimybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Do you want to choose the slimy type?", "Choose Slimy Type?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					StarterChoiceMenuView.this.dispose();
					GameController.startGame(2);
				}
			}
		});
		this.add(slimybutton);

		// button for choosing crispy
		crispybutton.setBounds(475, 380, 155, 50);
		crispybutton.setFocusable(false);
		crispybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		crispybutton.setBackground(Color.WHITE);
		crispybutton.setForeground(Color.DARK_GRAY);
		crispybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Do you want to choose the crispy type?", "Choose Crispy Type?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
						"") == JOptionPane.YES_OPTION) {
					StarterChoiceMenuView.this.dispose();
					GameController.startGame(3);
				}
			}
		});
		this.add(crispybutton);

		// button for informing the player
		helpfluffybutton.setBounds(165, 380, 45, 50);
		helpfluffybutton.setFocusable(false);
		helpfluffybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		helpfluffybutton.setBackground(Color.WHITE);
		helpfluffybutton.setForeground(Color.DARK_GRAY);
		helpfluffybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Biomon of this type are offensive and fast. They excel against crispy types.", "Fluffy Explained", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(helpfluffybutton);

		// button for informing the player
		helpslimybutton.setBounds(397, 380, 45, 50);
		helpslimybutton.setFocusable(false);
		helpslimybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		helpslimybutton.setBackground(Color.WHITE);
		helpslimybutton.setForeground(Color.DARK_GRAY);
		helpslimybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Biomon of this type are balanced. They excel against fluffy types.", "Slimy Explained", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(helpslimybutton);

		// button for informing the player
		helpcrispybutton.setBounds(630, 380, 45, 50);
		helpcrispybutton.setFocusable(false);
		helpcrispybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		helpcrispybutton.setBackground(Color.WHITE);
		helpcrispybutton.setForeground(Color.DARK_GRAY);
		helpcrispybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Biomon of this type are defensive and slow. They excel against slimy types.", "Crispy Explained", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.add(helpcrispybutton);

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
