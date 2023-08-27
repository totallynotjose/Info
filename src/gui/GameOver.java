package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOver extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel textlabel;
	ImageIcon iconimageicon;
	BackgroundPanel backgroundpanel;
	JLabel logolabel;
	JButton returnbutton;
	JButton closebutton;

	public int gameInput;

	public GameOver() {

		iconimageicon = new ImageIcon("Icon.png");
		backgroundpanel = new BackgroundPanel();
		textlabel = new JLabel();
		logolabel = new JLabel();
		returnbutton = new JButton("R e t u r n   t o   M a i n   M e n u");
		closebutton = new JButton("C l o s e   P r o g r a m");

		textlabel.setText("G A M E   O V E R !");
		textlabel.setFont(new Font("Agency FB", Font.BOLD, 78));
		textlabel.setForeground(Color.WHITE);
		textlabel.setBounds(120, 100, 480, 100);
		textlabel.setOpaque(false);
		this.add(textlabel);

		returnbutton.setBounds(250, 280, 200, 50);
		returnbutton.setFocusable(false);
		returnbutton.setFont(new Font("Agency FB", Font.BOLD, 16));
		returnbutton.setBackground(Color.WHITE);
		returnbutton.setForeground(Color.DARK_GRAY);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameOver.this.dispose();
				new MainMenu();
			}
		});
		this.add(returnbutton);
		
		closebutton.setBounds(250, 340, 200, 50);
		closebutton.setFocusable(false);
		closebutton.setFont(new Font("Agency FB", Font.BOLD, 16));
		closebutton.setBackground(Color.WHITE);
		closebutton.setForeground(Color.DARK_GRAY);
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameOver.this.dispose();
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
