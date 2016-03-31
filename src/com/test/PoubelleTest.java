package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest {
private	TypeDechet td;
private	TypeDechet td2;
private	Poubelle pb1;
private	Poubelle pb2;
private	Poubelle pb3;
private Date d1 = null;
private Date d2 = null ;
private Date d3 = null;
private Date d4 = null;
private Levee le1 = null;
private Levee le2 = null;
private Levee le3 = null;
private Levee le4 = null;
private Levee le5 = null;
private Levee le6 = null;
private SimpleDateFormat dateFormat;
private ArrayList<Levee> listeLeveeP1;
private ArrayList<Levee> listeLeveeP2;
private ArrayList<Levee> listeLeveeP3;
@Before
public void setUp() throws Exception {
	// instanciation d'un type déchet nécessaire dans l'objet Poubelle
	td = new TypeDechet("ver", "verre", 0.0614);
	td2 = new TypeDechet("ver", "Classique", 0.1508);
	// instanciation Poubelle avec les deux constructeurs
	pb1 = new Poubelle("pb1", td);
	pb2 = new Poubelle("pb2", td, "hab2");
	pb3 = new Poubelle("pb3", td2);
	// instanciation dates de lev�es au format français
	dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	try
	{
		d1 = dateFormat.parse("15/05/2015");
		d2 = dateFormat.parse("30/05/2015");
		// date pour getleslevee(an,mois)
		d3 = dateFormat.parse("15/04/2015");
		d4 = dateFormat.parse("30/05/2014");
		
		// instanciation 2 levées par poubelle
		le1 = new Levee(d1, 5, pb1.getIdPoubelle());
		le2 = new Levee(d2, 10, pb1.getIdPoubelle());
		le3 = new Levee(d1, 12, pb2.getIdPoubelle());
		le4 = new Levee(d2, 30, pb2.getIdPoubelle());
		// levee pour getleslevee(an,mois)
		le5 = new Levee(d3, 12, pb3.getIdPoubelle());
		le6 = new Levee(d4, 40, pb3.getIdPoubelle());
		// pour affectation des levées par liste
		// et non pas par la méthode ajout
		listeLeveeP1 = new ArrayList<Levee>();
		listeLeveeP2 = new ArrayList<Levee>();
		listeLeveeP3 = new ArrayList<Levee>();
		listeLeveeP1.add(le1);
		listeLeveeP1.add(le2);
		listeLeveeP2.add(le3);
		listeLeveeP2.add(le4);
		//=====
		listeLeveeP3.add(le4);
		listeLeveeP3.add(le5);
		listeLeveeP3.add(le6);
		
		
	} catch (ParseException e){
		e.printStackTrace();
	} 
}
	@Test
	public void testPoubelle() {
		// on vérifie le fonctionnement des deux constructeurs
		assertNotNull(pb1);
		assertNotNull(pb2);
	}

	@Test
	public void testGetIdPoubelle() {
		// on teste le vrai et le faux sur les 2 poubelles
		assertEquals(pb1.getIdPoubelle(), "pb1");
		assertNotEquals(pb1.getIdPoubelle(), "test");
		assertEquals(pb2.getIdPoubelle(), "pb2");
		assertNotEquals(pb2.getIdPoubelle(), "test");
	}

	@Test
	public void testGetNature() {
		assertEquals(pb1.getNature(), td);
		assertEquals(pb2.getNature(), td);
		assertNotNull(pb1.getNature());
		assertNotNull(pb2.getNature());
	}
	@Test
	public void testGetIdHabitation() {
		assertEquals(pb1.getIdHabitation(), "");
		assertEquals(pb2.getIdHabitation(), "hab2");
	}
	
	@Test
	public void testSetIdHabitation() {
		pb1.setIdHabitation("hab1");
		assertEquals(pb1.getIdHabitation(), "hab1");
	
	}
	@Test
	public void testGetLesLevees() {
		// test pour savoir si la collection a été instanci�e dans les 2 constructeurs, vide pour l'instant
		assertEquals(pb1.getLesLevees().size(), 0);
		assertEquals(pb2.getLesLevees().size(), 0);
		// affectation de la collection de levée
		pb2.setLesLevees(listeLeveeP2);
		assertEquals(pb2.getLesLevees(), listeLeveeP2);
		assertEquals(pb2.getLesLevees().size(), 2);
		assertEquals(pb2.getLesLevees().get(0), le3);
		assertEquals(pb2.getLesLevees().get(1), le4);
		
	}
	@Test
	public void testAjoutLevee() {
		// ajout 1 levée pour chaque poubelle
		pb1.ajoutLevee(le1);
		pb2.ajoutLevee(le3);
		// test qu'il y a bien un élément ajout�
		assertEquals(pb1.getLesLevees().size(), 1);
		assertEquals(pb2.getLesLevees().size(), 1);
		// test sur les éléments ajout�s
		assertEquals(pb1.getLesLevees().get(0),le1);
		assertNotEquals(pb1.getLesLevees().get(0),null);
		assertEquals(pb2.getLesLevees().get(0),le3);
		assertNotEquals(pb2.getLesLevees().get(0),null);
	}

	
	@Test
	public void testSetLesLevees() {
		pb1.setLesLevees(listeLeveeP1);
		assertEquals(pb1.getLesLevees().size(), 2);
		assertEquals(pb1.getLesLevees().get(0), le1);
		assertEquals(pb1.getLesLevees().get(1), le2);
		assertEquals(pb1.getLesLevees(), listeLeveeP1);
	}
	@Test
	public void testGetLesLeveesAnneeMois() {
		pb3.setLesLevees(listeLeveeP3);
		assertEquals(pb3.getLesLevees().size(), 3);
		assertEquals(pb3.getLesLevees(2015,05).size(), 1);
		assertEquals(pb3.getLesLevees(2014,05).size(), 1);
		assertEquals(pb3.getLesLevees(2015,04).size(), 1);
	}
	@Test
	public void testGetlesCout() {
		pb3.setLesLevees(listeLeveeP3);
		assertEquals(pb3.getCout(2015,05),4.52,0.01);
		assertEquals(pb3.getCout(2014,05),6.03,0.01);
		assertEquals(pb3.getCout(2015,04),1.80,0.01);
		
		pb3.setLesLevees(listeLeveeP2);
		//assertEquals(pb3.getCout(2015,05), 2.58 ,0.01);
		
	}
	//@Test
	/*public void testToString() {
		pb1.ajoutLevee(le1);
		pb1.ajoutLevee(le2);
		String attendu = "Poubelle [idPoubelle=pb1, nature=TypeDechet [code=ver, libelle=verre, tarif=0.1], idHabitation=, lesLevees=[Levee [idLevee=0, laDate=Fri May 15 00:00:00 CEST 2015, poids=5.0, idPoubelle=pb1], Levee [idLevee=0, laDate=Sat May 30 00:00:00 CEST 2015, poids=10.0, idPoubelle=pb1]]]";
		System.out.println(pb1.toString());
		assertEquals(pb1.toString(), attendu);
	}*/
}
