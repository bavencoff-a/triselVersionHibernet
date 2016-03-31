package com.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="foyer")
@Inheritance (strategy=InheritanceType.JOINED)

public class Foyer {
	@Id
	@GeneratedValue
	@Column (name="idFoyer")
	private String idFoyer;
	
	@Column (name="nbPersonnes")
	private int nbPersonnes;
	
	@ManyToOne
	@JoinColumn (name="idHabitation")
	private HabitationCollective HabCol;
	
	@ManyToOne
	@JoinColumn(name="idUsager")
	private Usager usager;
	
	@OneToMany
	@JoinColumn (name="idFoyer")
	private List<FactureFoyer> lesFacturesFoyer;
	
		public Foyer(String idFoyer, int nbPersonnes, HabitationCollective habCol, Usager usager) {
		super();
		this.idFoyer = idFoyer;
		this.nbPersonnes = nbPersonnes;
		HabCol = habCol;
		this.usager = usager;
		lesFacturesFoyer = new ArrayList<FactureFoyer>();
	}
		
	public Foyer() {
		// TODO Auto-generated constructor stub
	}

	public int getNbPersonnes() {
		return nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public HabitationCollective getHabCol() {
		return HabCol;
	}

	public void setHabCol(HabitationCollective habCol) {
		HabCol = habCol;
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public String getIdFoyer() {
		return idFoyer;
	}

	public List<FactureFoyer> getLesFacturesFoyer() {
		return lesFacturesFoyer;
	}

	public void setLesFacturesFoyer(List<FactureFoyer> lesFacturesFoyer) {
		this.lesFacturesFoyer = lesFacturesFoyer;
	}
	
	public void addFactureFoyer(FactureFoyer laFacturesFoyer) {
		this.lesFacturesFoyer.add(laFacturesFoyer);
	}

}
