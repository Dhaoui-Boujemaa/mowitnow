package mowitnow;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import mowitnow.enm.ExceptionMessage;


public class MainClassTest {
	final String CHEMIN_FICHIER = "./src/test/resources/";

	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test(expected = IllegalArgumentException.class)
	public void test_main_fichier_erreur_args() throws ExceptionTondeuse, IOException {
		MainClass.main("1", "2");
	}

	@Test
	public void test_main_no_file() throws ExceptionTondeuse, IOException {
		expectedException.expect(ExceptionTondeuse.class);
		expectedException.expectMessage(ExceptionMessage.ERREUR_FICHIER_INTROUVABE.getMessage());
		MainClass.main("no_file");
	}
 
	@Test
	public void test_main_input_with_one_line() throws ExceptionTondeuse, IOException {
		expectedException.expect(ExceptionTondeuse.class);
		expectedException.expectMessage(ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
		MainClass.main(CHEMIN_FICHIER + "input_with_one_line.txt");
	}

	@Test
	public void test_main_input_with_expected_info() throws ExceptionTondeuse, IOException {
		System.out.println("***********Test input_with_expected_info****************");
		expectedException.expect(ExceptionTondeuse.class);
		expectedException.expectMessage(ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
		MainClass.main(CHEMIN_FICHIER + "input_with_expected_info.txt");
		System.out.println("*************Fin***************");
	}

	@Test
	public void test_main_input_with_no_info() throws ExceptionTondeuse, IOException {
		expectedException.expect(ExceptionTondeuse.class);
		expectedException.expectMessage(ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
		MainClass.main(CHEMIN_FICHIER + "input_with_no_info.txt");

	}

	@Test
	public void test_main_input_file_ko() throws ExceptionTondeuse, IOException {
		expectedException.expect(ExceptionTondeuse.class);
		expectedException.expectMessage(ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
		MainClass.main(CHEMIN_FICHIER + "input_file_ko.txt");
	}

	@Test
	public void test_main_input_file_ok() throws ExceptionTondeuse, IOException {
		
		System.out.println();
		System.out.println();
		System.out.println("******test input_file_ok *********"); 
		MainClass.main(CHEMIN_FICHIER + "input_file_ok.txt");
		assertTrue(MainClass.resultats!=null);
		assertTrue(MainClass.resultats.size() == 2);
		assertTrue(MainClass.resultats.contains("1 3 N"));
		assertTrue(MainClass.resultats.contains("5 1 E"));
		System.out.println("************Fin**************");
	 

	}
}