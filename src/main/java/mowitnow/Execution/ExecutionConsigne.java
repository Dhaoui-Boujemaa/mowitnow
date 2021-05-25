package mowitnow.Execution;

import mowitnow.ExceptionTondeuse;
import mowitnow.enm.ConsigneTondeuse;
import mowitnow.enm.ExceptionMessage;
import mowitnow.enm.Orientation;
import mowitnow.entites.Coordonnees;
import mowitnow.entites.PositionTondeuse;

public  class ExecutionConsigne {

	private ExecutionConsigne(){

	}

	public static Coordonnees avancerTondeuse(PositionTondeuse positionTondeuse, Coordonnees positionLimite) throws ExceptionTondeuse{
		Coordonnees coordonneesSuivantes = null;
		int x, y;
		switch (positionTondeuse.getOrientationTondeuse()) {
		case NORTH:
			x = positionTondeuse.getCoordonneesTondeuse().getX();
			y = positionTondeuse.getCoordonneesTondeuse().getY() + 1;
			break;
		case EAST: 
			x = positionTondeuse.getCoordonneesTondeuse().getX() + 1;
			y = positionTondeuse.getCoordonneesTondeuse().getY();
			break;
		case SOUTH:
			x = positionTondeuse.getCoordonneesTondeuse().getX();
			y = positionTondeuse.getCoordonneesTondeuse().getY() - 1;
			break;
		case WEST:
			x = positionTondeuse.getCoordonneesTondeuse().getX() - 1;
			y = positionTondeuse.getCoordonneesTondeuse().getY();
			break;
		default:
			throw new ExceptionTondeuse(ExceptionMessage.POSITION_INCORRECTE.getMessage());
		}
		coordonneesSuivantes = new Coordonnees(x, y);

		
		if (coordonneesSuivantes != null
				&& positionLimite.isHorsPelouse(coordonneesSuivantes)) {
			return coordonneesSuivantes;
		} else {
			return positionTondeuse.getCoordonneesTondeuse();
		}
	}
	

	
	public static Orientation pivoterDroite(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.EAST;
				break;
			case EAST : 
				orientationSuivante =  Orientation.SOUTH;
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.WEST;
				break;
			case WEST : 
				orientationSuivante =  Orientation.NORTH;
				break;
			default : 
				throw new ExceptionTondeuse(ExceptionMessage.ORIENTATION_INCORRECTE.getMessage());
		}
		return orientationSuivante;		
	}
	

	public static Orientation pivoterGauche(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.WEST; 
				break;
			case EAST : 
				orientationSuivante =  Orientation.NORTH; 
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.EAST; 
				break;
			case WEST : 
				orientationSuivante =  Orientation.SOUTH; 
				break;
			default : 
				throw new ExceptionTondeuse(ExceptionMessage.ORIENTATION_INCORRECTE.getMessage());
		}
		return orientationSuivante;		 
	}

	public static void executerConsigne(PositionTondeuse positionTondeuse, ConsigneTondeuse consigne,Coordonnees positionLimite) throws ExceptionTondeuse{
		
		switch (consigne){
			case AVANCER : 
				positionTondeuse.setCoordonneesTondeuse(ExecutionConsigne.avancerTondeuse(positionTondeuse, positionLimite)); 
				break;
			case DROITE : 
				positionTondeuse.setOrientationTondeuse(ExecutionConsigne.pivoterDroite(positionTondeuse.getOrientationTondeuse())); 
				break;
			case GAUCHE : 
				positionTondeuse.setOrientationTondeuse(ExecutionConsigne.pivoterGauche(positionTondeuse.getOrientationTondeuse())); 
				break;
			default: throw new ExceptionTondeuse(ExceptionMessage.CONSIGNE_INCORRECTE.getMessage());
		}
	}
}