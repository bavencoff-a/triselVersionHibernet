package com.metier;

import javax.persistence.*;

@Entity
@Table (name="FactureFoyer")
@DiscriminatorValue(value="1")

public class FactureFoyer extends Facture {
	
	@Column (name="idFoyer")
	private String idFoyer;
	
	public FactureFoyer() {
		// TODO Auto-generated constructor stub
	}

	public FactureFoyer(String nom, int a, int m, String idFo) {
		super(nom, a, m);
		// TODO Auto-generated constructor stub
		idFoyer = idFo;
	}

	public FactureFoyer(int id, String nom, int a, int m, String idFo) {
		super(id, nom, a, m);
		// TODO Auto-generated constructor stub
		idFoyer = idFo;
	}

	public String getIdFoyer() {
		return idFoyer;
	}

	public void setIdFoyer(String idFoyer) {
		this.idFoyer = idFoyer;
	}

}
