package ConnextionInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import patientInterface.PatientPrincipale;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignIn {

	JFrame frame;
	private JTextField utilisateur;
	private JTextField mdp;
	private Connection connection;
	String idPatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
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
	public SignIn() {
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
		frame.setBounds(100, 100, 801, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom D'utilisateur :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(37, 62, 356, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot De Passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblMotDePasse.setBounds(37, 181, 356, 55);
		frame.getContentPane().add(lblMotDePasse);
		
		JButton connexion = new JButton("Connexion");
		connexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ICI
				try {
		            // Création d'une nouvelle instance de déclaration pour exécuter des requêtes SQL
		            Statement statement = connection.createStatement();

		            // Récupération des informations saisies par l'utilisateur
		            String nom_utilisateur = utilisateur.getText();
		            String mot_de_passe = mdp.getText();

		            // Requête SQL pour vérifier si le compte existe et récupérer l'ID du patient
		            String sql = "SELECT matPat_SesCom FROM SessionCompte WHERE utilisateur = '" + nom_utilisateur + "' AND motDePasse = '" + mot_de_passe + "'";
		            ResultSet rs = statement.executeQuery(sql);

		            if (rs.next()) {
		                // Le compte existe, récupération de l'ID du patient
		                idPatient = rs.getString("matPat_SesCom");
		                String idPatient2 = String.valueOf(idPatient);
		                JOptionPane.showMessageDialog(connexion, "Connexion réussie pour l'utilisateur avec l'ID patient : " + idPatient);
		                PatientPrincipale patient = new PatientPrincipale(idPatient2);
				        patient.frame.setVisible(true);
		            } else {
		                // Le compte n'existe pas
		                JOptionPane.showMessageDialog(connexion, "Erreur : Compte inexistant");
		            }

		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(connexion, "Erreur lors de la connexion");
		        }
			}
		});
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connexion.setFont(new Font("Tahoma", Font.PLAIN, 32));
		connexion.setBounds(225, 338, 356, 74);
		frame.getContentPane().add(connexion);
		
		utilisateur = new JTextField();
		utilisateur.setFont(new Font("Tahoma", Font.PLAIN, 32));
		utilisateur.setBounds(355, 62, 337, 59);
		frame.getContentPane().add(utilisateur);
		utilisateur.setColumns(10);
		
		mdp = new JTextField();
		mdp.setFont(new Font("Tahoma", Font.PLAIN, 32));
		mdp.setColumns(10);
		mdp.setBounds(355, 181, 337, 59);
		frame.getContentPane().add(mdp);
		
	}
}
