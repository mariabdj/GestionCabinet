package patientInterface;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AfficheInfo {

	public JFrame frame;
	private Connection connection;
	JPanel backgroundPanel;

	String mat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String mat="64";
					AfficheInfo window = new AfficheInfo(mat);
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
	public AfficheInfo(String mat) {
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
		frame.setBounds(100, 100, 801, 501);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 63, 139, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrnom.setBounds(10, 157, 139, 63);
		frame.getContentPane().add(lblPrnom);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmail.setBounds(10, 245, 139, 63);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGenre.setBounds(10, 329, 139, 63);
		frame.getContentPane().add(lblGenre);
		
		JLabel txtNom = new JLabel("Info");
		txtNom.setHorizontalAlignment(SwingConstants.LEFT);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNom.setBounds(125, 63, 247, 63);
		frame.getContentPane().add(txtNom);
		
		JLabel txtPrenom = new JLabel("Info");
		txtPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrenom.setBounds(143, 156, 247, 63);
		frame.getContentPane().add(txtPrenom);
		
		JLabel txtEmail = new JLabel("Info");
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setBounds(143, 244, 230, 63);
		frame.getContentPane().add(txtEmail);
		
		JLabel txtGenre = new JLabel("Info");
		txtGenre.setHorizontalAlignment(SwingConstants.LEFT);
		txtGenre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGenre.setBounds(125, 328, 247, 63);
		frame.getContentPane().add(txtGenre);
		
		JLabel lblMaladies = new JLabel("Maladies :");
		lblMaladies.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaladies.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMaladies.setBounds(386, 63, 139, 63);
		frame.getContentPane().add(lblMaladies);
		
		JLabel lblNewLabel_3 = new JLabel("Tel :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(386, 157, 139, 63);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Date naissance :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(386, 245, 168, 63);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Adresse :");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_7.setBounds(386, 329, 139, 63);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel txtMaladie = new JLabel("Info");
		txtMaladie.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaladie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaladie.setBounds(514, 63, 247, 63);
		frame.getContentPane().add(txtMaladie);
		
		JLabel txtInfo = new JLabel("Info");
		txtInfo.setHorizontalAlignment(SwingConstants.LEFT);
		txtInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInfo.setBounds(487, 157, 247, 63);
		frame.getContentPane().add(txtInfo);
		
		JLabel txtDateNai = new JLabel("Info");
		txtDateNai.setHorizontalAlignment(SwingConstants.LEFT);
		txtDateNai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDateNai.setBounds(560, 245, 201, 63);
		frame.getContentPane().add(txtDateNai);
		
		JLabel txtAdresse = new JLabel("Info");
		txtAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdresse.setBounds(514, 329, 247, 63);
		frame.getContentPane().add(txtAdresse);
		
		try {
		    // Création de la requête SQL pour sélectionner les informations du patient avec le matricule "01"
		    String matricule = mat;
		    String sql = "SELECT nom, prenom, email, gender, maladies, numtel, birthdate, adresse FROM Patient WHERE matPat = ?";
		    
		    // Création d'un PreparedStatement avec la requête SQL
		    PreparedStatement pstmt = connection.prepareStatement(sql);
		    
		    // Attribution de la valeur du matricule au paramètre de la requête
		    pstmt.setString(1, matricule);
		    
		    // Exécution de la requête et récupération des résultats
		    ResultSet rs = pstmt.executeQuery();

		    // Vérification s'il y a des résultats
		    if (rs.next()) {
		        // Assignation des résultats aux labels correspondants
		        txtNom.setText(rs.getString("nom"));
		        txtPrenom.setText(rs.getString("prenom"));
		        txtEmail.setText(rs.getString("email"));
		        txtGenre.setText(rs.getString("gender"));
		        txtMaladie.setText(rs.getString("maladies"));
		        txtInfo.setText(rs.getString("numtel"));
		        txtDateNai.setText(rs.getString("birthdate"));
		        txtAdresse.setText(rs.getString("adresse"));
		    } else {
		        // Aucun patient trouvé avec le matricule "01"
		        System.out.println("Aucun patient trouvé avec le matricule '01'");
		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		}

		frame.getContentPane().add(backgroundPanel);
	}

}
