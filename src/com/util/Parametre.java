package com.util;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Calendar;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.persistance.AccesData;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Parametre {

	private static String nomFichier = "paramAppli.ini";
	private static final String tabMois[]={"","janvier", "février", "mars", "avril",

			"mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"

	};
	
	public static void trasfertFichier(File f)
	{
		String chemin = Parametre.getCheminLeveeTraitesS() +"\\"+ f.getName();
		System.out.println("test chemin vers cpoie de fichier= "+chemin);
		File dest = new File(chemin);
		f.renameTo(dest);
	}
	public static String getExtensionFichier(String nomFichier)
	{
		String res;
		String[] data = nomFichier.split("\\.");
		res = data[1];
		System.out.println("test extension= "+res);
		
		return res;
	}
	private static String lecture(int n)
	{
		int i = 0;
		String res, ligne;
		FichierTexte fichier = new FichierTexte();
		fichier.openFileReader(nomFichier);
		
		ligne = fichier.readLigne();
		while(i<n)
		{
			ligne = fichier.readLigne();
			i++;
		}
		res = ligne;
		System.out.println("test chemin = "+res);
		return res;
	}
	
	public static int nbLevee(){
		// ram�ne le nombre de fichiers du dossier atraiter
		String cheminLevee = getCheminLeveeATraiter();
		File f = new File(cheminLevee);
		return f.listFiles().length; 
	}
	public static String getCheminBd()
	{
		
		return lecture(1);
	}
	
	public static String getCheminLeveeATraiter()
	{
		return lecture(3);
	}
	public static String getCheminLeveeLog()
	{
		return lecture(9);
	}
	public static String getCheminLeveeTraitesS()
	{
		return lecture(5);
	}
	public static String getCheminFacturePdf()
	{
		System.out.println("test lecture "+ lecture(7));
		return lecture(7);
	}
	public static String getCheminFichier(Habitation hab, int mois, int an)

	{ 

	// caractere \\ pour \

	String nomDossier = Parametre.getCheminFacturePdf() + "\\" + tabMois[mois];

	String nomFichier = getNomFichier(hab, mois, an);

	String cheminComplet = nomDossier + "\\" + nomFichier;

	return cheminComplet;

	}

	public static String getNomFichier(Habitation hab, int mois, int an)

	{ 

	String nomFichier = hab.getIdHabitation() + "-" + hab.getUsager().getIdUsager() + 

	"-Facture-" + tabMois[mois] + "-" + an + ".pdf";

	return nomFichier;

	}
	
	
	public static void editionElementFacture(Habitation h, int mois, int an){
		Document doc = new Document();
		try{
			//var
			double poids,tarif,tt =0.00;
			double toto = 0.00;
			double ttTVA,ttTTC;
			String nomFichier = getNomFichier(h,mois,an);
			List<Poubelle> lesPoubelles;
			
			
			
			
			DecimalFormat df = new DecimalFormat("0.00");
			
			
			//debut
			//création des paragraphes
			PdfWriter.getInstance(doc, new FileOutputStream(nomFichier));
			doc.open();
			Paragraph p1 = new Paragraph("Facture du mois de "+tabMois[mois]+" \r"
					+ "Editée le lundi 20 juillet 2015");
			Paragraph p2 = new Paragraph(h.getUsager().getNom()+""+h.getUsager().getPrenom()+"\r"+h.getAdresseRue()+"\r"+h.getCodePostal()+" "+h.getAdresseVille());
			Paragraph p3 = new Paragraph("Code usager : "+h.getUsager().getIdUsager()+"\r Recapitulatif des peses des poubelles au mois de "+tabMois[mois]);
			//mise en forme des elements
			p1.setAlignment(Element.ALIGN_RIGHT);
			
			
			p2.setIndentationLeft(300);
			//ajoute des element dans le pdf
			doc.add(p1);
			doc.add(p2);
			doc.add(p3);
			
			lesPoubelles = h.getLesPoubelle();
			for(Poubelle p : lesPoubelles){
				Paragraph p4 = new Paragraph("Poubelle:"+p.getIdPoubelle()+" Nature des dechets: "+p.getNature().getLibelle());
				Paragraph p5 = new Paragraph("Date de pesée");
				Paragraph p6 = new Paragraph("nombre de KG");
				Paragraph p7 = new Paragraph("prix HT au KG");
				Paragraph p8 = new Paragraph("total HT");
				// mise en forme
				PdfPTable table = new PdfPTable(4);
				table.setSpacingAfter(10f);
				table.setSpacingBefore(10f);
				PdfPCell cell0 = new PdfPCell(p4);
				PdfPCell cell1 = new PdfPCell(p5);
				PdfPCell cell2 = new PdfPCell(p6);
				PdfPCell cell3 = new PdfPCell(p7);
				PdfPCell cell4 = new PdfPCell(p8);
				
				cell0.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				cell4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				
				cell1.setBackgroundColor(BaseColor.RED);
				cell2.setBackgroundColor(BaseColor.RED);
				cell3.setBackgroundColor(BaseColor.RED);
				cell4.setBackgroundColor(BaseColor.RED);
				
				
				//ajoute des cellules dans la table
				cell0.setColspan(4);
				table.addCell(cell0);
				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				//ajout dans le doc
				
				//suite
				ArrayList<Levee> desLeves = p.getLesLevees(an,mois);
				for(Levee l : desLeves){
					poids = l.getPoids();
					
					tarif = p.getNature().getTarif();
					
					Paragraph p9 = new Paragraph(""+l.getLaDate());
					Paragraph p10 = new Paragraph(""+df.format(poids));
					Paragraph p11 = new Paragraph(""+df.format(tarif));
					Paragraph p12 = new Paragraph(""+df.format(tarif*poids));
					
					PdfPCell cell5 = new PdfPCell(p9);
					PdfPCell cell6 = new PdfPCell(p10);
					PdfPCell cell7 = new PdfPCell(p11);
					PdfPCell cell8 = new PdfPCell(p12);
					
					cell5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					
					table.addCell(cell5);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
	
				}
				toto = p.getCout(an, mois);
				tt = tt + toto;
				Paragraph p13 = new Paragraph("total ht");
				Paragraph p14 = new Paragraph(""+df.format(toto));
				
				PdfPCell cell9 = new PdfPCell(p13);
				PdfPCell cell10 = new PdfPCell(p14);
				
				cell9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				cell10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				
				cell9.setColspan(3);
				
				table.addCell(cell9);
				table.addCell(cell10);
				
				doc.add(table);
				
			}
			Paragraph p15 = new Paragraph("Total general HT");
			Paragraph p16 = new Paragraph("Montant TVA");
			Paragraph p17 = new Paragraph("Total TTC");
			
			Paragraph p18 = new Paragraph(""+df.format(tt));
			ttTVA = tt*0.2;
			
			Paragraph p19 = new Paragraph(""+df.format(ttTVA));
			ttTTC = tt*1.2;
			
			Paragraph p20 = new Paragraph(""+df.format(ttTTC));
			
			PdfPTable tableTotal = new PdfPTable(4);
			tableTotal.setSpacingAfter(10f);
			tableTotal.setSpacingBefore(10f);
			
			PdfPCell cell11 = new PdfPCell(p15);
			PdfPCell cell12 = new PdfPCell(p16);
			PdfPCell cell13 = new PdfPCell(p17);
			
			cell11.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cell12.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			cell13.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			
			cell11.setColspan(3);
			cell12.setColspan(3);
			cell13.setColspan(3);
			
			PdfPCell cell14 = new PdfPCell(p18);
			PdfPCell cell15 = new PdfPCell(p19);
			PdfPCell cell16 = new PdfPCell(p20);
			
			cell14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell15.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell16.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			
			tableTotal.addCell(cell11);
			tableTotal.addCell(cell12);
			tableTotal.addCell(cell13);
			tableTotal.addCell(cell14);
			tableTotal.addCell(cell15);
			tableTotal.addCell(cell16);
			
			doc.add(tableTotal);
			
			
			
			doc.close();
			Runtime.getRuntime().exec("explorer.exe "+nomFichier);
			// enregistrement dans la base, récupération du nom du fichier
			
			Facture f = new Facture(nomFichier,mois, an,h.getIdHabitation());

			
			

			if (AccesData.ajouterFacture(f)) {

			}

			else

			{ System.out.println("Insertion non effectuée"); }

			System.out.println("Insertion effectuée");
		
		}catch(DocumentException e){
			e.printStackTrace ();
		}catch(FileNotFoundException e){
			e.printStackTrace ();	
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	public static void testFacture(){
		// var
		
		
		List<Habitation> lesHabitations = AccesData.getLesHabitations();		
		//debut
		
		
		if(lesHabitations.size() !=0){
			for(Habitation h : lesHabitations){
				editionElementFacture(h,07,2015);
			}
		}
	}
}
