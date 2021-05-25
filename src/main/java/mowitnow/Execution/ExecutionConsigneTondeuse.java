package mowitnow.Execution;
import java.util.ArrayList;
import java.util.List;

import mowitnow.ExceptionTondeuse;
import mowitnow.enm.ConsigneTondeuse;
import mowitnow.entites.Pelouse;
import mowitnow.entites.PositionTondeuse;

public class ExecutionConsigneTondeuse {

	private Pelouse pelouse;
	private PositionTondeuse positionTondeuse;
	private List<ConsigneTondeuse> listeConsigne;
	
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	
	public void setPositionTondeuse(PositionTondeuse positionTondeuse) {
		this.positionTondeuse = positionTondeuse;
	} 
 
	public void setListeConsigne(
			List<ConsigneTondeuse> listeConsigne) {
		this.listeConsigne = listeConsigne;
		if(listeConsigne == null){
			listeConsigne = new ArrayList<ConsigneTondeuse>();
		}
	} 

	public void executerConsignes() throws ExceptionTondeuse{
		for(ConsigneTondeuse consigneTondeuse : listeConsigne){
			ExecutionConsigne.executerConsigne(positionTondeuse,
					consigneTondeuse, this.pelouse.getPositionLimite());
		}
	}

	public String toString(){
		return 	positionTondeuse.getCoordonneesTondeuse().getX() 
				+ " " 
				+ positionTondeuse.getCoordonneesTondeuse().getY()
				+ " " 
				+ positionTondeuse.getOrientationTondeuse().getCodeOrientation() ;
	}
}