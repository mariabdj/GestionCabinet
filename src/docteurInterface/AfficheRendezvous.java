package docteurInterface;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AfficheRendezvous {

	JFrame frame;
	private Connection connection;
	private Statement statement;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficheRendezvous window = new AfficheRendezvous();
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
	public AfficheRendezvous() {
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
		frame.setBounds(100, 100, 801, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 760, 447);
		frame.getContentPane().add(table);
		
		String statutMedecin ="P";
		try {
	        // Définir la requête SQL pour sélectionner les rendez-vous du médecin spécifié
	        String sql = "SELECT * FROM RendezVous WHERE medStat_Ren Like '" + statutMedecin + "'";

	        // Créer une nouvelle instance de Statement pour exécuter la requête
	        statement = connection.createStatement();

	        // Exécuter la requête et obtenir le résultat dans un ResultSet
	        ResultSet rs = statement.executeQuery(sql);

	        // Passer le ResultSet à un modèle de table pour afficher les données dans la JTable
	        table.setModel(DbUtils.resultSetToTableModel(rs));

	        // Rendre la table scrollable si elle contient trop d'informations
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 11, 766, 441);
	        frame.getContentPane().add(scrollPane);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
