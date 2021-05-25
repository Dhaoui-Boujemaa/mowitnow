package mowitnow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mowitnow.Execution.ExecutionConsigneTondeuse;
import mowitnow.enm.ExceptionMessage;
import mowitnow.entites.Tondeuse;
import mowitnow.outil.FormaterAndParser;

public class MainClass { 

	protected static List<String> resultats;

	public static void main(String... args) throws ExceptionTondeuse, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			MainClass instance = new MainClass();
			resultats = instance.lancerTraitements(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * validation du fichier et lancement des consignes de la tondeuses
	 */
	private List<String> lancerTraitements(File fichier)
			throws ExceptionTondeuse, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionTondeuse(ExceptionMessage.ERREUR_FICHIER_INTROUVABE.getMessage());
		} else {
		Tondeuse tondeuse = new Tondeuse();
			Scanner scanner = new Scanner(fichier);
			try {
				getFirstLigneFile(tondeuse, scanner);
				return executerNextLineOfFile(tondeuse, scanner);
			} finally {
				if (scanner != null) { 
					scanner.close();
				}
			}
		}
	} 

	/**
	 * traiter la premiere ligne du fichier
	 */
	protected void getFirstLigneFile(Tondeuse tondeuse, Scanner scanner)
			throws ExceptionTondeuse {
		if (scanner.hasNext()) {
			tondeuse.setPelouse(scanner.nextLine()); 
		}  
		if (!scanner.hasNext()) {
			throw new ExceptionTondeuse(
					ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
		}
	}

	private List<String> executerNextLineOfFile(Tondeuse tondeuse,
			Scanner scanner) throws ExceptionTondeuse { 
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			// lecture de la positon initiale de la tondeuse
			tondeuse.setDonnees(scanner.nextLine());
 
			if (scanner.hasNext()) {
				tondeuse.setConsignes(scanner.nextLine());
				listePositions.add(parserEtExecuterConsigne(tondeuse));
			} else {
				throw new ExceptionTondeuse(ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
			}
		}
		return listePositions;
	}

	/**
	 * Parser et executer le consigne de la tondeuse
	 */ 
	private String parserEtExecuterConsigne(Tondeuse tondeuse)
			throws ExceptionTondeuse {
		if (!FormaterAndParser.checkTondeuse(tondeuse)) {
			throw new ExceptionTondeuse(ExceptionMessage.ERREUR_DONNEES_INCORRECTES.getMessage());
		} else {
			ExecutionConsigneTondeuse executionConsigneTondeuse = new ExecutionConsigneTondeuse();
			executionConsigneTondeuse.setPelouse(FormaterAndParser
					.formaterLignePelouse(tondeuse.getPelouse()));
			executionConsigneTondeuse.setPositionTondeuse(FormaterAndParser 
					.formaterLigneTondeuse(tondeuse.getDonnees()));
			executionConsigneTondeuse.setListeConsigne(FormaterAndParser
					.formaterConsigne(tondeuse.getConsignes())); 
			executionConsigneTondeuse.executerConsignes();;
			System.out.println(executionConsigneTondeuse);
			return executionConsigneTondeuse.toString();
		}
	}
}