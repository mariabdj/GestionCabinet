package patientInterface;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AfficheDossier {

	public JFrame frame;
	private JTable tableCons;
	private Connection connection;
	JPanel backgroundPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String mat="64";
					AfficheDossier window = new AfficheDossier(mat);
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
	public AfficheDossier(String mat) {
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

		
		String matricule = mat;
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 799, 501);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 103, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNomPrnom = new JLabel("Nom, Prénom");
		lblNomPrnom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomPrnom.setBounds(103, 11, 363, 37);
		frame.getContentPane().add(lblNomPrnom);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe Sanguin :");
		lblGroupeSanguin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGroupeSanguin.setBounds(552, 11, 179, 37);
		frame.getContentPane().add(lblGroupeSanguin);
		
		JLabel txtGS = new JLabel("O");
		txtGS.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtGS.setBounds(730, 11, 45, 37);
		frame.getContentPane().add(txtGS);
		
		JLabel lblLesConsultation = new JLabel("Les Consultation :");
		lblLesConsultation.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLesConsultation.setBounds(10, 59, 179, 37);
		frame.getContentPane().add(lblLesConsultation);
		
		tableCons = new JTable();
		tableCons.setBounds(10, 107, 765, 346);
		frame.getContentPane().add(tableCons);
		
		
		//Afficher nom prenom
		try {
            String sql = "SELECT nom, prenom FROM Patient WHERE matPat = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, matricule);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Affichage du nom et prénom du patient
                lblNomPrnom.setText(rs.getString("nom") + ", " + rs.getString("prenom"));
            } else {
                // Si aucun patient trouvé avec le matricule "01"
                System.out.println("Aucun patient trouvé avec le matricule '01'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		//Afficher Consultation
		try {
            String sql = "SELECT * FROM Consultation WHERE matPat_Dos = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, matricule);
            ResultSet rs = pstmt.executeQuery();

            // Mettre le résultat dans le modèle de la table
            tableCons.setModel(DbUtils.resultSetToTableModel(rs)); // Utilisation de DbUtils pour convertir le ResultSet en modèle de table

            // Rendre la table scrollable
            JScrollPane scrollPane = new JScrollPane(tableCons);
            scrollPane.setBounds(10, 107, 765, 346);
            frame.getContentPane().add(scrollPane);

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		//Afficher Groupe Sanguin
		try {
            String sql = "SELECT groupeSanguin FROM DossierMedicale WHERE matPat_Dos = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, matricule);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Affichage du nom et prénom du patient
            	txtGS.setText(rs.getString("groupeSanguin"));
            } else {
                // Si aucun patient trouvé avec le matricule "01"
                System.out.println("Aucun patient trouvé avec le matricule '01'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		frame.getContentPane().add(backgroundPanel);
		
	}

}
