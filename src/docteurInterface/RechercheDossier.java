package docteurInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import patientInterface.AfficheDossier;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RechercheDossier {

	JFrame frame;
	private JTextField matPat;
	private JButton btnConf;
	JPanel backgroundPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercheDossier window = new RechercheDossier();
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
	public RechercheDossier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		frame = new JFrame();
		frame.setSize(800,500);
		frame.setBounds(100, 100, 800, 503);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
   	 ImageIcon backgroundImage = new ImageIcon("src/background.png");

//Create a panel for holding the background image
   backgroundPanel = new JPanel() {
       @Override
       protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
       }
   };
   backgroundPanel.setBounds(0, 0, 800, 500); // Set bounds to cover the entire frame
   backgroundPanel.setLayout(null); // Using null layout for positioning components freely

		JLabel lblDonnerMatriculePatielt = new JLabel("Donner Matricule Patient");
		lblDonnerMatriculePatielt.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonnerMatriculePatielt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDonnerMatriculePatielt.setBounds(-10, 31, 786, 53);
		frame.getContentPane().add(lblDonnerMatriculePatielt);
		
		matPat = new JTextField();
		matPat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		matPat.setBounds(213, 146, 346, 82);
		frame.getContentPane().add(matPat);
		matPat.setColumns(10);
		
		btnConf = new JButton("Confirmer");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AfficheDossier frame = new AfficheDossier(matPat.getText());
				frame.frame.setVisible(true);
			}
		});
		btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnConf.setBounds(285, 303, 207, 58);
		frame.getContentPane().add(btnConf);
		frame.getContentPane().add(backgroundPanel);
	}

}
