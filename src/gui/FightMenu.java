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

public class FightMenu extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ImageIcon iconimageicon;
		
		ImageIcon fluffy1imageicon;
		ImageIcon fluffy2imageicon;
		ImageIcon fluffy3imageicon;
		ImageIcon fluffy1Mimageicon;
		ImageIcon fluffy2Mimageicon;
		ImageIcon fluffy3Mimageicon;
		ImageIcon slimy1imageicon;
		ImageIcon slimy2imageicon;
		ImageIcon slimy3imageicon;
		ImageIcon slimy1Mimageicon;
		ImageIcon slimy2Mimageicon;
		ImageIcon slimy3Mimageicon;
		ImageIcon crispy1imageicon;
		ImageIcon crispy2imageicon;
		ImageIcon crispy3imageicon;
		ImageIcon crispy1Mimageicon;
		ImageIcon crispy2Mimageicon;
		ImageIcon crispy3Mimageicon;
		
		BackgroundPanel backgroundpanel;
		JLabel playertextlabel;
		JLabel enemytextlabel;
		JLabel playerlabel;
		JLabel enemylabel;
		JProgressBar playerbar;
		JProgressBar enemybar;
		JButton attack1button;
		JButton attack2button;
		JButton healbutton;
		
		int playercounter;
		int enemycounter;

		FightMenu() {
			
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
			attack1button = new JButton("a t t a c k");
			attack2button = new JButton("s p e c i a l   a t t a c k");
			healbutton = new JButton("h e a l");
			
			playercounter = 100;
			enemycounter = 100;
			
			playertextlabel.setText("[type] [level] [HP]/[max. HP]");
			playertextlabel.setFont(new Font("Agency FB", Font.BOLD, 16));
			playertextlabel.setForeground(Color.WHITE);
			playertextlabel.setBounds(20, 10, 700, 50);
			playerlabel.setOpaque(true);
			this.add(playertextlabel);
			
			enemytextlabel.setText("[type] [level] [HP]/[max. HP]");
			enemytextlabel.setFont(new Font("Agency FB", Font.BOLD, 16));
			enemytextlabel.setForeground(Color.WHITE);
			enemytextlabel.setBounds(470, 10, 700, 50);
			enemylabel.setOpaque(true);
			this.add(enemytextlabel);
			
			/*
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
			*/
			
			playerbar.setValue(playercounter);
			playerbar.setBounds(20, 50, 200, 15);
			playerbar.setFont(new Font("Agency FB", Font.BOLD, 0));
			playerbar.setForeground(new Color(0, 255, 0));
			playerbar.setBackground(new Color(50, 50, 50));
			playerbar.setStringPainted(true);
			this.add(playerbar);
			
			enemybar.setValue(enemycounter);
			enemybar.setBounds(470, 50, 200, 15);
			enemybar.setFont(new Font("Agency FB", Font.BOLD, 0));
			enemybar.setForeground(new Color(0, 255, 0));
			enemybar.setBackground(new Color(50, 50, 50));
			enemybar.setStringPainted(true);
			this.add(enemybar);
			
			attack1button.setBounds(10, 380, 200, 50);
			attack1button.setFocusable(false);
			attack1button.setFont(new Font("Agency FB", Font.BOLD, 16));
			attack1button.setBackground(Color.WHITE);
			attack1button.setForeground(Color.DARK_GRAY);
			attack1button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					attack1();
				}
			});
			this.add(attack1button);

			attack2button.setBounds(242, 380, 200, 50);
			attack2button.setFocusable(false);
			attack2button.setFont(new Font("Agency FB", Font.BOLD, 16));
			attack2button.setBackground(Color.WHITE);
			attack2button.setForeground(Color.DARK_GRAY);
			attack2button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					attack2();
				}
			});
			this.add(attack2button);

			healbutton.setBounds(475, 380, 200, 50);
			healbutton.setFocusable(false);
			healbutton.setFont(new Font("Agency FB", Font.BOLD, 16));
			healbutton.setBackground(Color.WHITE);
			healbutton.setForeground(Color.DARK_GRAY);
			healbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					playerheal();
				}
			});
			this.add(healbutton);

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
	
	public void playerheal() {
		if (playercounter >= 0 && playercounter <= 100) {
			playercounter = playercounter + 50;
			playerbar.setValue(playercounter);
		}
	}
	
	public void attack1() {
		if (enemycounter >= 0) {
			enemycounter = enemycounter - 10;
			enemybar.setValue(enemycounter);
		}
	}
	
	public void attack2() {
		if (enemycounter >= 0) {
			enemycounter = enemycounter - 10;
			enemybar.setValue(enemycounter);
		}
	}
}