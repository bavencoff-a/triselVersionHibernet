package com.vue;
import java.text.SimpleDateFormat;

import java.io.FileNotFoundException;
import com.util.Parametre;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;

import com.persistance.*;
import com.metier.*;
import com.util.*;
import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class Programme {
	 
	public static void main(String[] args) {
		
		
		
		
		FactureIndividuelle factchezmoi = new FactureIndividuelle(1,"Test1",2016,11,"hab1");
		
		System.out.println(" test facture ind"+ AccesData.ajouterFacture(factchezmoi));
		
		
		FactureFoyer factchezmonpote = new FactureFoyer(2,"Test1",2016,11,"tour1");
		
		System.out.println(" test facture ind"+ AccesData.ajouterFacture(factchezmonpote));
		//Parametre.testFacture();
		//Session s = HibernateSession.getSession();
		//find
		//TypeDechet td = (TypeDechet)s.get(TypeDechet.class, "ver");
		//System.out.println(""+ td.toString());
		//retrive
		//List<TypeDechet> tds = s.createQuery("from TypeDechet").list();
	//	for(TypeDechet t: tds){
//			System.out.println(""+t.toString());
		//}
		//creat
		
		//TypeDechet tdcreat = new TypeDechet("1","pap",2.00);
		//Transaction trans=s.beginTransaction();
		//s.save(tdcreat);
		//trans.commit();
		//test accesdata
		//TypeDechet td = new TypeDechet("1","pap",2.00);
		/*Calendar cal;
		SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		cal = Calendar.getInstance();
		try{
			
			
		}catch(Exception e){
			
		}
		
		Utilisateur uti = null;
		Poubelle pb = null;
		Facture fact = new Facture("michel",1985,5,"hab1");
		Usager us = null;
		Habitation hab = null;
		List<Habitation> lis = null;
		List<Utilisateur> lisU = null;
		
		//test
		//usager
		try{
			us = AccesData.getUsager("usag1");
			
			System.out.println("usager : OK"+us.toString());
		}catch(Exception e){
			System.out.println("usager : Erreur");
		}
		
		//test getHabitation
		try{
			hab = AccesData.getHabitation("hab1");
			System.out.println("habitation : OK"+hab.toString());
		}catch(Exception e){
			System.out.println("habitation : Erreur");
		}
		
		//test ajoutLevee
		try{
			boolean tru;
			Date dat = dateFormat.parse("24/5/1985");
			Levee lv = new Levee(dat,30.00,"pb1");
			tru = AccesData.ajoutLevee(lv);
			System.out.println("ajoutLevee : "+tru);
		}catch(Exception e){
			System.out.println("ajoutLevee : Erreur");
		}
		
		//test getPoubelle
		try{
			//pb = AccesData.getPoubelle("pb1");
			System.out.println("getPoubelle : OK");
			System.out.println(" to String : "+pb.toString());
		}catch(Exception e){
			System.out.println("getPoubelle : Erreur");
		}
		
		//test ajouterFacture
		try{
			boolean tru;
			 tru= AccesData.ajouterFacture(fact);
			
			System.out.println("ajouterFacture : OK"+tru);
		}catch(Exception e){
			System.out.println("ajouterFacture : Erreur");
		}
		
	
		// getLesHabitations
		try{
			
			lis = AccesData.getLesHabitations();
			System.out.println("getLesHabitations : OK");
		}catch(Exception e){
			System.out.println("getLesHabitations : Erreur");
		}
		
		//test getUtilisateur 
		try{
			uti = AccesData.getUtilisateur("lequay");
			System.out.println("getPoubelle : OK");
			System.out.println(" to String : "+uti.toString());
		}catch(Exception e){
			System.out.println("getPoubelle : Erreur");
		}
		
		
		// getLesHabitations
		try{
					
			uti = null;
			uti = AccesData.getUtilisateurslogMdp("lequay","tyty");
			System.out.println("getLesUtilisateurs : OK");
			System.out.println("getLesUtilisateurs : count = "+uti.toString());
		}catch(Exception e){
			System.out.println("getLesUtilisateurs : Erreur");
		}
		/*
		
		HabitationDAO hbDAO = new HabitationDAO();
		ArrayList<Habitation> lesHabitation = hbDAO.retrieve();
		
		if(lesHabitation.size() !=0){
			for(Habitation h : lesHabitation){
				double poids,tarif,tt =0.00;
				double toto = 0.00;
				ArrayList<Poubelle> lesPoubelles;
				System.out.println("                       FACTURE");
				System.out.println("___________________________________________________");
				System.out.println("Nom prenom : "+h.getUsager().getNom()+" "+h.getUsager().getPrenom());
				System.out.println("adresse : "+h.getAdresseRue()+ " "+h.getCodePostal() +" "+ h.getAdresseVille());
				System.out.println("____________________________________________________");
				System.out.println("code usager : "+h.getUsager().getIdUsager());
				System.out.println("Les pesées des poubelle au de mois de : juillet 2015");
				lesPoubelles = h.getLesPoubelle();
				for(Poubelle p : lesPoubelles){
					System.out.println("Poubelle : "+p.getIdPoubelle()+"  Nature des déchets : "+p.getNature().getLibelle());
					ArrayList<Levee> desLeves = p.getLesLevees(2015,07);
					for(Levee l : desLeves){
						poids = l.getPoids();
						tarif = p.getNature().getTarif();
						
						System.out.println("Date de pesée | nombre de kg | prix HT au kg | total ht |");
						System.out.println("      "+l.getLaDate()+"|     "+poids+"     |     "+tarif+"      |   "+tarif*poids+"  |");
						
						
					}
					toto = p.getCout(2015, 07);
					tt = tt + toto;
					System.out.println("total ht : "+toto);
				}
				
				System.out.println("total ht general : "+tt);
				System.out.println("Montant TVA : "+tt*0.20);
				System.out.println("Total TTC : "+tt*1.20);
				
				
			}
			
		}
		
		
	*/	
	}

}
