package Secraitaire;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class AfficherRen {

    public JFrame frame;
    private JTable table;
    private Connection connection;
    private Statement statement;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AfficherRen window = new AfficherRen();
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
    public AfficherRen() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Setup the frame
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Title label
        JLabel lblNewLabel = new JLabel("Liste des Rendez-Vous");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(260, 11, 300, 50);
        frame.getContentPane().add(lblNewLabel);

        // Table model
        model = new DefaultTableModel();
        model.addColumn("Numéro");
        model.addColumn("Date");
        model.addColumn("Heure");
        model.addColumn("Patient");
        model.addColumn("Médecin");

        // Table
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 760, 470);
        frame.getContentPane().add(scrollPane);

        // Load data from database
        loadData();
    }

    private void loadData() {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SECRAITAIRE", "DADI");
            statement = connection.createStatement();

            // Execute the query
            String query = "SELECT r.numRen, r.dateRen, r.heure, p.nom || ' ' || p.prenom AS patient, " +
                           "CASE WHEN r.medStat_Ren = 'P' THEN 'Dr. Principal' ELSE 'Dr. Remplaçant' END AS medecin " +
                           "FROM RendezVous r " +
                           "JOIN Patient p ON r.matPat_Ren = p.matPat";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int numRen = resultSet.getInt("numRen");
                String dateRen = resultSet.getString("dateRen");
                String heure = resultSet.getString("heure");
                String patient = resultSet.getString("patient");
                String medecin = resultSet.getString("medecin");

                // Add the row to the table model
                model.addRow(new Object[]{numRen, dateRen, heure, patient, medecin});
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors du chargement des rendez-vous.");
        }
    }
}
