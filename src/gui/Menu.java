package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import gui.StarterChoice;

public class Menu extends JFrame {

	// main menu class

	public Menu() throws IOException {
		setTitle("Biomon");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 768, 432);
		setLayout(new BorderLayout());

		/*
		 * BufferedImage myPicture = ImageIO.read(new
		 * File("C:/Users/pröhl/Downloads/MenuBackground.png")); JLabel picLabel = new
		 * JLabel(new ImageIcon(myPicture)); add(picLabel);
		 *
		 * panel with further panels and buttons for choosing to start a new game,
		 * continue an existing save file or close the program
		 */
		JPanel menuPanel = new JPanel(new GridLayout(3, 1));

		// panel with a button to start a new game (opens the Starter Choice Menu)
		JPanel startPanel = new JPanel();
		JButton b1 = new JButton("Start New Game");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Menu.this, "Do you want to start a new game?",
						"Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Menu.this.dispose();
					try {
						StarterChoice starter = new StarterChoice();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		startPanel.add(b1);
		menuPanel.add(startPanel);

		// panel with a button to continue an existing save file
		JPanel continuePanel = new JPanel();
		JButton b2 = new JButton("Continue Game");
		b2.setPreferredSize(new Dimension(200, 50));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Menu.this, "Do you want to continue an existing save file?",
						"Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
				}
			}
		});
		continuePanel.add(b2);
		menuPanel.add(continuePanel);

		// panel with a button to close the program
		JPanel closePanel = new JPanel();
		JButton b3 = new JButton("Close");
		b3.setPreferredSize(new Dimension(200, 50));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Menu.this, "Do you really want to close the program?",
						"Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Menu.this.dispose();
				}
			}
		});
		closePanel.add(b3);
		menuPanel.add(closePanel);

		add(menuPanel, BorderLayout.SOUTH);

		// sets frame visible
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {
		new Menu();
	}
}
