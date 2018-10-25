package test;

import tennis.Racket;
import tennis.Player;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class TestPlayer {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(10);
	
	String wilson;
	String head;
	String yonex;
	
	String red;
	String blue;
	String orange;
	
	int normal;
	int notSoCheap;
	int ripOff;
	
	String sixteenbynineteen;
	String eighteenbytwenty;
	
	int stiff;
	int flexible;
	
	int light;
	int heavy;
	
	List<Racket> listOfRackets;
	
	Racket r1;
	Racket r2;
	Racket r3;
	
	// The actual Player-relevent instances
	List<Player> listOfPlayers;
	
	@Before
	public void setUp() {
		
		wilson = "Wilson";
		head = "Head";
		yonex = "Yonex";
		
		red = "Red";
		blue = "Blue";
		orange = "Orange";
		
		normal = 199;
		notSoCheap = 219;
		ripOff = 249; 
		
		sixteenbynineteen = "16x19";
		eighteenbytwenty = "18x20";
		
		stiff = 75;
		flexible = 65;
		
		light = 280;
		heavy = 330;
		
		listOfRackets = new ArrayList<>();
		
		r1 = new Racket(wilson, red, ripOff, sixteenbynineteen, flexible, heavy);
		r2 = new Racket(head, blue, notSoCheap, eighteenbytwenty, flexible, light);
		r3 = new Racket(yonex, orange, normal, sixteenbynineteen, stiff, heavy);
		
		listOfRackets.add(r1);
		listOfRackets.add(r2);
		listOfRackets.add(r3);
		
		// Here it is
		listOfPlayers = new ArrayList<>();
		
		Player p1 = new Player("Roger", "Federer", 37, r1);
		Player p2 = new Player("Novak", "Djokovic", 31, r2);
		Player p3 = new Player("Stan", "Wawrinka", 33, r3);
		
		listOfPlayers.add(p1);
		listOfPlayers.add(p2);
		listOfPlayers.add(p3);
	}
	
	@Test
	public void testCorrectFirstName() {
		
		assertEquals("Roger", listOfPlayers.get(0).getFirstName());
		assertEquals("Novak", listOfPlayers.get(1).getFirstName());
		assertEquals("Stan", listOfPlayers.get(2).getFirstName());
	}
	
	@Test
	public void testCorrectLastName() {
		
		assertEquals("Federer", listOfPlayers.get(0).getLastName());
		assertEquals("Djokovic", listOfPlayers.get(1).getLastName());
		assertEquals("Wawrinka", listOfPlayers.get(2).getLastName());
	}
	
	@Test
	public void testCorrectAge() {
		
		assertEquals(37, listOfPlayers.get(0).getAge());
		assertEquals(31, listOfPlayers.get(1).getAge());
		assertEquals(33, listOfPlayers.get(2).getAge());
	}
	
	@Test
	public void testCorrectRacket() {
		
		assertEquals(r1, listOfPlayers.get(0).getRacket());
		assertEquals(r2, listOfPlayers.get(1).getRacket());
		assertEquals(r3, listOfPlayers.get(2).getRacket());
	}
	
	@Test 
	public void testChangeRacket() {
		
		//Federer now uses r2
		listOfPlayers.get(0).changeRacket(r2);
		
		//Djokovic now uses r3
		listOfPlayers.get(1).changeRacket(r3);
		
		//Wawrinka now uses r1
		listOfPlayers.get(2).changeRacket(r1);
		
		assertEquals(r2, listOfPlayers.get(0).getRacket());
		assertEquals(r3, listOfPlayers.get(1).getRacket());
		assertEquals(r1, listOfPlayers.get(2).getRacket());
	}
}
