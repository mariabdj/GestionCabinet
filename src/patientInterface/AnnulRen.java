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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnnulRen {

	public JFrame frame;
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
					AnnulRen window = new AnnulRen();
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
	public AnnulRen() {
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
		
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 801, 503);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(86, 83, 166, 46);
		frame.getContentPane().add(lblNewLabel);
		
		txtDtate = new JTextField();
		txtDtate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtDtate.setColumns(10);
		txtDtate.setBounds(274, 75, 433, 71);
		frame.getContentPane().add(txtDtate);
		
		JLabel lblHeure = new JLabel("Heure :");
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblHeure.setBounds(101, 200, 166, 46);
		frame.getContentPane().add(lblHeure);
		
		txtHeure = new JTextField();
		txtHeure.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtHeure.setColumns(10);
		txtHeure.setBounds(277, 189, 433, 71);
		frame.getContentPane().add(txtHeure);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
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
					   statement.execute(sql);
					   
					   // afficher un message pour informer l'utilisateur que l'opertion d'insertion a bien été effectuée.
					   JOptionPane.showMessageDialog(btnAnnuler,"Rendez-Vous Annulé");
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
					 JOptionPane.showMessageDialog(btnAnnuler,"Erreur");
				}
				
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnAnnuler.setBounds(244, 325, 305, 85);
		frame.getContentPane().add(btnAnnuler);
	}

}
