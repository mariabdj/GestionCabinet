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

        genderGroup = new ButtonGroup();
        frame.getContentPane().add(backgroundPanel);
        
                JLabel lblNewLabel = new JLabel("Nom :");
                lblNewLabel.setBounds(100, 55, 100, 20);
                backgroundPanel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
                
                        lblPrnom = new JLabel("Prénom :");
                        lblPrnom.setBounds(100, 95, 100, 20);
                        backgroundPanel.add(lblPrnom);
                        lblPrnom.setHorizontalAlignment(SwingConstants.LEFT);
                        lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        
                                lblEmail = new JLabel("E-mail :");
                                lblEmail.setBounds(100, 215, 100, 20);
                                backgroundPanel.add(lblEmail);
                                lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
                                lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                
                                        lblGenre = new JLabel("Genre :");
                                        lblGenre.setBounds(187, 336, 100, 20);
                                        backgroundPanel.add(lblGenre);
                                        lblGenre.setHorizontalAlignment(SwingConstants.LEFT);
                                        lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                        
                                                maleRadioButton = new JRadioButton("M");
                                                maleRadioButton.setBounds(386, 331, 50, 30);
                                                backgroundPanel.add(maleRadioButton);
                                                maleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                genderGroup.add(maleRadioButton);
                                                
                                                        femaleRadioButton = new JRadioButton("F");
                                                        femaleRadioButton.setBounds(455, 331, 50, 30);
                                                        backgroundPanel.add(femaleRadioButton);
                                                        femaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                        genderGroup.add(femaleRadioButton);
                                                        
                                                                lblNewLabel_5 = new JLabel("Date naissance :");
                                                                lblNewLabel_5.setBounds(100, 135, 154, 20);
                                                                backgroundPanel.add(lblNewLabel_5);
                                                                lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
                                                                lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                
                                                                        txtNom = new JTextField();
                                                                        txtNom.setBounds(376, 50, 300, 30);
                                                                        backgroundPanel.add(txtNom);
                                                                        txtNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                        txtNom.setColumns(10);
                                                                        
                                                                                txtPrenom = new JTextField();
                                                                                txtPrenom.setBounds(376, 90, 300, 30);
                                                                                backgroundPanel.add(txtPrenom);
                                                                                txtPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                txtPrenom.setColumns(10);
                                                                                
                                                                                        txtDateNai = new JTextField();
                                                                                        txtDateNai.setBounds(376, 130, 300, 30);
                                                                                        backgroundPanel.add(txtDateNai);
                                                                                        txtDateNai.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                        txtDateNai.setColumns(10);
                                                                                        
                                                                                                lblMaladies = new JLabel("Maladies :");
                                                                                                lblMaladies.setBounds(100, 175, 100, 20);
                                                                                                backgroundPanel.add(lblMaladies);
                                                                                                lblMaladies.setHorizontalAlignment(SwingConstants.LEFT);
                                                                                                lblMaladies.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                
                                                                                                        txtMaldie = new JTextField();
                                                                                                        txtMaldie.setBounds(376, 170, 300, 30);
                                                                                                        backgroundPanel.add(txtMaldie);
                                                                                                        txtMaldie.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                        txtMaldie.setColumns(10);
                                                                                                        
                                                                                                                lblNewLabel_7 = new JLabel("Adresse :");
                                                                                                                lblNewLabel_7.setBounds(100, 255, 100, 20);
                                                                                                                backgroundPanel.add(lblNewLabel_7);
                                                                                                                lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
                                                                                                                lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                
                                                                                                                        txtAdresse = new JTextField();
                                                                                                                        txtAdresse.setBounds(376, 250, 300, 30);
                                                                                                                        backgroundPanel.add(txtAdresse);
                                                                                                                        txtAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                        txtAdresse.setColumns(10);
                                                                                                                        
                                                                                                                                lblNewLabel_3 = new JLabel("Tel :");
                                                                                                                                lblNewLabel_3.setBounds(100, 294, 100, 20);
                                                                                                                                backgroundPanel.add(lblNewLabel_3);
                                                                                                                                lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
                                                                                                                                lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                                
                                                                                                                                        txtTel = new JTextField();
                                                                                                                                        txtTel.setBounds(376, 290, 300, 29);
                                                                                                                                        backgroundPanel.add(txtTel);
                                                                                                                                        txtTel.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                                        txtTel.setColumns(10);
                                                                                                                                        
                                                                                                                                                btnModifier = new JButton("Modifier");
                                                                                                                                                btnModifier.setBounds(274, 400, 231, 51);
                                                                                                                                                backgroundPanel.add(btnModifier);
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
                                                                                                                                                
                                                                                                                                                        txtEmail = new JTextField();
                                                                                                                                                        txtEmail.setBounds(376, 210, 300, 30);
                                                                                                                                                        backgroundPanel.add(txtEmail);
                                                                                                                                                        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                                                        txtEmail.setColumns(10);
    }
}
