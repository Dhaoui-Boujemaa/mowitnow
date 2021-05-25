package mowitnow.outil;


	import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import mowitnow.enm.ConsigneTondeuse;
import mowitnow.enm.Orientation;
import mowitnow.entites.Coordonnees;
import mowitnow.entites.Pelouse;
import mowitnow.entites.Tondeuse;


public class FormaterAndParserTest extends TestCase{
	
	@Test
	public void test_check_tondeuse(){
		Tondeuse tondeuse = new Tondeuse();
		tondeuse.setConsignes("DGDGA"); 
		tondeuse.setPelouse("15 6");
		tondeuse.setDonnees("1 3 N");
		assertTrue(FormaterAndParser.checkTondeuse(tondeuse));
	}
	@Test
	
	public void test_tondeuse_pelouse_incorrect(){
		Tondeuse tondeuse = new Tondeuse();
		tondeuse.setConsignes("DGDGA");
		tondeuse.setPelouse("0 -1"); 
		tondeuse.setDonnees("1 2 N");
		assertFalse(FormaterAndParser.checkTondeuse(tondeuse));
	}
	
	@Test
	public void test_tondeuse_donnees_vide(){
		Tondeuse tondeuse = new Tondeuse();
		assertFalse(FormaterAndParser.checkTondeuse(tondeuse));
	} 
	
	
	@Test
	public void test_tondeuse(){
		assertFalse(FormaterAndParser.parseDonneesTondeuse(""));
		assertFalse(FormaterAndParser.parseDonneesTondeuse("1 2 3"));
		assertFalse(FormaterAndParser.parseDonneesTondeuse("12N"));
		assertTrue(FormaterAndParser.parseDonneesTondeuse("1 2 N"));
		assertTrue(FormaterAndParser.parseDonneesTondeuse("1 2 W"));
		assertFalse(FormaterAndParser.parseDonneesTondeuse("1 2 B"));
	}
	
	@Test 
	public void test_liste_Consigne(){
		assertFalse(FormaterAndParser.parseListConsigne(""));
		assertFalse(FormaterAndParser.parseListConsigne("G G"));
		assertFalse(FormaterAndParser.parseListConsigne("GGAAAGADDAN"));
		assertFalse(FormaterAndParser.parseListConsigne("GGAAAG ADDAN"));
		assertTrue(FormaterAndParser.parseListConsigne("DGA"));
		assertTrue(FormaterAndParser.parseListConsigne("GGAAAGADDA"));
	}
	
	@Test
	public void test_ligne_tondeuse() {
		assertEquals(FormaterAndParser.formaterLigneTondeuse("20 13 N").getCoordonneesTondeuse(),new Coordonnees(20, 13));
		assertEquals(FormaterAndParser.formaterLigneTondeuse("20 13 N").getOrientationTondeuse(),Orientation.NORTH);
	}

	@Test
	public void test_ligne_pelouse() {
		assertEquals(FormaterAndParser.formaterLignePelouse("20 13"),new Pelouse(new Coordonnees(20, 13)));
	}

	@Test 
	public void test_ligne_consigne() {
		List<ConsigneTondeuse> formaterLigneConsigne = FormaterAndParser.formaterConsigne("DGAD");
		assertEquals(formaterLigneConsigne.size(),4);
		assertTrue(formaterLigneConsigne.contains(ConsigneTondeuse.AVANCER));
		assertTrue(formaterLigneConsigne.contains(ConsigneTondeuse.DROITE));
		assertTrue(formaterLigneConsigne.contains(ConsigneTondeuse.GAUCHE));
	}

	@Test
	public void test_recuperer_orientation() {
		assertEquals(FormaterAndParser.getOrientation('N'),Orientation.NORTH);
		assertEquals(FormaterAndParser.getOrientation('E'),Orientation.EAST);
		assertEquals(FormaterAndParser.getOrientation('S'),Orientation.SOUTH);
		assertEquals(FormaterAndParser.getOrientation('W'),Orientation.WEST);
	}

}
