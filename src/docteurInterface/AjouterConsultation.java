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

public class AjouterConsultation {

	JFrame frame;
	private JTextField matPat;
	private JTextField txtDiag;
	private JTextField txtMed;
	private JTextField txtDate;
	private Connection connection;
	private Statement statement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterConsultation window = new AjouterConsultation();
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
	public AjouterConsultation() {
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
		frame.setBounds(100, 100, 804, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricule Patient :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(23, 32, 233, 68);
		frame.getContentPane().add(lblNewLabel);
		
		matPat = new JTextField();
		matPat.setFont(new Font("Tahoma", Font.PLAIN, 26));
		matPat.setColumns(10);
		matPat.setBounds(242, 44, 197, 45);
		frame.getContentPane().add(matPat);
		
		JLabel lblNewLabel_1 = new JLabel("Consultation :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(311, 111, 212, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDiagnostique = new JLabel("Diagnostique :");
		lblDiagnostique.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDiagnostique.setBounds(23, 183, 233, 68);
		frame.getContentPane().add(lblDiagnostique);
		
		txtDiag = new JTextField();
		txtDiag.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtDiag.setColumns(10);
		txtDiag.setBounds(209, 195, 554, 45);
		frame.getContentPane().add(txtDiag);
		
		JLabel lblMdicament = new JLabel("Médicament :");
		lblMdicament.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMdicament.setBounds(23, 273, 233, 68);
		frame.getContentPane().add(lblMdicament);
		
		txtMed = new JTextField();
		txtMed.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtMed.setColumns(10);
		txtMed.setBounds(209, 282, 554, 45);
		frame.getContentPane().add(txtMed);
		
		JLabel jlabel = new JLabel("Date :");
		jlabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		jlabel.setBounds(23, 352, 233, 68);
		frame.getContentPane().add(jlabel);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtDate.setColumns(10);
		txtDate.setBounds(124, 364, 197, 45);
		frame.getContentPane().add(txtDate);
		
		JButton btnConf = new JButton("Confirmer");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        // Récupérer les valeurs saisies dans les champs de votre interface
			        String matriculePatient = matPat.getText();
			        String diagnostic = txtDiag.getText();
			        String medicament = txtMed.getText();
			        String dateConsultation = txtDate.getText();

			        // Construire l'instruction SQL pour insérer une nouvelle consultation
			        String sql = "INSERT INTO Consultation (numCons, diagnostic, dateCons, medicament, matPat_Dos) "
			                   + "VALUES (numCons_seq.nextval, '" + diagnostic + "', TO_DATE('" + dateConsultation + "', 'DD MM YYYY'), '" + medicament + "', '" + matriculePatient + "')";

			        // Créer une nouvelle instance de Statement pour exécuter la requête
			        statement = connection.createStatement();

			        // Exécuter la requête d'insertion
			        statement.execute(sql);

			        // Afficher un message pour informer l'utilisateur que l'opération d'insertion a été effectuée avec succès
			        JOptionPane.showMessageDialog(frame, "Consultation ajoutée avec succès.");

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        JOptionPane.showMessageDialog(frame, "Erreur lors de l'ajout de la consultation.");
			    }
			}
		});
		btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnConf.setBounds(556, 363, 207, 58);
		frame.getContentPane().add(btnConf);
	}

}
