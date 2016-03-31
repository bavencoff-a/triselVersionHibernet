package com.vue;

import java.util.List;
import java.util.Scanner;

import com.metier.Habitation;
import com.persistance.AccesData;
import com.util.InsertionLevee;
import com.util.Parametre;

public class MenuConsole {
	public static void main(String[] args) {

		int choix=0; 

		Scanner in=new Scanner(System.in); 

		while (choix!=3) 
		{ 
			System.out.println("Menu général"); 
	
			System.out.println("1- Insertion des levées"); 
	
			System.out.println("2 -Edition des factures"); 
	
			System.out.println("3- quitter"); 
	
			System.out.println("Donner votre choix"); 
	
			choix=in.nextInt(); 
	
			switch (choix) { 
		
				case 1 : 
		
				// insertion des levée
					insertion();
		
				break; 
		
				case 2 : 
		
				// à compléter 
					
					facturation();
					
					//Parametre.editionElementFacture(h, mois, an);
				break; 
		
				default: 
		
				break;
			}
		}
	}
	private static void insertion(){
		InsertionLevee.traitementLevee();
	}
	private static void facturation(){
		int an, mois;
		List<Habitation> habs;
		Scanner in=new Scanner(System.in); 
		System.out.println("donnez l'année de la facture");
		an = in.nextInt(); 
		System.out.println("donnez le mois de la facture");
		mois = in.nextInt();
		try{
			habs = AccesData.getLesHabitations();
			for(Habitation habitation : habs){
				Parametre.editionElementFacture(habitation, mois, an);
			}
		}catch(Exception e){
			System.out.println("une erreur est survenu");
		}
		
	
	}
}


