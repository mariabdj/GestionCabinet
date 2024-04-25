package docteurInterface;

import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RemplirDossier {

	JFrame frame;
	private JTextField matPat;
	private JTextField txtGS;
	private JLabel lblNewLabel_1;
	private JLabel lblDiagnostique;
	private JLabel lblMdicament;
	private JLabel txtDate;
	private JTextField txtDiag;
	private JTextField txtMed;
	private JTextField textField_2;
	private JButton btnConf;
	
	private Connection connection;
	private Statement statement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemplirDossier window = new RemplirDossier();
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
	public RemplirDossier() {
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
		frame.setSize(800,500);
		frame.setBounds(100, 100, 800, 502);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricule Patient :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 27, 233, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe Sanguin :");
		lblGroupeSanguin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGroupeSanguin.setBounds(464, 27, 207, 68);
		frame.getContentPane().add(lblGroupeSanguin);
		
		matPat = new JTextField();
		matPat.setFont(new Font("Tahoma", Font.PLAIN, 26));
		matPat.setBounds(229, 39, 197, 45);
		frame.getContentPane().add(matPat);
		matPat.setColumns(10);
		
		txtGS = new JTextField();
		txtGS.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtGS.setColumns(10);
		txtGS.setBounds(681, 45, 95, 45);
		frame.getContentPane().add(txtGS);
		
		lblNewLabel_1 = new JLabel("Consultation :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(298, 106, 212, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblDiagnostique = new JLabel("Diagnostique :");
		lblDiagnostique.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDiagnostique.setBounds(10, 178, 233, 68);
		frame.getContentPane().add(lblDiagnostique);
		
		lblMdicament = new JLabel("Médicament :");
		lblMdicament.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMdicament.setBounds(10, 268, 233, 68);
		frame.getContentPane().add(lblMdicament);
		
		txtDate = new JLabel("Date :");
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtDate.setBounds(10, 347, 233, 68);
		frame.getContentPane().add(txtDate);
		
		txtDiag = new JTextField();
		txtDiag.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtDiag.setColumns(10);
		txtDiag.setBounds(196, 190, 554, 45);
		frame.getContentPane().add(txtDiag);
		
		txtMed = new JTextField();
		txtMed.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtMed.setColumns(10);
		txtMed.setBounds(196, 277, 554, 45);
		frame.getContentPane().add(txtMed);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField_2.setColumns(10);
		textField_2.setBounds(111, 359, 197, 45);
		frame.getContentPane().add(textField_2);
		
		btnConf = new JButton("Confirmer");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				    // Créer une nouvelle instance de Statement pour exécuter la requête
				    statement = connection.createStatement();
				  
				    // Récupérer les valeurs saisies dans les champs de votre interface
				    String matriculePatient = matPat.getText();
				    String diagnostic = txtDiag.getText();
				    String medicament = txtMed.getText();
				    String date = textField_2.getText(); // Il semble que le champ de texte pour la date soit textField_2 dans votre code

				    // Construire l'instruction SQL pour insérer le dossier patient dans la table DossierMedicale
				    String sqlDossier = "INSERT INTO DossierMedicale (numDos, groupeSanguin, matPat_Dos) " +
		                    "VALUES (numDos_seq.nextval, '" + txtGS.getText() + "', '" + matriculePatient + "')";

				                      
				    // Exécuter la requête pour ajouter le dossier patient
				    statement.execute(sqlDossier);
				   
				    // Construire l'instruction SQL pour insérer la consultation dans la table Consultation
				    String sqlConsultation = "INSERT INTO Consultation (numCons, diagnostic, dateCons, medicament, matPat_Dos) "
				                            + "VALUES (numCons_seq.nextval, '" + diagnostic + "', TO_DATE('" + date + "', 'DD-MM-YYYY'), '" + medicament + "', '" + matriculePatient + "')";

				    // Exécuter la requête pour ajouter la consultation
				    statement.execute(sqlConsultation);
				   
				    // Afficher un message pour informer l'utilisateur que l'opération a bien été effectuée
				    JOptionPane.showMessageDialog(btnConf, "Dossier Patient et Consultation ajoutés avec succès");

				} catch (SQLException e1) {
				    e1.printStackTrace();
				    JOptionPane.showMessageDialog(btnConf, "Erreur");
				}


			}
		});
		btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnConf.setBounds(543, 358, 207, 58);
		frame.getContentPane().add(btnConf);
	}
}
