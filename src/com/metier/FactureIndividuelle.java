package com.metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="FactureIndividuelle")
@DiscriminatorValue(value="2")

	
public class FactureIndividuelle extends Facture {
	@Column (name="idHabitation")
	private String idHabitation;
	
	public FactureIndividuelle() {
		// TODO Auto-generated constructor stub
	}

	public FactureIndividuelle(String nom, int a, int m, String idH) {
		super(nom, a, m);
		// TODO Auto-generated constructor stub
		idHabitation =idH;
	}

	public FactureIndividuelle(int id, String nom, int a, int m, String idH) {
		super(id, nom, a, m);
		// TODO Auto-generated constructor stub
		idHabitation = idH;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

}
