package mowitnow.entites;

/**
 * class permetant de valider les informations qui permettent de
 * lancer une tandeuse 
 * @author myriam
 *
 */
public class Tondeuse {

	private String pelouse ;
	private String donnees ;
	private String consignes ;

	public Tondeuse(){
		this.pelouse = "";
		this.donnees = "";
		this.consignes = "";
	}
	
	public String getPelouse() { 
		return pelouse;
	}

	public void setPelouse(String pelouse) {
		this.pelouse = pelouse;
	}

	public String getDonnees() {
		return donnees;
	}

	public void setDonnees(String donnees) {
		this.donnees = donnees;
	} 

	public String getConsignes() {
		return consignes;
	}

	public void setConsignes(String consignes) { 
		this.consignes = consignes;
	}
}