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

public class StarterChoiceMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon iconimageicon;
	ImageIcon fluffyimageicon;
	ImageIcon slimyimageicon;
	ImageIcon crispyimageicon;
	BackgroundPanel backgroundpanel;
	JLabel textlabel;
	JLabel fluffylabel;
	JLabel slimylabel;
	JLabel crispylabel;
	JButton fluffybutton;
	JButton slimybutton;
	JButton crispybutton;

	public StarterChoiceMenu() {

		iconimageicon = new ImageIcon("Icon.png");
		fluffyimageicon = new ImageIcon("Fluffy1.png");
		slimyimageicon = new ImageIcon("Slimy1.png");
		crispyimageicon = new ImageIcon("Crispy1.png");
		backgroundpanel = new BackgroundPanel();
		textlabel = new JLabel();
		fluffylabel = new JLabel();
		slimylabel = new JLabel();
		crispylabel = new JLabel();
		fluffybutton = new JButton("Fluffy");
		slimybutton = new JButton("Slimy");
		crispybutton = new JButton("Crispy");

		textlabel.setText(
				"Choose one of the Biomon shown below by clicking on one of the buttons!");
		textlabel.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		textlabel.setForeground(Color.WHITE);
		textlabel.setBounds(62, 10, 700, 50);
		textlabel.setOpaque(false);
		this.add(textlabel);

		fluffylabel.setIcon(fluffyimageicon);
		fluffylabel.setOpaque(false);
		fluffylabel.setBounds(-20, 100, fluffyimageicon.getIconWidth(), fluffyimageicon.getIconHeight());
		this.add(fluffylabel);

		slimylabel.setIcon(slimyimageicon);
		slimylabel.setOpaque(false);
		slimylabel.setBounds(230, 100, slimyimageicon.getIconWidth(), slimyimageicon.getIconHeight());
		this.add(slimylabel);

		crispylabel.setIcon(crispyimageicon);
		crispylabel.setOpaque(false);
		crispylabel.setBounds(480, 100, crispyimageicon.getIconWidth(), crispyimageicon.getIconHeight());
		this.add(crispylabel);

		fluffybutton.setBounds(10, 380, 200, 50);
		fluffybutton.setFocusable(false);
		fluffybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		fluffybutton.setBackground(Color.WHITE);
		fluffybutton.setForeground(Color.DARK_GRAY);
		fluffybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StarterChoiceMenu.this.dispose();
				Game.startGame(1);
			}
		});
		this.add(fluffybutton);

		slimybutton.setBounds(242, 380, 200, 50);
		slimybutton.setFocusable(false);
		slimybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		slimybutton.setBackground(Color.WHITE);
		slimybutton.setForeground(Color.DARK_GRAY);
		slimybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StarterChoiceMenu.this.dispose();
				Game.startGame(2);
			}
		});
		this.add(slimybutton);

		crispybutton.setBounds(475, 380, 200, 50);
		crispybutton.setFocusable(false);
		crispybutton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		crispybutton.setBackground(Color.WHITE);
		crispybutton.setForeground(Color.DARK_GRAY);
		crispybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StarterChoiceMenu.this.dispose();
				Game.startGame(3);
			}
		});
		this.add(crispybutton);

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