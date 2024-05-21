package SecrétaireInterface;

import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class InterfacePrincp {

	private JFrame frame;
	JPanel backgroundPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrincp window = new InterfacePrincp();
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
	public InterfacePrincp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800,500);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter un patient");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AjoutPatient ajoutP = new AjoutPatient();
				ajoutP.frame.setVisible(true);
			}
		});
		
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


		        
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(52, 70, 300, 66);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSupprimerUnPatient = new JButton("Supprimer un patient");
		btnSupprimerUnPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupprimPatient SupprimeP = new SupprimPatient();
				SupprimeP.frame.setVisible(true);
			}
		});
		btnSupprimerUnPatient.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSupprimerUnPatient.setBounds(52, 195, 300, 66);
		frame.getContentPane().add(btnSupprimerUnPatient);
		
		JButton btnAfficherLesPatients = new JButton("Afficher les patients ");
		btnAfficherLesPatients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AffichPatient AffichP = new AffichPatient();
				AffichP.frame.setVisible(true);
			
			}
		});
		btnAfficherLesPatients.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAfficherLesPatients.setBounds(52, 336, 300, 66);
		frame.getContentPane().add(btnAfficherLesPatients);
		
		JButton btnAjouterRendezVous = new JButton("Ajouter un rendez-vous");
		btnAjouterRendezVous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AjoutRen Ajoutren = new AjoutRen();
				Ajoutren.frame.setVisible(true);
			}
		});
		btnAjouterRendezVous.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAjouterRendezVous.setBounds(435, 70, 300, 66);
		frame.getContentPane().add(btnAjouterRendezVous);
		
		JButton btnSupprimerRendezVous = new JButton("Supprimer rendez-vous ");
		btnSupprimerRendezVous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupprimRen SuppRen = new SupprimRen();
				SuppRen.frame.setVisible(true);
			}
		});
		btnSupprimerRendezVous.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSupprimerRendezVous.setBounds(435, 195, 300, 66);
		frame.getContentPane().add(btnSupprimerRendezVous);
		
		JButton btnAfficherLesRendezvous = new JButton("Afficher les rendez-vous");
		btnAfficherLesRendezvous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AfficherRen SupprimP = new AfficherRen();
				SupprimP.frame.setVisible(true);
			}
		});
		btnAfficherLesRendezvous.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAfficherLesRendezvous.setBounds(435, 336, 300, 66);
		frame.getContentPane().add(btnAfficherLesRendezvous);
		frame.getContentPane().add(backgroundPanel);
	}
}
