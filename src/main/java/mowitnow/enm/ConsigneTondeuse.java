package mowitnow.enm;

public  enum ConsigneTondeuse{
	DROITE('D', "Pivoter à droite"),
	GAUCHE('G', "Pivoter à gauche"),
	AVANCER('A', "Avancer");
	
	private String libelleConsigne;
	private char codeConsigne;
	
	private ConsigneTondeuse(char codeConsigne, String libelleConsigne) {
		this.libelleConsigne = libelleConsigne;
		this.codeConsigne = codeConsigne;
	}

	public String getLibelleConsigne() {
		return libelleConsigne;
	}

	public void setLibelleConsigne(String libelleConsigne) {
		this.libelleConsigne = libelleConsigne;
	}

	public char getCodeConsigne() {
		return codeConsigne;
	}

	public void setCodeConsigne(char codeConsigne) {
		this.codeConsigne = codeConsigne;
	}


}
