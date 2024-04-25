package docteurInterface;

import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DocteurInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocteurInterface window = new DocteurInterface();
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
	public DocteurInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setSize(800,500);
		frame.setBounds(100, 100, 802, 499);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton rempDos = new JButton("Remplir Dossier");
		rempDos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemplirDossier fra_me = new RemplirDossier();
		        fra_me.frame.setVisible(true);
			}
		});
		rempDos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rempDos.setBounds(50, 35, 292, 77);
		frame.getContentPane().add(rempDos);
		
		JButton chercheDos = new JButton("Chercher Dossier");
		chercheDos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		chercheDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechercheDossier fra_me = new RechercheDossier();
		        fra_me.frame.setVisible(true);
			}
		});
		chercheDos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chercheDos.setBounds(50, 143, 292, 77);
		frame.getContentPane().add(chercheDos);
		
		JButton suppDos = new JButton("Supprimer Dossier");
		suppDos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupprimerDossier fra_me = new SupprimerDossier();
		        fra_me.frame.setVisible(true);
			}
		});
		suppDos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		suppDos.setBounds(50, 249, 292, 77);
		frame.getContentPane().add(suppDos);
		
		JButton affichRen = new JButton("Afficher Rendez-vous");
		affichRen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AfficheRendezvous afficheRen = new AfficheRendezvous();
		        afficheRen.frame.setVisible(true);
			}
		});
		affichRen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		affichRen.setBounds(50, 358, 292, 77);
		frame.getContentPane().add(affichRen);
		
		JButton rechMatPat = new JButton("Recherche Mat Patient");
		rechMatPat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RechercheMatPatient fra_me = new RechercheMatPatient();
		        fra_me.frame.setVisible(true);
			}
		});
		rechMatPat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rechMatPat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rechMatPat.setBounds(462, 143, 292, 77);
		frame.getContentPane().add(rechMatPat);
		
		JButton cherchRen = new JButton("Chercher Rendez-vous");
		cherchRen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChercherRendezvous frame = new ChercherRendezvous();
		        frame.frame.setVisible(true);
			}
		});
		cherchRen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cherchRen.setBounds(462, 35, 292, 77);
		frame.getContentPane().add(cherchRen);
		
		JButton deco = new JButton("Déconnexion");
		deco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		deco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deco.setBounds(462, 358, 292, 77);
		frame.getContentPane().add(deco);
		
		JButton ajtCons = new JButton("Ajouter Consultation");
		ajtCons.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AjouterConsultation fra_me = new AjouterConsultation();
		        fra_me.frame.setVisible(true);
			}
		});
		ajtCons.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ajtCons.setBounds(462, 249, 292, 77);
		frame.getContentPane().add(ajtCons);
	}
}
