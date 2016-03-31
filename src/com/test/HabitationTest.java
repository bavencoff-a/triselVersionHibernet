package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class HabitationTest {

	/**/
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date datelv1;
	Date datelv2;
	Date datelv3;
	Date datelv4;
	Usager unUsager;
	Levee uneLevee1Pb1;
	Levee uneLevee2Pb1;
	Levee uneLevee1Pb2;
	Levee uneLevee2Pb2;
	TypeDechet unDechetPb1;
	TypeDechet unDechetPb2;
	Poubelle unePoubelle1;
	Poubelle unePoubelle2;
	Habitation Hab1;
	//-------------- la liste de levee -----------------
		ArrayList<Poubelle> lesPoub = new ArrayList<Poubelle>();
	
	@Before
	public void setUp() throws Exception {
		//initalisation de l'usager
		unUsager = new Usager("idU1","jeanmart","Robert","66 rue du six","hellmetz","1666","diablo","petitangedu666");
		//initalisation des dates
				try
				{
					//Poubelle 1
					datelv1 = dateFormat.parse("01/01/0001");
					datelv3 = dateFormat.parse("03/01/0001");
					//poubelle 2
					datelv2 = dateFormat.parse("02/03/0003");
					datelv4 = dateFormat.parse("04/03/0003");
				}catch (ParseException e)
				{
					e.printStackTrace();
				}
			
				//initalisation des Levees
		uneLevee1Pb1 = new Levee(01,datelv1,1.00);
		uneLevee2Pb1 = new Levee(02,datelv2,2.00);
		uneLevee1Pb2 = new Levee(03,datelv3,3.00);
		uneLevee2Pb2 = new Levee(04,datelv4,4.00);
		
		//initalisation des dechets
		unDechetPb1 = new TypeDechet("id01","Verre",1.00);
		unDechetPb2 = new TypeDechet("id02","Noir",2.00);
		//initalisation des poubelles
		unePoubelle1 = new Poubelle("id01",unDechetPb1);
		unePoubelle2 = new Poubelle("id02",unDechetPb2);
		//ajout des Levees dans les poubelles
		unePoubelle1.ajoutLevee(uneLevee1Pb1);
		unePoubelle1.ajoutLevee(uneLevee1Pb2);
		unePoubelle2.ajoutLevee(uneLevee2Pb1);
		unePoubelle2.ajoutLevee(uneLevee2Pb2);
		//instanciation de l'objet habitation
		Hab1 = new Habitation("idH1","11 rue celestin","1111","seven-en-ciel",unUsager);
	}

	@Test
	public void testHabitation() {
		assertNotNull("L'instance est créer !",Hab1);
	}

	@Test
	public void testGetAdresseRue() {
		assertEquals("le libelle est il correct ? ","11 rue celestin",Hab1.getAdresseRue());
	}

	@Test
	public void testGetCodePostal() {
		assertEquals("le libelle est il correct ? ","1111",Hab1.getCodePostal());
	}

	@Test
	public void testGetAdresseVille() {
		assertEquals("le libelle est il correct ? ","seven-en-ciel",Hab1.getAdresseVille());
	}

	@Test
	public void testGetUsager() {
		//assertEquals("le libelle est il correct ? ",unUsager,Hab1.getUsager());
	}
	@Test
	public void testGetCout() {
	
		//Hab1.ajoutPoubelle(unePoubelle1);
		Hab1.ajoutPoubelle(unePoubelle2);
		//assertEquals(Hab1.getCout(0001,01),4.00,1);
		System.out.println("test "+Hab1.getCout(0001,01));
		assertEquals(Hab1.getCout(0003,03),12.00,1);
	}
	
	
	@Test
	public void testAjoutPoubelle() {
		lesPoub.add(unePoubelle1);
		Hab1.ajoutPoubelle(unePoubelle1);
		assertEquals("le libelle est il correct ? ",lesPoub,Hab1.getLesPoubelle());
	}
	
	@Test
	public void testAjoutPoubelleNull() {
		lesPoub.add(unePoubelle1);
		lesPoub.add(unePoubelle2);
		Hab1.ajoutPoubelle(unePoubelle1);
		assertNotEquals("le libelle est il correct ? ",lesPoub,Hab1.getLesPoubelle());
	}
	@Test
	public void testGetLesPoubelle() {
		lesPoub.add(unePoubelle1);
		Hab1.ajoutPoubelle(unePoubelle1);
		assertEquals("le libelle est il correct ? ",lesPoub,Hab1.getLesPoubelle());
	}
	
	

	@Test
	public void testGetIdHabitation() {
		assertEquals("le libelle est il correct ? ","idH1",Hab1.getIdHabitation());
	}

	/*@Test
	public void testToString() {
		fail("Not yet implemented");
	}*/

}
