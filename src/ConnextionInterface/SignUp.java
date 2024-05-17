package ConnextionInterface;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import patientInterface.ModifInfo;
import patientInterface.PatientPrincipale;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SignUp {

	JFrame frame;
	private Connection connection;
	private JLabel lblNewLabel_1;
	private JLabel lblPrnom;
	private JLabel lblEmail;
	private JLabel lblGenre;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblMaladies;
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JTextField genre;
	private JTextField adrs;
	private JTextField dateNai;
	private JTextField tel;
	private JTextField maladie;
	private JTextField mdp;
	private JTextField utilisateur;
	private JButton connexion;
	JPanel backgroundPanel;
	String idPatient2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private String initialize() {
		
		try {
			//chargement de driver ojdbc pour se connecter à une BDD Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			//configurer le lien vers la BDD oracle avec toutes les informatons necessaires de la connexion à la BDD
		    connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","GestionCabinet", "medecin");
		
	        } catch (Exception e) {
			e.printStackTrace();
		     }
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 505);
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
	        backgroundPanel.setBounds(0, 0, 800, 505); // Set bounds to cover the entire frame
	        backgroundPanel.setLayout(null); // Using null layout for positioning components freely
		
		JLabel lblNewLabel = new JLabel("Nom D'utilisateur :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 19, 201, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot De Passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setBounds(410, 10, 187, 55);
		frame.getContentPane().add(lblMotDePasse);
		
		lblNewLabel_2 = new JLabel("Adresse :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(410, 321, 139, 63);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Date naissance :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(392, 247, 168, 63);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tel :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(410, 155, 139, 63);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblMaladies = new JLabel("Maladies :");
		lblMaladies.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaladies.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaladies.setBounds(410, 77, 139, 63);
		frame.getContentPane().add(lblMaladies);
		
		adrs = new JTextField();
		adrs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adrs.setColumns(10);
		adrs.setBounds(570, 327, 200, 48);
		frame.getContentPane().add(adrs);
		
		dateNai = new JTextField();
		dateNai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateNai.setColumns(10);
		dateNai.setBounds(570, 249, 200, 48);
		frame.getContentPane().add(dateNai);
		
		tel = new JTextField();
		tel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tel.setColumns(10);
		tel.setBounds(570, 168, 200, 48);
		frame.getContentPane().add(tel);
		
		maladie = new JTextField();
		maladie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		maladie.setColumns(10);
		maladie.setBounds(570, 90, 200, 48);
		frame.getContentPane().add(maladie);
		
		mdp = new JTextField();
		mdp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mdp.setColumns(10);
		mdp.setBounds(571, 18, 200, 48);
		frame.getContentPane().add(mdp);
		
		utilisateur = new JTextField();
		utilisateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		utilisateur.setColumns(10);
		utilisateur.setBounds(188, 18, 200, 48);
		frame.getContentPane().add(utilisateur);

		
		connexion = new JButton("Créer Compte");
		connexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            // Création d'une nouvelle instance de déclaration pour exécuter des requêtes SQL
		            Statement statement = connection.createStatement();

		            // Récupération des valeurs saisies dans les champs de votre interface
		            String nouveau_nom = nom.getText();
		            String nouveau_prenom = prenom.getText();
		            String nouvel_email = email.getText();
		            String nouveau_genre = genre.getText();
		            String nouvelles_maladies = maladie.getText();
		            String nouvelle_adresse = adrs.getText();
		            String nouveau_numtel = tel.getText();
		            String nouvelle_date_de_naissance = dateNai.getText();
		            String mot_de_passe = mdp.getText();
		            String nom_utilisateur = utilisateur.getText();

		            // Requête SQL pour insérer un nouveau patient
		            String sqlPatient = "INSERT INTO Patient (matPat, nom, prenom, email, gender, maladies, adresse, numtel, birthdate) VALUES "
		                                + "(matPat_seq.NEXTVAL, '" + nouveau_nom + "', '" + nouveau_prenom + "', '" + nouvel_email + "', '" + nouveau_genre + "', '" + nouvelles_maladies + "', '" + nouvelle_adresse + "', '" + nouveau_numtel + "', TO_DATE('" + nouvelle_date_de_naissance + "', 'YYYY-MM-DD'))";

		            // Exécution de la requête pour insérer le nouveau patient
		            statement.execute(sqlPatient);

		            // Récupération de l'ID du patient nouvellement inséré
		            String sqlGetId = "SELECT matPat_seq.CURRVAL FROM dual";
		            java.sql.ResultSet rs = statement.executeQuery(sqlGetId);
		            rs.next();
		            int idPatient = rs.getInt(1);
		            idPatient2 = String.valueOf(idPatient);

		            // Requête SQL pour insérer les informations de connexion dans la table SessionCompte
		            String sqlSessionCompte = "INSERT INTO SessionCompte (numSesCom, utilisateur, motDePasse, matPat_SesCom) VALUES "
		                                       + "(numSesCom_seq.NEXTVAL, '" + nom_utilisateur + "', '" + mot_de_passe + "', '" + idPatient + "')";

		            // Exécution de la requête pour insérer les informations de connexion
		            statement.execute(sqlSessionCompte);

		            // Vider tous les champs de votre interface pour que l'utilisateur puisse facilement saisir d'autres informations
		            nom.setText("");
		            prenom.setText("");
		            email.setText("");                   
		            genre.setText("");                      
		            adrs.setText("");
		            maladie.setText("");
		            tel.setText("");
		            dateNai.setText("");
		            mdp.setText("");
		            utilisateur.setText("");

		            // Affichage d'un message pour informer l'utilisateur que l'opération d'insertion a été effectuée avec succès
		            JOptionPane.showMessageDialog(connexion,"Vous avez bien créé un compte");
		            PatientPrincipale patient = new PatientPrincipale(idPatient2);
			        patient.frame.setVisible(true);

		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(connexion,"Erreur lors de la création du compte");
		        }
			}
		});
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connexion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		connexion.setBounds(278, 404, 249, 48);
		frame.getContentPane().add(connexion);
		frame.getContentPane().add(backgroundPanel);
		
		nom = new JTextField();
		nom.setBounds(187, 89, 200, 48);
		backgroundPanel.add(nom);
		nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(187, 167, 200, 48);
		backgroundPanel.add(prenom);
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prenom.setColumns(10);
		
		email = new JTextField();
		email.setBounds(187, 248, 200, 48);
		backgroundPanel.add(email);
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setColumns(10);
		
		genre = new JTextField();
		genre.setBounds(187, 333, 200, 48);
		backgroundPanel.add(genre);
		genre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setBounds(69, 77, 139, 63);
		backgroundPanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblPrnom = new JLabel("Prénom :");
		lblPrnom.setBounds(69, 155, 139, 63);
		backgroundPanel.add(lblPrnom);
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(69, 236, 139, 63);
		backgroundPanel.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(69, 321, 139, 63);
		backgroundPanel.add(lblGenre);
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		return idPatient2;

	}
	

}
