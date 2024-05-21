package patientInterface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ModifInfo {

    public JFrame frame;
    JPanel backgroundPanel;
    private JTextField txtNom;
    private JLabel lblMaladies;
    private JTextField txtMaldie;
    private JLabel lblPrnom;
    private JTextField txtPrenom;
    private JLabel lblNewLabel_3;
    private JTextField txtTel;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblNewLabel_5;
    private JTextField txtDateNai;
    private JLabel lblGenre;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JLabel lblNewLabel_7;
    private JTextField txtAdresse;
    private JButton btnModifier;
    private Connection connection;
    private Statement statement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String mat = "64";
                    ModifInfo window = new ModifInfo(mat);
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
    public ModifInfo(String mat) {
        initialize(mat);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(String mat) {

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Configure the connection to the Oracle database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "GestionCabinet", "medecin");

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
        backgroundPanel.setBounds(0, 0, 800, 500); // Set bounds to cover the entire frame
        backgroundPanel.setLayout(null); // Using null layout for positioning components freely

        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setBounds(100, 100, 800, 508);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        txtNom = new JTextField();
        txtNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtNom.setBounds(188, 42, 200, 48);
        frame.getContentPane().add(txtNom);
        txtNom.setColumns(10);

        lblMaladies = new JLabel("Maladies :");
        lblMaladies.setHorizontalAlignment(SwingConstants.CENTER);
        lblMaladies.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblMaladies.setBounds(398, 30, 139, 63);
        frame.getContentPane().add(lblMaladies);

        txtMaldie = new JTextField();
        txtMaldie.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtMaldie.setColumns(10);
        txtMaldie.setBounds(576, 42, 200, 48);
        frame.getContentPane().add(txtMaldie);

        txtPrenom = new JTextField();
        txtPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtPrenom.setColumns(10);
        txtPrenom.setBounds(188, 136, 200, 48);
        frame.getContentPane().add(txtPrenom);

        lblNewLabel_3 = new JLabel("Tel :");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_3.setBounds(398, 124, 139, 63);
        frame.getContentPane().add(lblNewLabel_3);

        txtTel = new JTextField();
        txtTel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtTel.setColumns(10);
        txtTel.setBounds(576, 136, 200, 48);
        frame.getContentPane().add(txtTel);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtEmail.setColumns(10);
        txtEmail.setBounds(188, 224, 200, 48);
        frame.getContentPane().add(txtEmail);

        lblNewLabel_5 = new JLabel("Date naissance :");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_5.setBounds(398, 212, 168, 63);
        frame.getContentPane().add(lblNewLabel_5);

        txtDateNai = new JTextField();
        txtDateNai.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDateNai.setColumns(10);
        txtDateNai.setBounds(576, 224, 200, 48);
        frame.getContentPane().add(txtDateNai);

        genderGroup = new ButtonGroup();

        lblNewLabel_7 = new JLabel("Adresse :");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_7.setBounds(398, 296, 139, 63);
        frame.getContentPane().add(lblNewLabel_7);

        txtAdresse = new JTextField();
        txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtAdresse.setColumns(10);
        txtAdresse.setBounds(576, 308, 200, 48);
        frame.getContentPane().add(txtAdresse);

        btnModifier = new JButton("Modifier");
        btnModifier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Create a new instance of the statement
                    statement = connection.createStatement();

                    // Retrieve values from the input fields
                    String nouveau_nom = txtNom.getText();
                    String nouveau_prenom = txtPrenom.getText();
                    String nouvel_email = txtEmail.getText();
                    String nouveau_genre = maleRadioButton.isSelected() ? "M" : "F";
                    String nouvelles_maladies = txtMaldie.getText();
                    String nouvelle_adresse = txtAdresse.getText();
                    String nouveau_numtel = txtTel.getText();
                    String nouvelle_date_de_naissance = txtDateNai.getText();
                    String matricule_patient = mat;

                    String sql = "UPDATE Patient SET "
                            + "nom = '" + nouveau_nom + "', "
                            + "prenom = '" + nouveau_prenom + "', "
                            + "email = '" + nouvel_email + "', "
                            + "gender = '" + nouveau_genre + "', "
                            + "maladies = '" + nouvelles_maladies + "', "
                            + "adresse = '" + nouvelle_adresse + "', "
                            + "numtel = '" + nouveau_numtel + "', "
                            + "birthdate = '" + nouvelle_date_de_naissance + "' "
                            + "WHERE matPat = '" + matricule_patient + "'";

                    // Execute the query
                    statement.execute(sql);

                    // Clear all input fields
                    txtNom.setText("");
                    txtPrenom.setText("");
                    txtEmail.setText("");
                    genderGroup.clearSelection();
                    txtAdresse.setText("");
                    txtMaldie.setText("");
                    txtTel.setText("");
                    txtDateNai.setText("");

                    // Inform the user that the update was successful
                    JOptionPane.showMessageDialog(btnModifier, "Vous avez bien mis à jour");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(btnModifier, "Erreur");
                }
            }
        });
        btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnModifier.setBounds(275, 388, 249, 57);
        frame.getContentPane().add(btnModifier);
        frame.getContentPane().add(backgroundPanel);
        
                JLabel lblNewLabel = new JLabel("Nom :");
                lblNewLabel.setBounds(61, 31, 139, 63);
                backgroundPanel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                
                        lblPrnom = new JLabel("Prénom :");
                        lblPrnom.setBounds(61, 122, 139, 63);
                        backgroundPanel.add(lblPrnom);
                        lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
                        lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 22));
                        
                                lblEmail = new JLabel("E-mail :");
                                lblEmail.setBounds(61, 212, 139, 63);
                                backgroundPanel.add(lblEmail);
                                lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
                                lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
                                
                                        lblGenre = new JLabel("Genre :");
                                        lblGenre.setBounds(103, 294, 139, 63);
                                        backgroundPanel.add(lblGenre);
                                        lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
                                        lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 22));
                                        
                                                maleRadioButton = new JRadioButton("M");
                                                maleRadioButton.setBounds(248, 311, 50, 30);
                                                backgroundPanel.add(maleRadioButton);
                                                maleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                genderGroup.add(maleRadioButton);
                                                
                                                        femaleRadioButton = new JRadioButton("F");
                                                        femaleRadioButton.setBounds(300, 311, 50, 30);
                                                        backgroundPanel.add(femaleRadioButton);
                                                        femaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                        genderGroup.add(femaleRadioButton);
    }
}
