package mowitnow.entites;
public class Pelouse {

	private Coordonnees positionLimite;
	public Pelouse(){
		
	}
	public Pelouse(Coordonnees pPositionMax) {
		this.positionLimite = pPositionMax;
	}

	
	public Coordonnees getPositionLimite() {
		return positionLimite;
	}
	public void setPositionLimite(Coordonnees positionLimite) {
		this.positionLimite = positionLimite;
	}
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		
		if (this == object)
			return true;
 
		if (getClass() != object.getClass())
			return false;
		Pelouse pelouse = (Pelouse) object;
		if (positionLimite == null) {
			if (pelouse.positionLimite != null)
				return false;
			} else if (!positionLimite.equals(pelouse.positionLimite))
				return false;
		return true;
	}
}