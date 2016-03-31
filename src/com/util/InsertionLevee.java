package com.util;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.persistance.*;
import org.jdom2.Document;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;



public class InsertionLevee {
	
	public static void traitementLevee()
	{
		//var
		String traiter,log,traites,extension;
		int i=0;
		File[] list;
		ArrayList<File> l = new ArrayList<File>(); 
		
		//debut
		traiter =Parametre.getCheminLeveeATraiter();
		log =Parametre.getCheminLeveeLog();
		traites =Parametre.getCheminLeveeTraitesS();
		File f = new File(traiter);
		if(!f.canRead())
		{
			System.out.println(" Rien � traiter");
		}
		else
		{
			list=f.listFiles();
		
			for( File file : list){
				if(file.isFile())
				{
					extension =Parametre.getExtensionFichier(file.getName());
					switch (extension)
					{
					case "txt":
						
						InsertionLevee.traitementFichierText(file.getAbsolutePath());
						Parametre.trasfertFichier(file);
						break;
					case "xml":
						InsertionLevee.traitementFichierXml(file.getAbsolutePath());
						Parametre.trasfertFichier(file);
						break;
					}
										
					System.out.println(" extension = "+extension);
					
				}
				
			}
				
			
		}
		
	}
	public static void traitementFichierText(String cheminlevee){
		
		//var
		String ligne, codeHabita, poubelle, poidString;
		Double poidDouble = 0.00;
		SimpleDateFormat dateFormat = null;
		Date date = null;
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		FichierTexte fichier = new FichierTexte();
		String[] tab;
		
		
		//debut
		//ouverture du fichier text
		fichier.openFileReader(cheminlevee);
		//lecture de la permière ligne
		ligne = fichier.readLigne();
		
		try{
			date = dateFormat.parse(""+ligne);
		}catch(Exception e){
			System.out.println("Erreur Date");
		}
		
		
		
		//parcours du fichier text ligne/ligne
		while((ligne = fichier.readLigne()) != null ){
			
			//splite de la ligne
			tab = ligne.split(":");
			
			poubelle = tab[1];
			poidString = tab[2];
			
			poidDouble = Double.parseDouble(poidString);
			
			Levee lv = new Levee(date,poidDouble,poubelle);
			AccesData.ajoutLevee(lv);
			
		}
		fichier.closeFileReader();
		
	}
	
	public static void traitementFichierXml(String cheminLevee){
		//________________ouverture du fichier XML_________________
		//var
		Double poidDouble = 0.00;
		SimpleDateFormat dateFormat = null;
		Date date = null;
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		//declaration du document xml
		Document document = null;
		//declaration de l'element racine
		Element racine = null;
		
		//creation de l'instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		
		try{
			
			//On cr�e un nouveau document JDOM avec en argument le fichier 
			document = sxb.build(new File(cheminLevee));
			//initialisation d'un new element racine avec elem racin du document
			racine = document.getRootElement();
			
			try{
				date = dateFormat.parse(""+racine.getChild("Date").getText());
			}catch(Exception e){
				System.out.println("Erreur Date");
			}
			//On crée une List contenant tous les noeuds "Devloppeur"
			List<Element> listPesee = racine.getChildren("Levee");
			
			//parcour
			
			for(Element e : listPesee){
				
				poidDouble = Double.parseDouble(e.getChild("poids").getText());
				
				Levee lv = new Levee(date,poidDouble,e.getChild("poubelle").getText());
				AccesData.ajoutLevee(lv);
			}
			
		}
		catch(JDOMException e2){
			e2.printStackTrace();
		}
		catch(IOException e2){
			e2.printStackTrace();
		}
	}
}
