package mowitnow.outil;

import java.util.ArrayList;
import java.util.List;

import mowitnow.enm.ConsigneTondeuse;
import mowitnow.enm.Orientation;
import mowitnow.entites.Coordonnees;
import mowitnow.entites.Pelouse;
import mowitnow.entites.PositionTondeuse;
import mowitnow.entites.Tondeuse;

public class FormaterAndParser {

	private static final String CHAINE_ESPACE = " ";
 
	private FormaterAndParser(){

	}
	/**
	 * parser la position de la tondeuse et son orientation
	 */
	public static boolean parseDonneesTondeuse(String donneesTondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation())
			.append("|").append(Orientation.SOUTH.getCodeOrientation())
			.append("|").append(Orientation.EAST.getCodeOrientation())
			.append("|").append(Orientation.WEST.getCodeOrientation());
		return donneesTondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	
	
	/**
	 * @return true si les informations de la tondeuse sont correctes, false sinon
	 */
	public static boolean checkTondeuse(Tondeuse tondeuse){
		return FormaterAndParser.parseDonneesTondeuse(tondeuse.getDonnees())
				&& FormaterAndParser.parsePelouse(tondeuse.getPelouse())
				&& FormaterAndParser.parseListConsigne(tondeuse.getConsignes());
	}
	
	/**
	 * parser la ligne des consignes
	 */ 
	public static boolean parseListConsigne(String consignes){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(ConsigneTondeuse.AVANCER.getCodeConsigne())
		.append("|").append(ConsigneTondeuse.DROITE.getCodeConsigne())
		.append("|").append(ConsigneTondeuse.GAUCHE.getCodeConsigne())
		.append(")+");

		return consignes.matches(stringBuilder.toString());
	}

	/**
	 * parser la position de la pelouse
	 */
	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
	/**
	 * récuperer la position de la tondeuse 
	 */
	public static PositionTondeuse formaterLigneTondeuse(String ligneTondeuse){
		String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
		Coordonnees pCoordonneesTondeuse = new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
		return new PositionTondeuse(pCoordonneesTondeuse, orientationTondeuse);
	}

	/**
	 * récuperer l'objet Pelouse contenant les coordonnées limites de la pelouse
	 */
	public static Pelouse formaterLignePelouse(String lignePelouse){
		String[] elts = lignePelouse.split(CHAINE_ESPACE);
		return new Pelouse(new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	/**
	 * récuperer une liste d'enum ConsigneTondeuse correspondante à la ligne d'instruction
	 */
	public static List<ConsigneTondeuse> formaterConsigne(String ligneConsigne){
		List<ConsigneTondeuse> listConsigne = new ArrayList<ConsigneTondeuse>();
		for(char consigne :ligneConsigne.toCharArray()){
			listConsigne.add(getCodeConsigne(consigne));
		}
		return listConsigne;  
	}
 
	/** 
	 * récuperer un enum Orientation correspondant au caractère de l'orientation
	 */
	public static Orientation getOrientation(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == cOrientation){
				return orientation;
			}
		}
		return null;
	}

	/**
	 * récuperer un enum ConsigneTondeuse correspondant au caractère d'instrction
	 */
	public static ConsigneTondeuse getCodeConsigne(char consigne){
		for(ConsigneTondeuse bConsigne : ConsigneTondeuse.values()) {
			if (bConsigne.getCodeConsigne() == consigne) {
				return bConsigne;
			}
		}
		return null;
	}
}