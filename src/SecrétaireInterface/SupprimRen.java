package Secraitaire;


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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SupprimRen {

    JFrame frame;
	private JTextField txtDtate;
	private JTextField txtHeure;
	private Connection connection;
	private Statement statement;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimRen window = new SupprimRen();
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
	public SupprimRen() {
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
	      connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SECRAITAIRE", "DADI");
		
	        } catch (Exception e) {
			e.printStackTrace();
		     }
		
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    JLabel lblNewLabel = new JLabel("Date :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(38, 133, 166, 46);
		frame.getContentPane().add(lblNewLabel);
		
		txtDtate = new JTextField();
		txtDtate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtDtate.setColumns(10);
		txtDtate.setBounds(274, 128, 420, 60);
		frame.getContentPane().add(txtDtate);
		
		JLabel lblHeure = new JLabel("Heure :");
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblHeure.setBounds(53, 244, 166, 46);
		frame.getContentPane().add(lblHeure);
		
		txtHeure = new JTextField();
		txtHeure.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtHeure.setColumns(10);
		txtHeure.setBounds(274, 234, 420, 60);
		frame.getContentPane().add(txtHeure);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					 //creer une new instance de connexion à la BDD Oracle
					   statement=connection.createStatement();
					  
					 //recuperer les valeurs saisies dans  les champs de votre interface
		
					   
					   String date_rendezvous = txtDtate.getText();
					   String heure_rendezvous = txtHeure.getText();

					   String sql = "DELETE FROM RendezVous "
					              + "WHERE dateRen = '" + date_rendezvous + "' "
					              + "AND heure = '" + heure_rendezvous + "'";
						 
					   // executer la requete
					   int rowsAffected = statement.executeUpdate(sql);
					   
					   // vérifier si des lignes ont été affectées
					   if (rowsAffected > 0) {
					       // afficher un message pour informer l'utilisateur que l'opération de suppression a bien été effectuée.
					       JOptionPane.showMessageDialog(btnSupprimer, "Rendez-Vous Supprimé");
					   } else {
					       JOptionPane.showMessageDialog(btnSupprimer, "Aucun rendez-vous trouvé pour la date et l'heure spécifiées.");
					   }
					   
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
					 JOptionPane.showMessageDialog(btnSupprimer, "Erreur");
				}
				
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnSupprimer.setBounds(220, 350, 305, 61);
		frame.getContentPane().add(btnSupprimer);
		
		JLabel lblNewLabel_1 = new JLabel("Supprimer un Rrndez-vous");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(138, 34, 532, 35);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
