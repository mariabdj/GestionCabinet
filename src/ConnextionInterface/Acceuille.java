package ConnextionInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import patientInterface.PatientPrincipale;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Acceuille {

	private JFrame frame;
	JPanel backgroundPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuille window = new Acceuille();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuille() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon backgroundImage = new ImageIcon("src/background.png");

		// Create a panel for holding the background image
		        backgroundPanel = new JPanel() {
		            @Override
		            protected void paintComponent(Graphics g) {
		                super.paintComponent(g);
		                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
		            }
		        };
		        backgroundPanel.setBounds(0, 0, 800, 505); // Set bounds to cover the entire frame
		        backgroundPanel.setLayout(null); // Using null layout for positioning components freely

		
		JLabel lblNewLabel = new JLabel("Bonjour, Voulez Vous :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(214, 32, 385, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Vous Connectez");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn sign = new SignIn();
		        sign.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton.setBounds(57, 219, 284, 81);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCrezUnCompte = new JButton("Créez Un Compte");
		btnCrezUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp sign = new SignUp();
		        sign.frame.setVisible(true);
			}
		});
		btnCrezUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnCrezUnCompte.setBounds(450, 219, 284, 81);
		frame.getContentPane().add(btnCrezUnCompte);
		frame.getContentPane().add(backgroundPanel);
	}

}
