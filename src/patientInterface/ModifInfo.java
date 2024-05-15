package patientInterface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ModifInfo {

	public JFrame frame;
	private JTextField txtNom;
	private JLabel lblMaladies;
	private JTextField txtMaldie;
	private JLabel lblPrnom;
	private JTextField txtPrenom;
	private JLabel lblNewLabel_3;
	private JTextField txtTel;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblNewLabel_5;
	private JTextField txtDateNai;
	private JLabel lblGenre;
	private JTextField txtGenre;
	private JLabel lblNewLabel_7;
	private JTextField txtAdresse;
	private JButton btnModifier;
	private Connection connection;
	private Statement statement;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String mat="64";
					ModifInfo window = new ModifInfo(mat);
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
	public ModifInfo(String mat) {
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
		
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 800, 508);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 139, 63);
		frame.getContentPane().add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNom.setBounds(188, 42, 200, 48);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		lblMaladies = new JLabel("Maladies :");
		lblMaladies.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaladies.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMaladies.setBounds(398, 30, 139, 63);
		frame.getContentPane().add(lblMaladies);
		
		txtMaldie = new JTextField();
		txtMaldie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaldie.setColumns(10);
		txtMaldie.setBounds(576, 42, 200, 48);
		frame.getContentPane().add(txtMaldie);
		
		lblPrnom = new JLabel("Prénom :");
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrnom.setBounds(10, 124, 139, 63);
		frame.getContentPane().add(lblPrnom);
		
		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(188, 136, 200, 48);
		frame.getContentPane().add(txtPrenom);
		
		lblNewLabel_3 = new JLabel("Tel :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(398, 124, 139, 63);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTel.setColumns(10);
		txtTel.setBounds(576, 136, 200, 48);
		frame.getContentPane().add(txtTel);
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmail.setBounds(10, 212, 139, 63);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(188, 224, 200, 48);
		frame.getContentPane().add(txtEmail);
		
		lblNewLabel_5 = new JLabel("Date naissance :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(398, 212, 168, 63);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtDateNai = new JTextField();
		txtDateNai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDateNai.setColumns(10);
		txtDateNai.setBounds(576, 224, 200, 48);
		frame.getContentPane().add(txtDateNai);
		
		lblGenre = new JLabel("Genre :");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGenre.setBounds(10, 296, 139, 63);
		frame.getContentPane().add(lblGenre);
		
		txtGenre = new JTextField();
		txtGenre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGenre.setColumns(10);
		txtGenre.setBounds(188, 308, 200, 48);
		frame.getContentPane().add(txtGenre);
		
		lblNewLabel_7 = new JLabel("Adresse :");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_7.setBounds(398, 296, 139, 63);
		frame.getContentPane().add(lblNewLabel_7);
		
		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(576, 308, 200, 48);
		frame.getContentPane().add(txtAdresse);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 //creer une new instance de connexion à la BDD Oracle
					   statement=connection.createStatement();
					  
					 //recuperer les valeurs saisies dans  les champs de votre interface
					   String nouveau_nom = txtNom.getText();
					   String nouveau_prenom = txtPrenom.getText();
					   String nouvel_email = txtEmail.getText();
					   String nouveau_genre = txtGenre.getText();
					   String nouvelles_maladies = txtMaldie.getText();
					   String nouvelle_adresse = txtAdresse.getText();
					   String nouveau_numtel = txtTel.getText();
					   String nouvelle_date_de_naissance = txtDateNai.getText();
					   String matricule_patient = mat;

					   String sql = "UPDATE Patient SET "
					               + "nom = '" + nouveau_nom + "', "
					               + "prenom = '" + nouveau_prenom + "', "
					               + "email = '" + nouvel_email + "', "
					               + "gender = '" + nouveau_genre + "', "
					               + "maladies = '" + nouvelles_maladies + "', "
					               + "adresse = '" + nouvelle_adresse + "', "
					               + "numtel = '" + nouveau_numtel + "', "
					               + "birthdate = '" + nouvelle_date_de_naissance + "' "
					               + "WHERE matPat = '" + matricule_patient + "'";

						 
					   // executer la requete
					   statement.execute(sql);
					   
					   // vider tous les champs de votre interface pour que l'utilisateur puisse facilement saisir des autres etudiants
					   txtNom.setText("");
					   txtPrenom.setText("");
					   txtEmail.setText("");				   
					   txtGenre.setText("");					   
					   txtAdresse.setText("");
					   txtMaldie.setText("");
					   txtTel.setText("");
					   txtDateNai.setText("");
					   
					   // afficher un message pour informer l'utilisateur que l'opertion d'insertion a bien été effectuée.
					   JOptionPane.showMessageDialog(btnModifier,"Vous avez bien mis à jour");
				 				 
				    } catch (SQLException e1) {
					 e1.printStackTrace();
					 JOptionPane.showMessageDialog(btnModifier,"Erreur");
				}
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnModifier.setBounds(275, 388, 249, 57);
		frame.getContentPane().add(btnModifier);
	}

}
