package Secraitaire;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AffichPatient {

    public JFrame frame;
    private JTable table;
    private Connection connection;
    private Statement statement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AffichPatient window = new AffichPatient();
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
    public AffichPatient() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        try {
            // Chargement du driver ojdbc pour se connecter à une BDD Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Configurer le lien vers la BDD oracle avec toutes les informations nécessaires de la connexion à la BDD
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SECRAITAIRE", "DADI");
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame();
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 760, 440);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        loadPatientData();
    }

    /**
     * Load patient data from the database and populate the JTable.
     */
    private void loadPatientData() {
        try {
            String query = "SELECT matPat, nom, prenom, email, gender, maladies, adresse, numtel, birthdate FROM Patient";
            ResultSet rs = statement.executeQuery(query);

            // Create table model and set columns
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Matricule");
            model.addColumn("Nom");
            model.addColumn("Prenom");
            model.addColumn("Email");
            model.addColumn("Genre");
            model.addColumn("Maladies");
            model.addColumn("Adresse");
            model.addColumn("Téléphone");
            model.addColumn("Date de Naissance");

            // Populate table model with data from ResultSet
            while (rs.next()) {
                Object[] row = new Object[9];
                row[0] = rs.getString("matPat");
                row[1] = rs.getString("nom");
                row[2] = rs.getString("prenom");
                row[3] = rs.getString("email");
                row[4] = rs.getString("gender");
                row[5] = rs.getString("maladies");
                row[6] = rs.getString("adresse");
                row[7] = rs.getString("numtel");
                row[8] = rs.getDate("birthdate");
                model.addRow(row);
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
