package com.metier;
import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity
@Table (name="poubelle")
@Inheritance (strategy=InheritanceType.JOINED)
public class Poubelle {
	@Id
	@Column (name="idPoubelle")
	private String idPoubelle;
	@ManyToOne
	@JoinColumn (name="idTypeDechet")
	private TypeDechet nature;
	
	@OneToMany
	@JoinColumn(name="idPoubelle")
	private List<Levee> lesLevees;
	@Column (name="idHabitation")
	String idHabitation;
	
	/**
	 *  constructeur de Poubelle avec un idhabitation
	 * @param idPoubelle
	 * @param nature
	 * @param idHabit
	 */
	public Poubelle(String idPoubelle, TypeDechet nature,String idHabit) {
		super();
		this.idPoubelle = idPoubelle;
		this.nature = nature;
		this.lesLevees = new ArrayList<Levee>();
		this.idHabitation = idHabit;
	}
	/**
	 * constructeur de Poubelle sans idhabitation
	 * @param idPoubelle
	 * @param nature
	 */
	public Poubelle(String idPoubelle, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.nature = nature;
		this.lesLevees = new ArrayList<Levee>();
		this.idHabitation = "";
		
	}
	/**
	 * constructeur de Poubelle sans idhabitation
	 * @param idPoubelle
	 * @param nature
	 */
	public Poubelle() {
		super();
		this.lesLevees = new ArrayList<Levee>();
		this.idHabitation = "";
		
	}
	
	/**
	 * getNature
	 * @see TypeDechet
	 * @return TypeDechet nature des dechets de la poubelle
	 */
	public TypeDechet getNature() {
		return nature;
	}
	/**
	 * setNature
	 * @param nature (TypeDechet) modifi la nature des dechets de la poubelle
	 */
	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}
	/**
	 * ajoutLevee
	 * @see Levee
	 * @param unelevee (Levee) ajoute une levee dans la liste levee de la poubelle
	 */
	public void ajoutLevee(Levee unelevee)
	{
		lesLevees.add(unelevee);
	}
	/**
	 * setLesLevees
	 * @param lesLevees (ArrayList<Levee>) remplace la liste levee de la poubelle par celle mis en parametre
	 */
	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}
	/**
	 * getLesLevees
	 * @return ArrayList<Levee> lesLevees
	 */
	public List<Levee> getLesLevees() {
		return lesLevees;
	}
	/**
	 * getLesLevees
	 * @see Levee
	 * @param an (int)
	 * @param mois (int)
	 * @return ArrayList<Levee> desLeves retourn une liste de levee corespondant aux dates fournis en parametre
	 */
	public ArrayList<Levee> getLesLevees(int an, int mois){
		ArrayList<Levee> desLeves = new ArrayList<Levee>();
		
		Calendar calend = Calendar.getInstance();
		int year = 0;
		int month = 0;
		
		for(Levee levee : lesLevees){
			
			calend.setTime(levee.getLaDate());
			year = calend.get(Calendar.YEAR);
			// extraction du mois mettre + 1 car d�marre � 0 et non pas 1
			month = calend.get(Calendar.MONTH) + 1;
			if(an == year && mois == month){
				desLeves.add(levee);
			}
		}
		return desLeves;
	}
	/**
	 * getIdPoubelle
	 * @return String idPoubelle
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	/**
	 * getIdHabitation
	 * @return String idHabitation
	 */
	public String getIdHabitation() {
		return idHabitation;
	}
	/**
	 * setIdHabitation
	 * @param idHabitation modifi l'idhabitation de la poubelle
	 */
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	/**
	 * getCout
	 * Utilise la methode getLesLevees() de Poubelle
	 * @param an
	 * @param mois
	 * @return double lecout retourne le cout des levees de la poubelle aux dates mis en parametre
	 */
	public double getCout(int an,int mois)
	{
		//variable
		double lecout,poidsTT;
		
		
		
		//debut
		poidsTT = 0;
		for(Levee levee : this.getLesLevees(an, mois)){
			
				poidsTT = poidsTT + levee.getPoids();
		}
		lecout = poidsTT * nature.getTarif();
		
		return lecout;
	}
	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", nature=" + nature + "]";
	}
	public List<Levee> getListLevee() {
		return lesLevees;
	}
	public void setListLevee(List<Levee> listLevee) {
		this.lesLevees = listLevee;
	}
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	
	
}
