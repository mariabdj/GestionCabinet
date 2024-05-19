package Secraitaire;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SupprimPatient {

    JFrame frame;
    private JTextField matPat;
    private Connection connection;
    private Statement statement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SupprimPatient window = new SupprimPatient();
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
    public SupprimPatient() {
        initialize();
        connectDatabase();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblDonnerMatriculePatient = new JLabel("Donner Matricule Patient");
        lblDonnerMatriculePatient.setHorizontalAlignment(SwingConstants.CENTER);
        lblDonnerMatriculePatient.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblDonnerMatriculePatient.setBounds(-7, 53, 786, 37);
        frame.getContentPane().add(lblDonnerMatriculePatient);

        matPat = new JTextField();
        matPat.setFont(new Font("Tahoma", Font.PLAIN, 30));
        matPat.setColumns(10);
        matPat.setBounds(219, 153, 346, 82);
        frame.getContentPane().add(matPat);

        JButton btnConf = new JButton("Confirmer");
        btnConf.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnConf.setBounds(284, 298, 207, 58);
        btnConf.addActionListener(e -> deletePatient());
        frame.getContentPane().add(btnConf);
    }

    private void connectDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SECRAITAIRE", "DADI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deletePatient() {
        try {
            String matriculePatient = matPat.getText();
            String sqlDeletePatient = "DELETE FROM Patient WHERE matPat = '" + matriculePatient + "'";
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sqlDeletePatient);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(frame, "Le patient a été supprimé avec succès");
            } else {
                JOptionPane.showMessageDialog(frame, "Aucun patient n'a été supprimé (Matricule introuvable)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erreur lors de la suppression du patient : ");
        }
    }
}
