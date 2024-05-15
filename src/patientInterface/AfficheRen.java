package patientInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;

public class AfficheRen {

	public JFrame frame;
	private JTable tableRen;
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
					AfficheRen window = new AfficheRen(mat);
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
	public AfficheRen(String mat) {
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tableRen = new JTable();
		tableRen.setBounds(10, 11, 766, 441);
		frame.getContentPane().add(tableRen);
		

		// Dans votre méthode initialize() ou dans votre constructeur
		String matriculePatient = mat; // Matricule du patient dont vous voulez afficher les rendez-vous

		try {
		    // Définir la requête SQL pour sélectionner les rendez-vous du patient spécifié
		    String sql = "SELECT * FROM RendezVous WHERE matPat_Ren = '" + matriculePatient + "'";

		    // Créer une nouvelle instance de Statement pour exécuter la requête
		    statement = connection.createStatement();

		    // Exécuter la requête et obtenir le résultat dans un ResultSet
		    ResultSet rs = statement.executeQuery(sql);

		    // Passer le ResultSet à un modèle de table pour afficher les données dans la JTable
		    tableRen.setModel(DbUtils.resultSetToTableModel(rs));

		    // Rendre la table scrollable si elle contient trop d'informations
		    JScrollPane scrollPane = new JScrollPane(tableRen);
		    scrollPane.setBounds(10, 11, 766, 441);
		    frame.getContentPane().add(scrollPane);

		} catch (SQLException e) {
		    e.printStackTrace();
		}

	}
}
