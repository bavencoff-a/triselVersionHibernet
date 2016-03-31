package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name="habitationcollective")
@DiscriminatorValue(value="2")
public class HabitationCollective extends Habitation {
	
	@OneToMany
	@JoinColumn (name="idHabitation")
	private List<Foyer> lesFoyer;

	public HabitationCollective(String idHabitation, String adresseRue, String codePostal, String adresseVille) {
		super(idHabitation, adresseRue, codePostal, adresseVille);
		// TODO Auto-generated constructor stub
		lesFoyer = new ArrayList<Foyer>();
	}

	public HabitationCollective() {
		// TODO Auto-generated constructor stub
	}

	public List<Foyer> getLesFoyer() {
		return lesFoyer;
	}

	public void setLesFoyer(List<Foyer> lesFoyer) {
		this.lesFoyer = lesFoyer;
	}
	public void addLesFoyer(Foyer leFoyer) {
		this.lesFoyer.add(leFoyer);
	}

}
