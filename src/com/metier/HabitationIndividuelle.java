package com.metier;

import java.util.*;

import javax.persistence.*;


@Entity
@Table (name="habitationindividuelle")
@DiscriminatorValue(value="1")

public class HabitationIndividuelle extends Habitation {

	@ManyToOne
	@JoinColumn(name="idUsager")
	private Usager usager;
	
	@OneToMany(mappedBy="idHabitation")
	private List<FactureIndividuelle> lesFacturesInd;
	
	public HabitationIndividuelle(String idHabitation, String adresseRue, String codePostal, String adresseVille, Usager us) {
		super(idHabitation, adresseRue, codePostal, adresseVille);
		// TODO Auto-generated constructor stub
		usager = us;
	}

	public HabitationIndividuelle() {
		// TODO Auto-generated constructor stub
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public List<FactureIndividuelle> getLesFacturesInd() {
		return lesFacturesInd;
	}

	public void setLesFacturesInd(List<FactureIndividuelle> lesFacturesInd) {
		this.lesFacturesInd = lesFacturesInd;
	}
	
	public void addUneFacturesInd(FactureIndividuelle FacturesInd) {
		this.lesFacturesInd.add(FacturesInd);
	}

	@Override
	public String toString() {
		return "HabitationIndividuelle [usager=" + usager + ", lesFacturesInd=" + lesFacturesInd + ", toString()="
				+ super.toString() + "]";
	}

}
