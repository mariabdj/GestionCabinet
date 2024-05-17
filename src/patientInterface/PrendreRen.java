package patientInterface;

import java.awt.EventQueue;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PrendreRen {

	public JFrame frame;
	private JTextField txtDate;
	private JTextField txtHeure;
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
					String mat="64";
					PrendreRen window = new PrendreRen(mat);
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
	public PrendreRen(String mat) {
		initialize(mat);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String mat) {
		
		try {
			//chargement de driver ojdbc pour se connecter à une BDD Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			//configurer le lien vers la BDD oracle avec toutes les informatons necessaires de la connexion à la BDD
		    connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","GestionCabinet", "medecin");
		
	        } catch (Exception e) {
			e.printStackTrace();
		     }
		
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

		
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 801, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 42, 166, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHeure = new JLabel("Heure :");
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblHeure.setBounds(45, 165, 166, 46);
		frame.getContentPane().add(lblHeure);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtDate.setBounds(218, 40, 433, 71);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtHeure = new JTextField();
		txtHeure.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtHeure.setColumns(10);
		txtHeure.setBounds(221, 154, 433, 71);
		frame.getContentPane().add(txtHeure);
		
		JButton btnDrPrincipale = new JButton("Dr. Principale");
		btnDrPrincipale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 //creer une new instance de connexion à la BDD Oracle
					   statement=connection.createStatement();
					  
					 //recuperer les valeurs saisies dans  les champs de votre interface
		
					   
					   String matricule_patient = mat;
					   String date_rendezvous = txtDate.getText();
					   String heure = txtHeure.getText();

					   // construire l'instruction SQL avec la séquence numRen_seq.nextval pour NUMREN
					   String sql = "INSERT INTO RendezVous (numRen, dateRen, heure, matPat_Ren, medStat_Ren) "
					           + "VALUES (numRen_seq.nextval, TO_DATE('" + date_rendezvous + "', 'DD MM YYYY'), '" + heure + "', '" + matricule_patient + "', 'P')";

					   // executer la requete
					   statement.execute(sql);
					   
					   // afficher un message pour informer l'utilisateur que l'opertion d'insertion a bien été effectuée.
					   JOptionPane.showMessageDialog(btnDrPrincipale,"Rendez-Vous Pris");
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
					 JOptionPane.showMessageDialog(btnDrPrincipale,"Erreur");
				}
			}
		});
		btnDrPrincipale.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDrPrincipale.setBounds(45, 332, 305, 85);
		frame.getContentPane().add(btnDrPrincipale);
		
		JButton btnDrRemplacant = new JButton("Dr. Remplaçant");
		btnDrRemplacant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 //creer une new instance de connexion à la BDD Oracle
					   statement=connection.createStatement();
					  
					 //recuperer les valeurs saisies dans  les champs de votre interface
		
					   
					   String matricule_patient = "01";
					   String date_rendezvous = txtDate.getText();
					   String heure = txtHeure.getText();

					   // construire l'instruction SQL avec la séquence numRen_seq.nextval pour NUMREN
					   String sql = "INSERT INTO RendezVous (numRen, dateRen, heure, matPat_Ren, medStat_Ren) "
					           + "VALUES (numRen_seq.nextval, TO_DATE('" + date_rendezvous + "', 'DD MM YYYY'), '" + heure + "', '" + matricule_patient + "', 'R')";

					   // executer la requete
					   statement.execute(sql);
					   
					   // afficher un message pour informer l'utilisateur que l'opertion d'insertion a bien été effectuée.
					   JOptionPane.showMessageDialog(btnDrPrincipale,"Rendez-Vous Pris");
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
				}
			}
		});
		btnDrRemplacant.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDrRemplacant.setBounds(435, 332, 305, 85);
		frame.getContentPane().add(btnDrRemplacant);
		frame.getContentPane().add(backgroundPanel);
	}
}
