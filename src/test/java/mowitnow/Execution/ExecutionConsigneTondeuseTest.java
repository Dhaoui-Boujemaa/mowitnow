package mowitnow.Execution;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import mowitnow.ExceptionTondeuse;
import mowitnow.Execution.ExecutionConsigne;
import mowitnow.Execution.ExecutionConsigneTondeuse;
import mowitnow.enm.ConsigneTondeuse;
import mowitnow.enm.Orientation;
import mowitnow.entites.Coordonnees;
import mowitnow.entites.Pelouse;
import mowitnow.entites.PositionTondeuse;

public class ExecutionConsigneTondeuseTest extends TestCase {
	Coordonnees positionLimite = new Coordonnees(5, 10); 

	@Test
	public void test_executer_consigne_vide() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);

		ExecutionConsigneTondeuse excuterConsigneTondeuse = new ExecutionConsigneTondeuse();
		excuterConsigneTondeuse.setPelouse(new Pelouse(positionLimite));
		excuterConsigneTondeuse.setPositionTondeuse(positionTondeuse);
		excuterConsigneTondeuse.setListeConsigne(new ArrayList<ConsigneTondeuse>());
		excuterConsigneTondeuse.executerConsignes();;
		assertEquals(excuterConsigneTondeuse.toString(), "0 0 N");
	} 

	@Test
	public void test_executer_consigne_unitaire() throws ExceptionTondeuse {
		List<ConsigneTondeuse> listConsigne = new ArrayList<ConsigneTondeuse>();
		listConsigne.add(ConsigneTondeuse.AVANCER);
		int x = 1;
		int y = 1;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		ExecutionConsigneTondeuse excuterConsigneTondeuse = new ExecutionConsigneTondeuse();
		excuterConsigneTondeuse.setPelouse(new Pelouse(positionLimite));
		excuterConsigneTondeuse.setPositionTondeuse(positionTondeuse); 
		excuterConsigneTondeuse.setListeConsigne(listConsigne);
		excuterConsigneTondeuse.executerConsignes();
		assertEquals(excuterConsigneTondeuse.toString(), "1 2 N");
	}

	@Test
	public void test_executer_consigne_plusieurs() throws ExceptionTondeuse {
		List<ConsigneTondeuse> listConsigne = new ArrayList<ConsigneTondeuse>();
		listConsigne.add(ConsigneTondeuse.GAUCHE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.GAUCHE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		int x = 3;
		int y = 2;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		ExecutionConsigneTondeuse excuterConsigneTondeuse = new ExecutionConsigneTondeuse();
		excuterConsigneTondeuse.setPelouse(new Pelouse(positionLimite));
		excuterConsigneTondeuse.setPositionTondeuse(positionTondeuse);
		excuterConsigneTondeuse.setListeConsigne(listConsigne);
		excuterConsigneTondeuse.executerConsignes();
		assertEquals(excuterConsigneTondeuse.toString(), "2 1 S");
	}

	@Test
	public void test_executer_consigne_1() throws ExceptionTondeuse {
		List<ConsigneTondeuse> listConsigne = new ArrayList<ConsigneTondeuse>();
		listConsigne.add(ConsigneTondeuse.GAUCHE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.GAUCHE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.GAUCHE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.GAUCHE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		int x = 1;
		int y = 2;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		ExecutionConsigneTondeuse excuterConsigneTondeuse = new ExecutionConsigneTondeuse();
		excuterConsigneTondeuse.setPelouse(new Pelouse(positionLimite));
		excuterConsigneTondeuse.setPositionTondeuse(positionTondeuse);
		excuterConsigneTondeuse.setListeConsigne(listConsigne);
		excuterConsigneTondeuse.executerConsignes(); 
		assertEquals(excuterConsigneTondeuse.toString(), "1 3 N");
	}

	@Test
	public void test_executer_consigne_2() throws ExceptionTondeuse {
		List<ConsigneTondeuse> listConsigne = new ArrayList<ConsigneTondeuse>();
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.DROITE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.DROITE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		listConsigne.add(ConsigneTondeuse.DROITE);
		listConsigne.add(ConsigneTondeuse.DROITE);
		listConsigne.add(ConsigneTondeuse.AVANCER);
		int x = 3;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.EAST);
		ExecutionConsigneTondeuse excuterConsigneTondeuse = new ExecutionConsigneTondeuse();
		excuterConsigneTondeuse.setPelouse(new Pelouse(positionLimite));
		excuterConsigneTondeuse.setPositionTondeuse(positionTondeuse);
		excuterConsigneTondeuse.setListeConsigne(listConsigne); 
		excuterConsigneTondeuse.executerConsignes();
		assertEquals(excuterConsigneTondeuse.toString(), "5 1 E");
	}

	@Test
	public void test_coordonnees_north_consigne_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.AVANCER, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y + 1));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.NORTH);
	}

	@Test
	public void test_coordonnees_East_consigne_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.EAST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.AVANCER, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x + 1, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.EAST);
	}

	@Test
	public void test_coordonnees_South_consigne_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.SOUTH);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.AVANCER, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y - 1));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.SOUTH);
	}

	@Test
	public void test_coordonnees_West_consigne_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.WEST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.AVANCER, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x - 1, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.WEST);
	}

	@Test
	public void test_coordonnees_West_consigne_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.WEST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.GAUCHE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.SOUTH);
	}

	@Test
	public void test_coordonnees_east_consigne_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.EAST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.GAUCHE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.NORTH);
	}

	@Test
	public void test_coordonnees_west_consigne_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.WEST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.GAUCHE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.SOUTH);
	}

	@Test
	public void test_coordonnees_south_consigne_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.SOUTH);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.GAUCHE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.EAST);
	}

	@Test
	public void test_coordonnees_north_consigne_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.DROITE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.EAST);
	}

	@Test
	public void test_coordonnees_east_consigne_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.EAST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.DROITE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.SOUTH);
	}

	@Test
	public void test_coordonnees_west_consigne_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.WEST);
		ExecutionConsigne.executerConsigne(positionTondeuse, ConsigneTondeuse.DROITE, positionLimite);
		assertEquals(positionTondeuse.getCoordonneesTondeuse(), new Coordonnees(x, y));
		assertEquals(positionTondeuse.getOrientationTondeuse(), Orientation.NORTH);
	}

}