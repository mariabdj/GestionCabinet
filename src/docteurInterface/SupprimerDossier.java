package docteurInterface;

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
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SupprimerDossier {

	JFrame frame;
	private JTextField matPat;
	private Connection connection;
	private Statement statement;
	JPanel backgroundPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerDossier window = new SupprimerDossier();
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
	public SupprimerDossier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			//chargement de driver ojdbc pour se connecter à une BDD Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			//configurer le lien vers la BDD oracle avec toutes les informatons necessaires de la connexion à la BDD
		    connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","GestionCabinet", "medecin");
		
	        } catch (Exception e) {
			e.printStackTrace();
		     }
		
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

		
		frame = new JFrame();
		frame.setSize(800,500);
		frame.setBounds(100, 100, 803, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDonnerMatriculePatient = new JLabel("Donner Matricule Patient");
		lblDonnerMatriculePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonnerMatriculePatient.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDonnerMatriculePatient.setBounds(-7, 53, 786, 37);
		frame.getContentPane().add(lblDonnerMatriculePatient);
		
		matPat = new JTextField();
		matPat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		matPat.setColumns(10);
		matPat.setBounds(219, 153, 346, 82);
		frame.getContentPane().add(matPat);
		
		JButton btnConf = new JButton("Confirmer");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            // Récupérer le matricule du patient depuis le champ texte
		            String matriculePatient = matPat.getText();

		            // Créer la requête SQL pour supprimer toutes les consultations du patient
		            String sqlDeleteConsultations = "DELETE FROM Consultation WHERE matPat_Dos = '" + matriculePatient + "'";

		            // Créer la requête SQL pour supprimer le dossier médical du patient
		            String sqlDeleteDossier = "DELETE FROM DossierMedicale WHERE matPat_Dos = '" + matriculePatient + "'";

		            // Créer une nouvelle instance de Statement pour exécuter les requêtes
		            statement = connection.createStatement();

		            // Exécuter la requête pour supprimer les consultations
		            statement.executeUpdate(sqlDeleteConsultations);

		            // Exécuter la requête pour supprimer le dossier médical
		            statement.executeUpdate(sqlDeleteDossier);

		            // Afficher un message de confirmation
		            System.out.println("Les consultations et le dossier médical du patient ont été supprimés avec succès.");

		        } catch (Exception ex) {
		            ex.printStackTrace();
				    JOptionPane.showMessageDialog(btnConf, "Erreur");

		        }
			}
		});
		btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnConf.setBounds(284, 298, 207, 58);
		frame.getContentPane().add(btnConf);
		frame.getContentPane().add(backgroundPanel);
	}

}
