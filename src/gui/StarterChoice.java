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

public class StarterChoice extends JFrame {

	// starter menu class

	public StarterChoice() throws IOException {
		setTitle("Biomon");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 768, 432);
		setLayout(new BorderLayout());

		// panel for an info text and the biomon icons
		JPanel picAndInfoPanel = new JPanel(new BorderLayout());

		// label for the biomon icons
		BufferedImage myPicture = ImageIO.read(new File("C:/Users/pröhl/Downloads/StarterChoice.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picAndInfoPanel.add(picLabel, BorderLayout.CENTER);

		// panel to inform the player what to do
		JPanel infoPanel = new JPanel();
		infoPanel.add(new JLabel("Welcome to the world of Biomon! Please choose a Biomon to start your battles with."));
		picAndInfoPanel.add(infoPanel, BorderLayout.NORTH);
		add(picAndInfoPanel);

		// control panel with further panels and buttons to choose whether to attack or
		// heal
		JPanel controlPanel = new JPanel(new FlowLayout());

		// panel with button to choose the fluffy starter
		JPanel fluffyPanel = new JPanel();
		JButton b1 = new JButton("Fluffy");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(StarterChoice.this,
						"Do you want to choose Fluffy as your Starter?", "Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					StarterChoice.this.dispose();
					try {
						Fight Fight = new Fight();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		fluffyPanel.add(b1);
		controlPanel.add(fluffyPanel, FlowLayout.LEFT);

		// panel with button to choose the crispy starter
		JPanel crispyPanel = new JPanel();
		b1 = new JButton("Crispy");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(StarterChoice.this,
						"Do you want to choose Crispy as your Starter?", "Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					StarterChoice.this.dispose();
					try {
						Fight Fight = new Fight();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		crispyPanel.add(b1);
		controlPanel.add(crispyPanel);

		// panel with button to choose the slimy starter
		JPanel slimyPanel = new JPanel();
		b1 = new JButton("Slimy");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(StarterChoice.this,
						"Do you want to choose Slimy as your Starter?", "Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					StarterChoice.this.dispose();
					try {
						Fight Fight = new Fight();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
				JOptionPane.showMessageDialog(StarterChoice.this,
						"Please choose a starter by clicking on one of the buttons.");
			}
		});
		helpPanel.add(b2);
		topPanel.add(helpPanel, BorderLayout.WEST);

		// panel with button to close program
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		b2 = new JButton("Menu");
		b2.setPreferredSize(new Dimension(100, 25));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(StarterChoice.this, "Do you want to return to the menu?",
						"Please confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					StarterChoice.this.dispose();
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
		topPanel.add(buttonPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);

		// sets frame visible
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new StarterChoice();
	}

}
