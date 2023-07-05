package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import gui.StarterChoice;

public class Fight extends JFrame {

	// starter menu class

	public Fight() throws IOException {
		setTitle("Biomon");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 768, 432);
		setLayout(new BorderLayout());

		// panel for an info text and the biomon icons
		JPanel picAndInfoPanel = new JPanel(new BorderLayout());

		// label for the biomon icons
		// BufferedImage myPicture = ImageIO.read(new
		// File("C:/Users/pröhl/Downloads/StarterChoice.png"));
		// JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		// picAndInfoPanel.add(picLabel, BorderLayout.CENTER);

		// panel to inform the player what to do
		JPanel infoPanel = new JPanel();
		infoPanel.add(new JLabel("You have been attacked! What do you want to do?"));
		picAndInfoPanel.add(infoPanel, BorderLayout.NORTH);
		add(picAndInfoPanel);

		// control panel with further panels and buttons to choose whether to attack or
		// heal
		JPanel controlPanel = new JPanel(new FlowLayout());

		// panel with button to choose the fluffy starter
		JPanel fluffyPanel = new JPanel();
		JButton b1 = new JButton("Basic Attack");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		fluffyPanel.add(b1);
		controlPanel.add(fluffyPanel, FlowLayout.LEFT);

		// panel with button to choose the crispy starter
		JPanel crispyPanel = new JPanel();
		b1 = new JButton("Special Attack");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		crispyPanel.add(b1);
		controlPanel.add(crispyPanel);

		// panel with button to choose the slimy starter
		JPanel slimyPanel = new JPanel();
		b1 = new JButton("Heal");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		slimyPanel.add(b1);
		controlPanel.add(slimyPanel, FlowLayout.RIGHT);
		add(controlPanel, BorderLayout.SOUTH);

		// panel with further panels and buttons to get help or close program
		JPanel topPanel = new JPanel(new BorderLayout());

		// panel with button to get help
		JPanel helpPanel = new JPanel(new FlowLayout());
		JButton b2 = new JButton("Help");
		b2.setPreferredSize(new Dimension(100, 25));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Fight.this,
						"Please choose what to do by clicking on one of the buttons.");
			}
		});
		helpPanel.add(b2);
		topPanel.add(helpPanel, BorderLayout.WEST);
		
		// panel with button to save progress
		JPanel savePanel = new JPanel();
		b2 = new JButton("Save");
		b2.setPreferredSize(new Dimension(100, 25));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Fight.this, "Do you want to save your progress?",
						"Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Fight.this,
							"Your progress has been saved.");
				}
			}
		});
		savePanel.add(b2);
		topPanel.add(savePanel, BorderLayout.CENTER);

		// panel with button to close program
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		b2 = new JButton("Menu");
		b2.setPreferredSize(new Dimension(100, 25));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Fight.this, "Do you want to return to the menu?",
						"Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Fight.this.dispose();
					try {
						Menu Menu = new Menu();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		buttonPanel.add(b2);
		topPanel.add(buttonPanel, BorderLayout.EAST);
		
		add(topPanel, BorderLayout.NORTH);

		// sets frame visible
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new Fight();
	}

}