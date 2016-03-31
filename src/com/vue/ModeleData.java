package com.vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.metier.Habitation;
import com.persistance.AccesData;

public class ModeleData extends AbstractTableModel {
	private String[] entete = {"idHabitation","adresse rue","code postal","adresse ville","nombre de poubelle"};
	private List<Habitation> lesHabs;
	public ModeleData(String idusager) {
		// TODO Auto-generated constructor stub
		lesHabs = AccesData.getLesHabitationsByUsager(idusager);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesHabs.size();
	}
	@Override

	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case 0:
			return lesHabs.get(arg0).getIdHabitation();
		case 1:
			return lesHabs.get(arg0).getAdresseRue();
		case 2:
			return lesHabs.get(arg0).getCodePostal();
		case 3:
			return lesHabs.get(arg0).getAdresseVille();
		case 4:
			return lesHabs.get(arg0).getLesPoubelle().size();
		default:
			throw new IllegalArgumentException();
		
		}
	}

}
