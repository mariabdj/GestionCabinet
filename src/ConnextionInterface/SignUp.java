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
		
		JLabel lblNewLabel = new JLabel("Nom D'utilisateur :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 19, 201, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot De Passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setBounds(410, 10, 187, 55);
		frame.getContentPane().add(lblMotDePasse);
		
		lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 77, 139, 63);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblPrnom = new JLabel("Prénom :");
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrnom.setBounds(10, 155, 139, 63);
		frame.getContentPane().add(lblPrnom);
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 236, 139, 63);
		frame.getContentPane().add(lblEmail);
		
		lblGenre = new JLabel("Genre :");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGenre.setBounds(10, 321, 139, 63);
		frame.getContentPane().add(lblGenre);
		
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
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nom.setColumns(10);
		nom.setBounds(145, 90, 200, 48);
		frame.getContentPane().add(nom);
		
		prenom = new JTextField();
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prenom.setColumns(10);
		prenom.setBounds(145, 168, 200, 48);
		frame.getContentPane().add(prenom);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBounds(145, 249, 200, 48);
		frame.getContentPane().add(email);
		
		genre = new JTextField();
		genre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genre.setColumns(10);
		genre.setBounds(145, 334, 200, 48);
		frame.getContentPane().add(genre);
		
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
		connexion.setFont(new Font("Tahoma", Font.PLAIN, 28));
		connexion.setBounds(278, 404, 249, 48);
		frame.getContentPane().add(connexion);
		return idPatient2;

	}

}
