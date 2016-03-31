package com.vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.metier.Usager;
import com.persistance.AccesData;

public class JpanelHabtiationUsager extends JPanel {
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JLabel lblSelectionUsager;
	private JTable table;
	private ModeleData unModel;
	/**
	 * Create the panel.
	 */
	public JpanelHabtiationUsager() {
		setLayout(null);
		add(getScrollPane());
		add(getComboBox());
		add(getLblSelectionUsager());

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 98, 430, 191);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(225, 35, 165, 20);
			
			List<Usager> us = AccesData.getLesUsagers();
			for(Usager user : us){
				comboBox.addItem(user.getIdUsager()+" - "+user.getNom()+" "+user.getPrenom());
			}
			comboBox.setSelectedIndex(0);
			comboBox.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) { 
					unModel = new ModeleData(us.get(comboBox.getSelectedIndex()).getIdUsager());
					table.setModel(unModel);
					table.revalidate();
				}
			});
		}
		return comboBox;
	}
	
	private JLabel getLblSelectionUsager() {
		if (lblSelectionUsager == null) {
			lblSelectionUsager = new JLabel("Selection usager");
			lblSelectionUsager.setBounds(37, 38, 110, 14);
		}
		return lblSelectionUsager;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
