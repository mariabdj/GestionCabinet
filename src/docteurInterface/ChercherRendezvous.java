package docteurInterface;

import java.awt.EventQueue;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class ChercherRendezvous {

	JFrame frame;
	private JTextField txtDate;
	private JButton btnConf;
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
					ChercherRendezvous window = new ChercherRendezvous();
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
	public ChercherRendezvous() {
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
		frame.setBounds(100, 100, 800, 501);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Donnez = new JLabel("Donnez Date :");
		Donnez.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Donnez.setBounds(283, 26, 210, 44);
		frame.getContentPane().add(Donnez);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtDate.setColumns(10);
		txtDate.setBounds(64, 89, 346, 72);
		frame.getContentPane().add(txtDate);
		
		btnConf = new JButton("Confirmer");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				    // Récupérer la date saisie dans le champ txtDate
				    String dateRendezvous = txtDate.getText();

				    // Définir la requête SQL pour sélectionner les rendez-vous de la date spécifiée
				    String sql = "SELECT * FROM RendezVous WHERE dateRen = TO_DATE('" + dateRendezvous + "', 'DD-MM-YYYY')";

				    // Créer une nouvelle instance de Statement pour exécuter la requête
				    statement = connection.createStatement();

				    // Exécuter la requête et obtenir le résultat dans un ResultSet
				    ResultSet rs = statement.executeQuery(sql);

				    // Passer le ResultSet à un modèle de table pour afficher les données dans la JTable
				    table.setModel(DbUtils.resultSetToTableModel(rs));

				    // Rendre la table scrollable si elle contient trop d'informations
				    JScrollPane scrollPane = new JScrollPane(table);
				    scrollPane.setBounds(10, 192, 766, 261);
				    frame.getContentPane().add(scrollPane);

				} catch (SQLException ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(btnConf, "Erreur");
				}

			}
		});
		btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnConf.setBounds(493, 90, 219, 72);
		frame.getContentPane().add(btnConf);
		
		table = new JTable();
		table.setBounds(10, 192, 766, 261);
		frame.getContentPane().add(table);
	}

}
