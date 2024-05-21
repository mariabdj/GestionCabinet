package patientInterface;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PatientPrincipale {

	public JFrame frame;
	JPanel backgroundPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String mat="64";
					PatientPrincipale window = new PatientPrincipale(mat);
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
	public PatientPrincipale(String mat) {
		initialize(mat);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String mat) {
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 802, 500);
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
		        backgroundPanel.setBounds(0, 0, 800, 500); // Set bounds to cover the entire frame
		        backgroundPanel.setLayout(null); // Using null layout for positioning components freely

		JButton btnNewButton = new JButton("Afficher Information");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        AfficheInfo afficheInfo = new AfficheInfo(mat);
		        afficheInfo.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(41, 32, 292, 77);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModifierInformations = new JButton("Modifier Informations");
		btnModifierInformations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModifInfo modifInfo = new ModifInfo(mat);
		        modifInfo.frame.setVisible(true);
			}
		});
		btnModifierInformations.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModifierInformations.setBounds(41, 140, 292, 77);
		frame.getContentPane().add(btnModifierInformations);
		
		JButton btnAfficherDossier = new JButton("Afficher Dossier");
		btnAfficherDossier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AfficheDossier afficheDos = new AfficheDossier(mat);
		        afficheDos.frame.setVisible(true);
			}
		});
		btnAfficherDossier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAfficherDossier.setBounds(41, 246, 292, 77);
		frame.getContentPane().add(btnAfficherDossier);
		
		JButton btnModifezRendezvous = new JButton("Modifez Rendez-vous");
		btnModifezRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifezRendezvous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModifRen modifInfo = new ModifRen();
		        modifInfo.frame.setVisible(true);
			}
		});
		btnModifezRendezvous.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModifezRendezvous.setBounds(41, 355, 292, 77);
		frame.getContentPane().add(btnModifezRendezvous);
		
		JButton btnPrendreRendezvous = new JButton("Prendre Rendez-vous");
		btnPrendreRendezvous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrendreRen prendreRen = new PrendreRen(mat);
		        prendreRen.frame.setVisible(true);
			}
		});
		btnPrendreRendezvous.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrendreRendezvous.setBounds(453, 32, 292, 77);
		frame.getContentPane().add(btnPrendreRendezvous);
		
		JButton btnNewButton_2_1 = new JButton("Afficher Rendez-vous");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AfficheRen afficheRen = new AfficheRen(mat);
		        afficheRen.frame.setVisible(true);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(453, 140, 292, 77);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Annuler Rendez-vous");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnnulRen annulRen = new AnnulRen(mat);
		        annulRen.frame.setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3_1.setBounds(453, 246, 292, 77);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("Déconnexion");
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//here
				frame.dispose();
			}
		});
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4_1.setBounds(453, 355, 292, 77);
		frame.getContentPane().add(btnNewButton_4_1);
		frame.getContentPane().add(backgroundPanel);
	}
}
