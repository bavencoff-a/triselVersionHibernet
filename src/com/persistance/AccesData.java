package com.persistance;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.metier.Utilisateur;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

// classe interface avec l'application , appelle le dao adapté pour répondre à la demande

// plus simple pour le développeur lors de l'utilisation

// pas besoin de connaitre tous les fichiers DAO
public class AccesData {

	private static Session s = HibernateSession.getSession();
	private static Transaction trans=null;
	
	public static Usager getUsager(String idUsager){
		
		Usager us = (Usager)s.get(Usager.class, idUsager);
		return us;
	}
	public static List<Usager> getLesUsagers() {
		
		List<Usager> us = null;
		try{
			us = s.createQuery("from Usager").list();
			
		}catch(Exception e){
			System.out.println("Erreur : getLesUsagers");
		}
		
		return us;
	}
	public static Habitation getHabitation(String idHabitation)
	{
		
		Habitation hb = (Habitation)s.get(Habitation.class, idHabitation);
		return hb;
	}
	public static boolean ajoutLevee(Levee uneLevee)
	{
		boolean trouve = false;
		
		try{
			System.out.println(" ::"+uneLevee.toString());
			trans=s.beginTransaction();
			s.save(uneLevee);
			trans.commit();
			trouve = true;
		}
		catch(Exception e){
			System.out.println("Erreur : ajoutLevee");
			trouve =false;
		}
		
		return trouve;
	}
	public static Poubelle getPoubelle(String idPoubelle)
	{		
		Poubelle pb = (Poubelle)s.get(Poubelle.class, idPoubelle);
		return pb;
	}
	public static boolean ajouterFacture(Facture f)
	{
		boolean trouve = false;
		try{
			trans=s.beginTransaction();
			s.save(f);
			trans.commit();
			trouve = true;
		}
		catch(Exception e){
			System.out.println("Erreur : ajouterFacture");
			trouve =false;
		}
		
		return trouve;
	}
	public static List<Habitation> getLesHabitations() {
		
		List<Habitation> habs = null;
		try{
			habs = s.createQuery("from Habitation").list();
			
		}catch(Exception e){
			System.out.println("Erreur : getLesHabitations");
		}
		
		return habs;
	}
	public static List<Habitation> getLesHabitationsByUsager(String idusager) {
		
		List<Habitation> habs = null;
		try{
			habs = s.createQuery("from Habitation where idUsager = '"+idusager+"'").list();
			
		}catch(Exception e){
			System.out.println("Erreur : getLesHabitations");
		}
		
		return habs;
	}
	
	public static Utilisateur getUtilisateur(String idu){
		Utilisateur uti = (Utilisateur)s.get(Utilisateur.class, idu);
		return uti;
	}
	public static Utilisateur getUtilisateurslogMdp(String log,String mdp){
		Utilisateur users = null;
		try{
			
			users = (Utilisateur)s.createQuery("from Utilisateur u where u.login = '"+log+"' and u.mdp ='"+mdp+"'").uniqueResult();
			
		}catch(Exception e){
			System.out.println("Erreur : get utilisateur mdp login");
		}
		return users;
	}
	
	
}
