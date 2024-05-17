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

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RechercheMatPatient {

	JFrame frame;
	private JTextField nomPat;
	private Connection connection;
	private Statement statement;
	private JTable tablePat;
	JPanel backgroundPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercheMatPatient window = new RechercheMatPatient();
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
	public RechercheMatPatient() {
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
		
   	 ImageIcon backgroundImage = new ImageIcon("src/background.png");

//Create a panel for holding the background image
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
		frame.setBounds(100, 100, 802, 501);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDonnezNomPatient = new JLabel("Donnez Nom Patient :");
		lblDonnezNomPatient.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDonnezNomPatient.setBounds(250, 25, 253, 44);
		frame.getContentPane().add(lblDonnezNomPatient);
		
		nomPat = new JTextField();
		nomPat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nomPat.setColumns(10);
		nomPat.setBounds(64, 90, 346, 72);
		frame.getContentPane().add(nomPat);
		tablePat = new JTable();
		tablePat.setBounds(10, 196, 768, 257);
		frame.getContentPane().add(tablePat);
		
		
		JButton btnConf = new JButton("Confirmer");
		btnConf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomPatient = nomPat.getText().toLowerCase();
				try {
		            String sql = "SELECT matPat, nom, prenom FROM Patient WHERE LOWER(nom) LIKE '" + nomPatient + "'";
		            statement = connection.createStatement();
		            ResultSet rs = statement.executeQuery(sql);
		            tablePat.setModel(DbUtils.resultSetToTableModel(rs));
		         
		        } catch (SQLException ex) {
		            ex.printStackTrace();
				    JOptionPane.showMessageDialog(btnConf, "Erreur");
		        }
			}
		});
		
		// Rendre la table scrollable si elle contient trop d'informations
        JScrollPane scrollPane = new JScrollPane(tablePat);
        scrollPane.setBounds(10, 196, 768, 257);
        frame.getContentPane().add(scrollPane);
		btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnConf.setBounds(493, 91, 219, 72);
		frame.getContentPane().add(btnConf);
		frame.getContentPane().add(backgroundPanel);
		
		
	}

}
