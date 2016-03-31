package com.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.persistance.AccesData;

@Entity
@Table (name="utilisateur")
public class Utilisateur {
	@Id
	@Column (name = "idUtilisateur")
	private String idUtilisateur;
	@Column (name = "nomUtilisateur")
	private String nomUtilisateur;
	@Column (name = "prenomUtilisateur")
	private String prenomUtilisateur;
	@Column (name = "login")
	private String login;
	@Column (name = "mdp")
	private String mdp;
	@Column (name = "niveau")
	private int niveau;
	
	
	
	public Utilisateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String login, String mdp,
			int niveau) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.login = login;
		this.mdp = mdp;
		this.niveau = niveau;
	}
	public Utilisateur(){
		super();
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", login=" + login + ", mdp=" + mdp + ", niveau="
				+ niveau + "]";
	}
	public String getMdp() {
		return mdp;
	}
	
}
