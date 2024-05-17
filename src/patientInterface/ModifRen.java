package patientInterface;

import java.awt.EventQueue;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ModifRen {

	public JFrame frame;
	private JTextField txtNDate;
	private Connection connection;
	private Statement statement;
	private JTextField txtNHeure;
	private JTextField txtADate;
	private JTextField txtAHeure;
	JPanel backgroundPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifRen window = new ModifRen();
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
	public ModifRen() {
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
		
		JLabel lblNouvelleDate = new JLabel("Nouvelle Date :");
		lblNouvelleDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleDate.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNouvelleDate.setBounds(10, 176, 277, 46);
		frame.getContentPane().add(lblNouvelleDate);
		
		JLabel lblNouvelleHeure = new JLabel("Nouvelle Heure :");
		lblNouvelleHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleHeure.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNouvelleHeure.setBounds(10, 253, 296, 46);
		frame.getContentPane().add(lblNouvelleHeure);
		
		txtNDate = new JTextField();
		txtNDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNDate.setColumns(10);
		txtNDate.setBounds(326, 179, 433, 46);
		frame.getContentPane().add(txtNDate);
		
		JButton btnDrPrincipale = new JButton("Dr. Principale");
		btnDrPrincipale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 //creer une new instance de connexion à la BDD Oracle
					   statement=connection.createStatement();
					  
					 //recuperer les valeurs saisies dans  les champs de votre interface
		
					   String ndate = txtNDate.getText();
					   String nheure = txtNHeure.getText();
					   String adate = txtADate.getText();
					   String aheure = txtAHeure.getText();

					   String sql = "UPDATE RendezVous "
					           + "SET dateRen = TO_DATE('" + ndate + "', 'DD-MM-YYYY'), "
					           + "heure = '" + nheure + "', "
					           + "medStat_Ren = 'P' "
					           + "WHERE dateRen = TO_DATE('" + adate + "', 'DD-MM-YYYY') "
					           + "AND heure = '" + aheure + "'";



					   // executer la requete
					   statement.execute(sql);
					   
					   // afficher un message pour informer l'utilisateur que l'opertion d'insertion a bien été effectuée.
					   JOptionPane.showMessageDialog(btnDrPrincipale,"Rendez-Vous Modifié");
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
				}
			}
		});
		btnDrPrincipale.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDrPrincipale.setBounds(30, 331, 305, 85);
		frame.getContentPane().add(btnDrPrincipale);
		
		JButton btnDrRemplacant = new JButton("Dr. Remplaçant");
		btnDrRemplacant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 //creer une new instance de connexion à la BDD Oracle
					   statement=connection.createStatement();
					  
					 //recuperer les valeurs saisies dans  les champs de votre interface
		
					   String ndate = txtNDate.getText();
					   String nheure = txtNHeure.getText();
					   String adate = txtADate.getText();
					   String aheure = txtAHeure.getText();

					   String sql = "UPDATE RendezVous "
					           + "SET dateRen = TO_DATE('" + ndate + "', 'DD-MM-YYYY'), "
					           + "heure = '" + nheure + "', "
					           + "medStat_Ren = 'R' "
					           + "WHERE dateRen = TO_DATE('" + adate + "', 'DD-MM-YYYY') "
					           + "AND heure = '" + aheure + "'";



					   // executer la requete
					   statement.execute(sql);
					   
					   // afficher un message pour informer l'utilisateur que l'opertion d'insertion a bien été effectuée.
					   JOptionPane.showMessageDialog(btnDrPrincipale,"Rendez-Vous Modifié");
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
					 JOptionPane.showMessageDialog(btnDrPrincipale,"Erreur");
				}
			}
		});
		btnDrRemplacant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDrRemplacant.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDrRemplacant.setBounds(454, 331, 305, 85);
		frame.getContentPane().add(btnDrRemplacant);
		
		txtNHeure = new JTextField();
		txtNHeure.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtNHeure.setColumns(10);
		txtNHeure.setBounds(326, 253, 433, 46);
		frame.getContentPane().add(txtNHeure);
		
		JLabel lblAncienneDate = new JLabel("Ancienne Date :");
		lblAncienneDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAncienneDate.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblAncienneDate.setBounds(10, 27, 277, 46);
		frame.getContentPane().add(lblAncienneDate);
		
		txtADate = new JTextField();
		txtADate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtADate.setColumns(10);
		txtADate.setBounds(326, 30, 433, 46);
		frame.getContentPane().add(txtADate);
		
		JLabel lblAncienneHeure = new JLabel("Ancienne Heure :");
		lblAncienneHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAncienneHeure.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblAncienneHeure.setBounds(10, 104, 296, 46);
		frame.getContentPane().add(lblAncienneHeure);
		
		txtAHeure = new JTextField();
		txtAHeure.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtAHeure.setColumns(10);
		txtAHeure.setBounds(326, 104, 433, 46);
		frame.getContentPane().add(txtAHeure);
		frame.getContentPane().add(backgroundPanel);
	}
}
