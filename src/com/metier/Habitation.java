package com.metier;
import javax.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table (name="habitation")
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeH", discriminatorType=DiscriminatorType.INTEGER)
public abstract class Habitation implements Serializable{
	@Id
	@Column (name="idHabitation")
	private String idHabitation;
	
	@Column (name="adresseRue")
	private String adresseRue;
	
	@Column (name="codePostal")
	private String codePostal;
	
	@Column (name="adresseVille")
	private String adresseVille;
	
	///@ManyToOne
	//@JoinColumn(name="idUsager")
	//private Usager Usager;              modifier a mettre dans les classes fille
	
	@OneToMany(mappedBy="idHabitation")
	private List<Poubelle> lesPoubelle;
	
	//@OneToMany(mappedBy="idHabitation")     modifier a mettre dans les classes fille
	//private List<Facture> lesFactures;
	
	
	/**
	 *Constructeur de la classe habitation 
	 * @param idHabitation
	 * @param adresseRue
	 * @param codePostal
	 * @param adresseVille
	 * @param usager
	 */
	public Habitation(String idHabitation, String adresseRue, String codePostal, String adresseVille) {
		super();
		this.idHabitation = idHabitation;
		this.adresseRue = adresseRue;
		this.codePostal = codePostal;
		this.adresseVille = adresseVille;
		
		
	}
	
	/**
	 *Constructeur de la classe habitation 
	
	 */
	public Habitation() {
		super();
						
	}
	
	
	
	
	/**
	 * getAdresseRue
	 * @return retourne l'adresseRue de type string
	 */
	public String getAdresseRue() {
		return adresseRue;
	}
	/**
	 * getCodePostal
	 * @return retourne le CodePostal de type string
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * getAdresseVille
	 * @return retourne l'Adresse Ville de type string
	 */
	public String getAdresseVille() {
		return adresseVille;
	}
	
	/**
	 * ajoutPoubelle
	 * @param unePoubelle est un objet poubelle qui seras ajoutee a l'arrayList de poubelle d'habitation
	 */
	public void ajoutPoubelle(Poubelle unePoubelle)
	{
		lesPoubelle.add(unePoubelle);
	}
	
	/**
	 * getLesPoubelle
	 * @return ArrayList<Poubelle> La liste des poubelles de l'habitation
	 */
	public List<Poubelle> getLesPoubelle() {
		return lesPoubelle;
	}
	/**
	 * getIdHabitation
	 * @return String retourne l'id de l'habitation
	 */
	public String getIdHabitation() {
		return idHabitation;
	}
	/**
	 *  getCout
	 *  parcoure les poubelles de la liste poubelle et fais appel a la methode getcout de poubelle
	 *  @see Poubelle
	 * @param an 
	 * @param mois
	 * @return double : revois le cout total des levee effectuee pendant le mois et l'annee pris en parametre
	 */
	public double getCout(int an,int mois)
	{
		//variable
		double lecout = 0.00;
		//debut
		for(Poubelle poubelle : lesPoubelle){
			lecout = lecout + poubelle.getCout(an, mois);
		}

		return lecout;
	}
	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adresseRue=" + adresseRue + ", codePostal=" + codePostal
				+ ", adresseVille=" + adresseVille + "]";
	}
	
	
}
