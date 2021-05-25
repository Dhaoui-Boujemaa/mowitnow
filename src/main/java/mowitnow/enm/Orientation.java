package mowitnow.enm;

public enum Orientation {
	NORTH('N', "Nord"),
	EAST('E', "est"),
	WEST('W', "ouest"),
	SOUTH('S', "sud");
	
	private char codeOrientation;
	private String libelleOrientation;
	
	private Orientation(char codeOrientation, String libelleOrientation){
		this.codeOrientation = codeOrientation;
		this.libelleOrientation = libelleOrientation;
	}

	public char getCodeOrientation() {
		return codeOrientation;
	}

	public void setCodeOrientation(char codeOrientation) {
		this.codeOrientation = codeOrientation;
	}

	public String getLibelleOrientation() {
		return libelleOrientation;
	}

	public void setLibelleOrientation(String libelleOrientation) {
		this.libelleOrientation = libelleOrientation;
	}

}