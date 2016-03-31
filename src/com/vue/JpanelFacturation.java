package com.vue;

import javax.swing.JPanel;

import com.metier.Habitation;
import com.persistance.AccesData;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.util.InsertionLevee;
import com.util.Parametre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;

public class JpanelFacturation extends JPanel implements PropertyChangeListener{
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JButton btnLancerEditionFacture;
	private int an;
	private int mois;

	/**
	 * Create the panel.
	 */
	public JpanelFacturation() {
		
		setLayout(null);
		add(getMonthChooser());
		add(getYearChooser());
		add(getBtnLancerEditionFacture());
		

	}
	private JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.addPropertyChangeListener(this);
			monthChooser.setBounds(74, 106, 97, 20);
		}
		return monthChooser;
	}
	private JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.setBounds(191, 106, 47, 20);
			yearChooser.addPropertyChangeListener(this);
		}
		return yearChooser;
	}
	private JButton getBtnLancerEditionFacture() {
		if (btnLancerEditionFacture == null) {
			btnLancerEditionFacture = new JButton("Lancer \u00E9dition");
			btnLancerEditionFacture.setBounds(74, 137, 89, 23);
			btnLancerEditionFacture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					List<Habitation> habs;
					try{
						habs = AccesData.getLesHabitations();
						for(Habitation habitation : habs){
							Parametre.editionElementFacture(habitation, mois, an);
						}
					}catch(Exception ex){
						System.out.println("une erreur est survenu");
					}
					
				}
			});
		}
		return btnLancerEditionFacture;
	}
	public void propertyChange(PropertyChangeEvent evt) { 

		if(evt.getPropertyName().equals("year")){

		an = (Integer)evt.getNewValue();

		}

		if(evt.getPropertyName().equals("month")){

		mois  = (Integer)evt.getNewValue() + 1; 

		}
	}
}
