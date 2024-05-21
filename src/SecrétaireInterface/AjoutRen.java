package SecrétaireInterface;
import java.awt.EventQueue;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AjoutRen {

	 JFrame frame;
	private JTextField dateRen;
	private JTextField heure;
	private Connection connection;
	private Statement statement;
	private JTextField matPat_Ren;
	private JLabel lblNewLabel;
	JPanel backgroundPanel;


	
	 // Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutRen window = new AjoutRen();
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
	public AjoutRen() {
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
			   statement = connection.createStatement();
		
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
		        backgroundPanel.setBounds(0, 0, 800, 505); // Set bounds to cover the entire frame
		        backgroundPanel.setLayout(null); // Using null layout for positioning components freely


		
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setBounds(100, 100, 801, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un rendez-vous ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1.setBounds(196, 11, 394, 53);
		frame.getContentPane().add(lblNewLabel_1); 
		
		lblNewLabel = new JLabel("Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 102, 166, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHeure = new JLabel("Heure :");
		lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHeure.setBounds(66, 200, 166, 46);
		frame.getContentPane().add(lblHeure);
		
		dateRen = new JTextField();
		dateRen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		dateRen.setBounds(335, 98, 400, 60);
		frame.getContentPane().add(dateRen);
		dateRen.setColumns(10);
		
        heure = new JTextField();
		heure.setFont(new Font("Tahoma", Font.PLAIN, 30));
		heure.setColumns(10);
		heure.setBounds(335, 195, 400, 60);
		frame.getContentPane().add(heure);
		
		JLabel lblMatricule = new JLabel("Matricule:");
		lblMatricule.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblMatricule.setBounds(81, 281, 166, 46);
		frame.getContentPane().add(lblMatricule);
		
		matPat_Ren = new JTextField();
		matPat_Ren.setFont(new Font("Tahoma", Font.PLAIN, 30));
		matPat_Ren.setColumns(10);
		matPat_Ren.setBounds(335, 276, 400, 60);
		frame.getContentPane().add(matPat_Ren);
		
		
	
		
		JButton btnDrPrincipale1 = new JButton("Dr. Principale");
		btnDrPrincipale1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		
		        try {
		         

		            // Récupérer les valeurs saisies dans les champs de votre 
                   
		            String matricule_patient = matPat_Ren.getText();
		            String date_rendezvous = dateRen.getText();
		            String Heure =heure.getText();
		            
		            

		           // Construire l'instruction SQL avec la séquence numRen_seq.nextval pour NUMREN
		            String sql = "INSERT INTO RendezVous  (numRen, dateRen, heure, matPat_Ren, medStat_Ren) "
		                + "VALUES (numRen_seq.nextval, TO_DATE('" + date_rendezvous + "', 'DD-MM-YYYY'), '" + Heure + "', '" + matricule_patient + "', 'P')";
		       

		            // Exécuter la requête
		            statement.execute(sql);

		            // Afficher un message pour informer l'utilisateur que l'opération d'insertion a bien été effectuée.
		            JOptionPane.showMessageDialog(btnDrPrincipale1, "Rendez-Vous Pris");

		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(btnDrPrincipale1, "Erreur");
		        }
		    }
		});
		btnDrPrincipale1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDrPrincipale1.setBounds(45, 380, 307, 70);
		frame.getContentPane().add(btnDrPrincipale1);

		JButton btnDrRemplacant = new JButton("Dr. Remplaçant");
		btnDrRemplacant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		    	
		          try {
		            // Créer une nouvelle instance de connexion à la BDD Oracle
		            statement = connection.createStatement();

		            // Récupérer les valeurs saisies dans les champs de votre interface
		            
		            String matricule_patient = matPat_Ren.getText();
		            String date_rendezvous = dateRen.getText();
		            String Heure = heure.getText();

		            // Construire l'instruction SQL avec la séquence numRen_seq.nextval pour NUMREN
		            String sql = "INSERT INTO RendezVous (numRen, dateRen, heure, matPat_Ren, medStat_Ren) "
		                    + "VALUES (numRen_seq.nextval, TO_DATE('" + date_rendezvous + "', 'DD-MM-YYYY'), '" + Heure + "', '" + matricule_patient + "', 'R')";

		            // Exécuter la requête
		            statement.execute(sql);

		            // Afficher un message pour informer l'utilisateur que l'opération d'insertion a bien été effectuée.
		            JOptionPane.showMessageDialog(btnDrRemplacant, "Rendez-Vous Pris");

		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(btnDrRemplacant, "Erreur");
		        }
		    }
		});
		btnDrRemplacant.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDrRemplacant.setBounds(461, 380, 301, 70);
		frame.getContentPane().add(btnDrRemplacant);
		frame.getContentPane().add(backgroundPanel);
   
	}}

