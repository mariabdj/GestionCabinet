package Secraitaire;

import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class InterfacePrincp {

	private JFrame frame;
	

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter un patient");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AjoutPatient ajoutP = new AjoutPatient();
				ajoutP.frame.setVisible(true);
			}
		});
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
	}
}
