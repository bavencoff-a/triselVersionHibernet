package com.metier;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="usager")
@Inheritance (strategy=InheritanceType.JOINED)
public class Usager {
	@Id
	@Column (name = "idUsager")
	private String idUsager;
	@Column (name = "nom")
	private String nom;
	@Column (name = "prenom")
	private String prenom;
	@Column (name="adresse_Rue")
	private String adresseRueUsager;
	@Column (name="adresse_Ville")
	private String adresseVilleUsager;
	@Column (name="code_Postal")
	private String cpUsager;
	@Column (name="nomUser")
	private String nomUser;
	@Column (name="motDePasse")
	private String motDePasse;
	@OneToMany
	@JoinColumn(name="idUsager")
	private List<HabitationIndividuelle> lesHabitationsIndividuelles;
	
	@OneToMany
	@JoinColumn(name="idUsager")
	private List<Foyer> lesFoyers;
	
	

/**
 * Constructeur de Usager
 * @param idUsager
 * @param nom
 * @param prenom
 * @param adresseRueUsager
 * @param adresseVilleUsager
 * @param cpUsager
 * @param nomUser
 * @param motDePasse
 */
	public Usager(String idUsager, String nom, String prenom, String adresseRueUsager, String adresseVilleUsager,
			String cpUsager, String nomUser, String motDePasse) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseRueUsager = adresseRueUsager;
		this.adresseVilleUsager = adresseVilleUsager;
		this.cpUsager = cpUsager;
		this.nomUser = nomUser;
		this.motDePasse = motDePasse;
		
	}
	/**
	 * Constructeur de Usager
	 
	 */
		public Usager() {
			super();
			
		}
	
/**
 * getNom
 * @return String nom
 */
	public String getNom() {
		return nom;
	}
/**
 *  setNom
 * @param nom modifier le nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}
/**
 *  getPrenom
 * @return String prenom
 */
	public String getPrenom() {
		return prenom;
	}
/**
 *  setPrenom
 * @param prenom : modifile prenom
 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
/**
 * getAdresseRueUsager
 * @return String adresseRueUsager
 */
	public String getAdresseRueUsager() {
		return adresseRueUsager;
	}
/**
 * setAdresseRueUsager
 * @param adresseRueUsager : modifi l'adresse rue de l'usager
 */
	public void setAdresseRueUsager(String adresseRueUsager) {
		this.adresseRueUsager = adresseRueUsager;
	}
/**
 * getAdresseVilleUsager
 * @return String adresseVilleUsager
 */
	public String getAdresseVilleUsager() {
		return adresseVilleUsager;
	}
/**
 * setAdresseVilleUsager
 * @param adresseVilleUsager modifi l'adresse de la ville de l'usager
 */
	public void setAdresseVilleUsager(String adresseVilleUsager) {
		this.adresseVilleUsager = adresseVilleUsager;
	}
/**
 * getCpUsager
 * @return String le code postale de l'Usager 
 */
	public String getCpUsager() {
		return cpUsager;
	}
/**
 * setCpUsager
 * @param cpUsager : modifi le code postal de l'usager
 */
	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}
/**
 * getNomUser
 * @return String nomUser
 */
	public String getNomUser() {
		return nomUser;
	}
/**
 * setNomUser
 * @param nomUser modifie le nomUser
 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
/**
 * getMotDePasse
 * @return String motDePasse
 */
	public String getMotDePasse() {
		return motDePasse;
	}
/**
 * setMotDePasse
 * @param motDePasse : modifi le mot de passe de l'usager
 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
/**
 * getIdUsager
 * @return String idUsager
 */
	public String getIdUsager() {
		return idUsager;
	}
/**
 * ToString
 */
	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adresseRueUsager="
				+ adresseRueUsager + ", adresseVilleUsager=" + adresseVilleUsager + ", cpUsager=" + cpUsager
				+ ", nomUser=" + nomUser + ", motDePasse=" + motDePasse + "]";
	}
public List<HabitationIndividuelle> getLesHabitationsIndividuelles() {
	return lesHabitationsIndividuelles;
}
public void setLesHabitationsIndividuelles(List<HabitationIndividuelle> lesHabitationsIndividuelles) {
	this.lesHabitationsIndividuelles = lesHabitationsIndividuelles;
}
public void addLesHabitationsIndividuelles(HabitationIndividuelle habitationIndividuelle) {
	this.lesHabitationsIndividuelles.add(habitationIndividuelle);
}
public List<Foyer> getLesFoyers() {
	return lesFoyers;
}
public void setLesFoyers(List<Foyer> lesFoyers) {
	this.lesFoyers = lesFoyers;
}
public void addLesFoyers(Foyer foyers) {
	this.lesFoyers.add(foyers);
}
	
}
