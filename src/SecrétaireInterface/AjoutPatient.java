package SecrétaireInterface;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AjoutPatient {

    JFrame frame;
    private JTextField nom;
    private JTextField prenom;
    private JTextField birthdate;
    private JTextField maladies;
    private JTextField Adresse;
    private JTextField numtel;
    private JTextField email;
    private Connection connection;
    private PreparedStatement preparedStatement;
    JPanel backgroundPanel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AjoutPatient window = new AjoutPatient();
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
    public AjoutPatient() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Configure the connection to the Oracle database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","GestionCabinet", "medecin");
            connection.setAutoCommit(false);  // Disable auto-commit mode

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
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Ajouter un nouveau patient");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblNewLabel_1.setBounds(157, 0, 349, 38);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Nom :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(100, 55, 100, 20);
        frame.getContentPane().add(lblNewLabel);

        nom = new JTextField();
        nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nom.setBounds(376, 50, 300, 30);
        frame.getContentPane().add(nom);
        nom.setColumns(10);

        JLabel lblPrenom = new JLabel("Prenom :");
        lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrenom.setBounds(100, 95, 100, 20);
        frame.getContentPane().add(lblPrenom);

        prenom = new JTextField();
        prenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        prenom.setColumns(10);
        prenom.setBounds(376, 90, 300, 30);
        frame.getContentPane().add(prenom);

        JLabel lblDateDeNaissance_1 = new JLabel("Date de naissance:");
        lblDateDeNaissance_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDateDeNaissance_1.setBounds(100, 135, 189, 20);
        frame.getContentPane().add(lblDateDeNaissance_1);

        birthdate = new JTextField();
        birthdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        birthdate.setColumns(10);
        birthdate.setBounds(376, 130, 300, 30);
        frame.getContentPane().add(birthdate);

        JLabel lblmaladies_1_2_2 = new JLabel("Historique médicale:");
        lblmaladies_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblmaladies_1_2_2.setBounds(100, 175, 193, 20);
        frame.getContentPane().add(lblmaladies_1_2_2);

        maladies = new JTextField();
        maladies.setFont(new Font("Tahoma", Font.PLAIN, 20));
        maladies.setColumns(10);
        maladies.setBounds(376, 170, 300, 30);
        frame.getContentPane().add(maladies);

        JLabel lblemail_1_2_1 = new JLabel("Email:");
        lblemail_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblemail_1_2_1.setBounds(100, 215, 193, 20);
        frame.getContentPane().add(lblemail_1_2_1);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setColumns(10);
        email.setBounds(376, 210, 300, 30);
        frame.getContentPane().add(email);

        JLabel lbladresse_1_1 = new JLabel("Adresse :");
        lbladresse_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbladresse_1_1.setBounds(100, 255, 100, 20);
        frame.getContentPane().add(lbladresse_1_1);

        Adresse = new JTextField();
        Adresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Adresse.setColumns(10);
        Adresse.setBounds(376, 250, 300, 30);
        frame.getContentPane().add(Adresse);

        JLabel lblnumtlf_1_2 = new JLabel("Télephone :");
        lblnumtlf_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblnumtlf_1_2.setBounds(100, 295, 151, 20);
        frame.getContentPane().add(lblnumtlf_1_2);

        numtel = new JTextField();
        numtel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        numtel.setColumns(10);
        numtel.setBounds(376, 290, 300, 30);
        frame.getContentPane().add(numtel);

        maleRadioButton = new JRadioButton("M");
        maleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        maleRadioButton.setBounds(376, 330, 50, 30);
        frame.getContentPane().add(maleRadioButton);

        femaleRadioButton = new JRadioButton("F");
        femaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        femaleRadioButton.setBounds(430, 330, 50, 30);
        frame.getContentPane().add(femaleRadioButton);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JButton CONFIRME = new JButton("Confirmer");
        CONFIRME.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String Nom = nom.getText();
                    String Prenom = prenom.getText();
                    String Datenaissance = birthdate.getText();
                    String adresse = Adresse.getText();
                    String Tel = numtel.getText();
                    String Adresse_mail = email.getText();
                    String Genre = maleRadioButton.isSelected() ? "M" : "F";
                    String hestorique_maladies = maladies.getText();

                    // Construction de la requête SQL avec PreparedStatement
                    String sql = "INSERT INTO PATIENT (nom, prenom, email, gender, maladies, adresse, numtel, birthdate) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'DD-MM-YYYY'))";

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, Nom);
                    preparedStatement.setString(2, Prenom);
                    preparedStatement.setString(3, Adresse_mail);
                    preparedStatement.setString(4, Genre);
                    preparedStatement.setString(5, hestorique_maladies);
                    preparedStatement.setString(6, adresse);
                    preparedStatement.setString(7, Tel);
                    preparedStatement.setString(8, Datenaissance);

                    preparedStatement.executeUpdate();
                    connection.commit();  // Valider la transaction

                    JOptionPane.showMessageDialog(CONFIRME, "Patient ajouté !");
                } catch (SQLException e1) {
                    try {
                        connection.rollback();  // Annuler la transaction en cas d'erreur
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(CONFIRME, "Erreur lors de l'ajout du patient !");
                }
            }
        });

        CONFIRME.setFont(new Font("Tahoma", Font.PLAIN, 21));
        CONFIRME.setBounds(254, 393, 211, 38);
        frame.getContentPane().add(CONFIRME);
        frame.getContentPane().add(backgroundPanel);
        
                JLabel lblSexe = new JLabel("Genre :");
                lblSexe.setBounds(140, 335, 100, 20);
                backgroundPanel.add(lblSexe);
                lblSexe.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }
}
