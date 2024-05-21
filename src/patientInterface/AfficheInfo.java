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
		
		
		frame.getContentPane().add(backgroundPanel);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(109, 43, 139, 63);
		backgroundPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel txtNom = new JLabel("Info");
		txtNom.setBounds(224, 43, 160, 63);
		backgroundPanel.add(txtNom);
		txtNom.setHorizontalAlignment(SwingConstants.LEFT);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setBounds(109, 137, 139, 63);
		backgroundPanel.add(lblPrnom);
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel txtPrenom = new JLabel("Info");
		txtPrenom.setBounds(242, 136, 168, 63);
		backgroundPanel.add(txtPrenom);
		txtPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(109, 225, 139, 63);
		backgroundPanel.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel txtEmail = new JLabel("Info");
		txtEmail.setBounds(242, 224, 119, 63);
		backgroundPanel.add(txtEmail);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(127, 309, 139, 63);
		backgroundPanel.add(lblGenre);
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel txtGenre = new JLabel("Info");
		txtGenre.setBounds(242, 308, 139, 63);
		backgroundPanel.add(txtGenre);
		txtGenre.setHorizontalAlignment(SwingConstants.LEFT);
		txtGenre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel txtAdresse = new JLabel("Info");
		txtAdresse.setBounds(507, 309, 247, 63);
		backgroundPanel.add(txtAdresse);
		txtAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_7 = new JLabel("Adresse :");
		lblNewLabel_7.setBounds(379, 309, 139, 63);
		backgroundPanel.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel txtDateNai = new JLabel("Info");
		txtDateNai.setBounds(553, 225, 201, 63);
		backgroundPanel.add(txtDateNai);
		txtDateNai.setHorizontalAlignment(SwingConstants.LEFT);
		txtDateNai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("Date naissance :");
		lblNewLabel_5.setBounds(379, 225, 168, 63);
		backgroundPanel.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_3 = new JLabel("Tel :");
		lblNewLabel_3.setBounds(379, 137, 139, 63);
		backgroundPanel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel txtInfo = new JLabel("Info");
		txtInfo.setBounds(480, 137, 247, 63);
		backgroundPanel.add(txtInfo);
		txtInfo.setHorizontalAlignment(SwingConstants.LEFT);
		txtInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel txtMaladie = new JLabel("Info");
		txtMaladie.setBounds(507, 43, 247, 63);
		backgroundPanel.add(txtMaladie);
		txtMaladie.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaladie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblMaladies = new JLabel("Maladies :");
		lblMaladies.setBounds(379, 43, 139, 63);
		backgroundPanel.add(lblMaladies);
		lblMaladies.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaladies.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
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

	}

}
