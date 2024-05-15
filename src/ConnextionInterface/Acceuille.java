package ConnextionInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import patientInterface.PatientPrincipale;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Acceuille {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuille window = new Acceuille();
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
	public Acceuille() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 801, 504);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bonjour, Voulez Vous :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(214, 32, 385, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Vous Connectez");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn sign = new SignIn();
		        sign.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton.setBounds(57, 219, 284, 81);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCrezUnCompte = new JButton("Créez Un Compte");
		btnCrezUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp sign = new SignUp();
		        sign.frame.setVisible(true);
			}
		});
		btnCrezUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnCrezUnCompte.setBounds(450, 219, 284, 81);
		frame.getContentPane().add(btnCrezUnCompte);
	}

}
