package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;

public class testJfram extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenu mnLevee;
	private JMenuItem mntmQuitter;
	private JMenu mnFacture;
	private JMenuItem mntmInsertionDesLevees;
	private JMenuItem mntmGenerationFacture;
	private JMenu mnConsultation;
	private JMenuItem mntmHabitations;
	private JMenu mnDonneDeBase;
	private JMenu mnTypeDchet;
	private JMenu mnHabitation;
	private JMenuItem mntmAjout;
	private JMenuItem mntmChangementDeTarif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testJfram frame = new testJfram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testJfram() {
		setTitle("Trisel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(new JPanelLogine());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFichier());
			menuBar.add(getMnLevee());
			menuBar.add(getMnFacture());
			menuBar.add(getMnDonneDeBase());
			menuBar.add(getMnConsultation());
		}
		return menuBar;
	}
	private JMenu getMnFichier() {
		if (mnFichier == null) {
			mnFichier = new JMenu("Fichier");
			mnFichier.add(getMntmQuitter());
		}
		return mnFichier;
	}
	private JMenu getMnLevee() {
		if (mnLevee == null) {
			mnLevee = new JMenu("Levee");
			mnLevee.setEnabled(false);
			mnLevee.add(getMntmInsertionDesLevees());
		}
		return mnLevee;
	}
	private JMenuItem getMntmQuitter() {
		if (mntmQuitter == null) {
			mntmQuitter = new JMenuItem("Quitter");
			mntmQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmQuitter;
	}
	private JMenu getMnFacture() {
		if (mnFacture == null) {
			mnFacture = new JMenu("Facture");
			mnFacture.setEnabled(false);
			mnFacture.add(getMntmGenerationFacture());
		}
		return mnFacture;
	}
	private JMenuItem getMntmInsertionDesLevees() {
		if (mntmInsertionDesLevees == null) {
			mntmInsertionDesLevees = new JMenuItem("Insertion des Levees");
			
			mntmInsertionDesLevees.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertionLevee();
				}
			});
		}
		return mntmInsertionDesLevees;
	}
	private JMenuItem getMntmGenerationFacture() {
		if (mntmGenerationFacture == null) {
			mntmGenerationFacture = new JMenuItem("Generation facture");
			mntmGenerationFacture.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					facturation();
				}
			});
			
		}
		return mntmGenerationFacture;
	}
	private void facturation(){
		this.setContentPane(new JpanelFacturation()); 
		this.revalidate();
	}
	private void fondEcran(String user){
		this.setContentPane(new PanelFondEcran(user)); 
		this.revalidate();
	}
	private void insertionLevee() { 

		// on affecte le panel de la fenêtre 

		// avec une instance de PanelLevee 

		this.setContentPane(new JpanelLevee()); 

		// mets à jour le formulaire 

		this.revalidate();

		}
	public class JPanelLogine extends JPanel {
		private JButton btnLogin;
		private JTextField textUser;
		private JTextField textWP;
		private JLabel lblIdentifiant;
		private JLabel lblMotDePasse;

		/**
		 * Create the panel.
		 */
		public JPanelLogine() {
			setLayout(null);
			add(getBtnLogin());
			add(getTextUser());
			add(getTextWP());
			add(getLblIdentifiant());
			add(getLblMotDePasse());

		}
		private JButton getBtnLogin() {
			if (btnLogin == null) {
				btnLogin = new JButton("Login");
				btnLogin.setBounds(166, 176, 89, 23);
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try{
							Utilisateur uti = Recherchelogin();
							int lvl;
							if(uti != null){
								lvl = uti.getNiveau();
								
								switch(lvl){
								case 1:
									getMnFacture().setEnabled(true);
									getMnLevee().setEnabled(true);
									getMnConsultation().setEnabled(true);
								break;
							
								case 2:
									getMnFacture().setEnabled(true);
								break;
								case 3:
									getMnLevee().setEnabled(true);
								break;
									
								}
								fondEcran(uti.getNomUtilisateur());
							}
							else{
								afficheMessage("les identifiant que vous avez entrer ne sont pas correct");
								getTextUser().setText("");
								getTextWP().setText("");
							}
							
						}catch(Exception ex){
							System.out.println("une erreur est survenu");
						}
						
					}
				});
			}
			
			return btnLogin;
		}
		private JTextField getTextUser() {
			if (textUser == null) {
				textUser = new JTextField();
				textUser.setBounds(223, 108, 86, 20);
				textUser.setColumns(10);
			}
			return textUser;
		}
		private JTextField getTextWP() {
			if (textWP == null) {
				textWP = new JTextField();
				textWP.setBounds(223, 139, 86, 20);
				textWP.setColumns(10);
			}
			return textWP;
		}
		private JLabel getLblIdentifiant() {
			if (lblIdentifiant == null) {
				lblIdentifiant = new JLabel("Identifiant :");
				lblIdentifiant.setBounds(136, 111, 57, 14);
			}
			return lblIdentifiant;
		}
		private JLabel getLblMotDePasse() {
			if (lblMotDePasse == null) {
				lblMotDePasse = new JLabel("Mot de passe :");
				lblMotDePasse.setBounds(136, 142, 77, 14);
			}
			return lblMotDePasse;
		}
		public Utilisateur Recherchelogin(){
			Utilisateur trouve = AccesData.getUtilisateurslogMdp(getTextUser().getText(),getTextWP().getText());
			return trouve;
		}
		
		private void afficheMessage(String message){
			JOptionPane.showMessageDialog(null,message);
		}
	}
	private JMenu getMnConsultation() {
		if (mnConsultation == null) {
			mnConsultation = new JMenu("Consultation");
			mnConsultation.add(getMntmHabitations());
			mnConsultation.setEnabled(false);
		}
		return mnConsultation;
	}
	private JMenuItem getMntmHabitations() {
		if (mntmHabitations == null) {
			mntmHabitations = new JMenuItem("Habitations");
			mntmHabitations.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Consultation();
				}
			});
		}
		return mntmHabitations;
	}
	private void Consultation(){
		this.setContentPane(new JpanelHabtiationUsager()); 
		this.revalidate();
	}
	private JMenu getMnDonneDeBase() {
		if (mnDonneDeBase == null) {
			mnDonneDeBase = new JMenu("Donne de Base");
			mnDonneDeBase.add(getMnTypeDchet());
			mnDonneDeBase.add(getMnHabitation());
		}
		return mnDonneDeBase;
	}
	private JMenu getMnTypeDchet() {
		if (mnTypeDchet == null) {
			mnTypeDchet = new JMenu("Type d\u00E9chet");
			mnTypeDchet.add(getMntmAjout());
			mnTypeDchet.add(getMntmChangementDeTarif());
		}
		return mnTypeDchet;
	}
	private JMenu getMnHabitation() {
		if (mnHabitation == null) {
			mnHabitation = new JMenu("Habitation");
		}
		return mnHabitation;
	}
	private JMenuItem getMntmAjout() {
		if (mntmAjout == null) {
			mntmAjout = new JMenuItem("Ajout");
		}
		return mntmAjout;
	}
	private JMenuItem getMntmChangementDeTarif() {
		if (mntmChangementDeTarif == null) {
			mntmChangementDeTarif = new JMenuItem("Changement de tarif");
		}
		return mntmChangementDeTarif;
	}
}
