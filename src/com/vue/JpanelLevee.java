package com.vue;

import javax.swing.JPanel;

import com.util.InsertionLevee;
import com.util.Parametre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JpanelLevee extends JPanel {
	private JLabel lblNewLabel;
	private JButton btnButtonInsertLevee;

	/**
	 * Create the panel.
	 */
	public JpanelLevee() {
		setLayout(null);
		add(getLblNewLabel());
		add(getBtnButtonInsertLevee());

	}
	private JLabel getLblNewLabel() {
		int nbLevee = Parametre.nbLevee();
		if (lblNewLabel == null) {
			String textLabel = "il y a "+nbLevee+" fichier a traitet";
			lblNewLabel = new JLabel(textLabel);
			lblNewLabel.setBounds(94, 71, 148, 14);
		}
		return lblNewLabel;
	}
	private JButton getBtnButtonInsertLevee() {
		
		if (btnButtonInsertLevee == null) {
			btnButtonInsertLevee = new JButton("Insertion levee");
			btnButtonInsertLevee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InsertionLevee.traitementLevee();
					afficheMessage("Mise à jour effectuée");
				}
			});
			if(Parametre.nbLevee() == 0){
				btnButtonInsertLevee.setEnabled(false);
			}else{
				btnButtonInsertLevee.setBounds(132, 114, 148, 23);
			}
				
			
		}
		return btnButtonInsertLevee;
	}
	private void afficheMessage(String message){
		JOptionPane.showMessageDialog(null,message);
	}
}
