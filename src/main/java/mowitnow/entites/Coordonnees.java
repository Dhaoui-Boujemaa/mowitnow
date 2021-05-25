package mowitnow.entites;

public class Coordonnees {
	
	private int x;
	private int y;
	
	public Coordonnees(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de celles 
	 * de la pelouse
	 * @param coordonnees 
	 * @return true si les coordonnées de la tondeuse sont à l'intérieur de la pelouse
	 */
	public boolean isHorsPelouse(Coordonnees coordonnees){
		return coordonnees.getX() >= 0 
				&& coordonnees.getY() >= 0
				&& coordonnees.getX() <= this.x
				&& coordonnees.getY() <= this.y;
	}
	
	public int getX() {
		return x;
	} 
	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		 
		if (this == object)
			return true;

		if (getClass() != object.getClass())
			return false;
		Coordonnees other = (Coordonnees) object;
		if (x != other.x || y != other.y)
			return false;
		
		return true;
	}
}