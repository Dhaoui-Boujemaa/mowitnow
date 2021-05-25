package mowitnow.Execution;

import org.junit.Test;

import junit.framework.TestCase;
import mowitnow.ExceptionTondeuse;
import mowitnow.Execution.ExecutionConsigne;
import mowitnow.enm.ConsigneTondeuse;
import mowitnow.enm.Orientation;
import mowitnow.entites.Coordonnees;
import mowitnow.entites.PositionTondeuse;


public class ExecutionConsigneTest extends TestCase {

	@Test
	public void test_coordonnees_south_Tourner_Droite() throws ExceptionTondeuse {
		Coordonnees positionLimite = new Coordonnees(5, 5);
		int x = 2;
		int y = 3; 
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.SOUTH);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.DROITE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(),new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(),Orientation.WEST);
	}
	
	
	@Test
	public void test_pivoter_a_droite() throws ExceptionTondeuse{
		
		Orientation nextOrientation = ExecutionConsigne.pivoterDroite(Orientation.EAST);
		assertEquals(nextOrientation,Orientation.SOUTH);
		
		nextOrientation = ExecutionConsigne.pivoterDroite(Orientation.WEST);
		assertEquals(nextOrientation,Orientation.NORTH); 
		
		nextOrientation = ExecutionConsigne.pivoterDroite(Orientation.NORTH);
		assertEquals(nextOrientation,Orientation.EAST);
		
		nextOrientation = ExecutionConsigne.pivoterDroite(Orientation.SOUTH);
		assertEquals(nextOrientation,Orientation.WEST);
	}
	 
	@Test
	public void test_pivoter_a_gauche() throws ExceptionTondeuse{
		Orientation nextOrientation = ExecutionConsigne.pivoterGauche(Orientation.EAST);
		assertEquals(nextOrientation,Orientation.NORTH);
		
		nextOrientation = ExecutionConsigne.pivoterGauche(Orientation.WEST);
		assertEquals(nextOrientation,Orientation.SOUTH);
		
		nextOrientation = ExecutionConsigne.pivoterGauche(Orientation.NORTH);
		assertEquals(nextOrientation,Orientation.WEST);
		
		nextOrientation = ExecutionConsigne.pivoterGauche(Orientation.SOUTH);
		assertEquals(nextOrientation,Orientation.EAST);
	}

}
