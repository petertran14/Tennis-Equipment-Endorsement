package test;

import tennis.Racket;
import tennis.DataBase;
import tennis.Player;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class TestDataBase {

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
	List<Racket> noRacket;
	
	Racket r1;
	Racket r2;
	Racket r3;
	
	// The actual Player-relevent instances
	List<Player> listOfPlayers;
	
	Map<String, Set<Racket>> emptyGroup;
	Map<String, Set<Racket>> filledGroup;
	
	DataBase file;
	
	Set<String> emptyRacketSet;
	Set<String> hasR1 = new HashSet<>();
	Set<String> hasR2 = new HashSet<>();
	Set<String> hasR3 = new HashSet<>();
	Set<String> hasR1R2 = new HashSet<>();
	Set<String> hasR1R3 = new HashSet<>();
	Set<String> hasR2R3 = new HashSet<>();
	Set<String> hasR1R2R3 = new HashSet<>();
	
	Set<Player> emptyPlayerSet;
	Set<Player> Fed = new HashSet<>();
	Set<Player> Djok = new HashSet<>();
	Set<Player> Waw = new HashSet<>();
	Set<Player> FedDjok = new HashSet<>();
	Set<Player> FedWaw = new HashSet<>();
	Set<Player> DjokWaw = new HashSet<>();
	Set<Player> FedDjokWaw = new HashSet<>();
	
	Set<Player> FedNad = new HashSet<>();
	
	@Before
	public void setUp() {
		
		wilson = "wilson";
		head = "head";
		yonex = "yonex";
		
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
		noRacket = new ArrayList<>();
		
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
		Player nadal = new Player("Rafael", "Nadal", 32, r1);
		
		listOfPlayers.add(p1);
		listOfPlayers.add(p2);
		listOfPlayers.add(p3);
		listOfPlayers.add(nadal);
		
		// Test DataBase Class
		emptyGroup = new HashMap<>();
		filledGroup = new HashMap<>();
		
		emptyRacketSet = new HashSet<>();
		emptyPlayerSet = new HashSet<>();
		
		hasR1.add(r1.getCompanyBrand());
		hasR2.add(r2.getCompanyBrand());
		hasR3.add(r3.getCompanyBrand());
		
		hasR1R2.add(r1.getCompanyBrand());
		hasR1R2.add(r2.getCompanyBrand());
		
		hasR1R3.add(r1.getCompanyBrand());
		hasR1R3.add(r3.getCompanyBrand());
		
		hasR2R3.add(r2.getCompanyBrand());
		hasR2R3.add(r3.getCompanyBrand());
		
		hasR1R2R3.add(r1.getCompanyBrand());
		hasR1R2R3.add(r2.getCompanyBrand());
		hasR1R2R3.add(r3.getCompanyBrand());
		
		Fed.add(p1);
		Djok.add(p2);
		Waw.add(p3);
		
		FedDjok.add(p1);
		FedDjok.add(p2);
		
		FedWaw.add(p1);
		FedWaw.add(p3);
		
		DjokWaw.add(p2);
		DjokWaw.add(p3);
		
		FedDjokWaw.add(p1);
		FedDjokWaw.add(p2);
		FedDjokWaw.add(p3);
		
		FedNad.add(p1);
		FedNad.add(nadal);
	}
	
	@Test
	public void testEmptyConstructor() {
		
		file = new DataBase(noRacket);
		
		assertEquals(emptyGroup, file.getMap());
	}
	
	@Test
	public void testFilledConstructor() {
		
		file = new DataBase(listOfRackets);
		
		assertEquals(hasR1R2R3, file.getAllKeys());
	}
	
	@Test
	public void testAddPlayerFromEmpty() {
		
		file = new DataBase(noRacket);
		
		// Adds Federer
		file.addPlayer(listOfPlayers.get(0));
		
		// Assume that a new key, "wilson" is created and Federer associated with that key.
		assertEquals(hasR1, file.getAllKeys());
		assertEquals(Fed, file.getSpecifiedValues(wilson));
	}
	
	@Test
	public void testAddPlayerFromFilled() {
		
		file = new DataBase(listOfRackets);
		
		// Adds Federer, Djokovic, and Wawrinka.
		file.addPlayer(listOfPlayers.get(0));
		file.addPlayer(listOfPlayers.get(1));
		file.addPlayer(listOfPlayers.get(2));
		
		assertEquals(hasR1R2R3, file.getAllKeys());
		assertEquals(Fed, file.getSpecifiedValues(wilson));
		assertEquals(Djok, file.getSpecifiedValues(head));
		assertEquals(Waw, file.getSpecifiedValues(yonex));
		assertEquals(FedDjokWaw, file.getAllValues());
	}
	
	@Test
	public void addToExistingValues() {
		
		file = new DataBase(listOfRackets);
		
		// Adds Federer, Djokovic, and Wawrinka.
		file.addPlayer(listOfPlayers.get(0));
		file.addPlayer(listOfPlayers.get(1));
		file.addPlayer(listOfPlayers.get(2));
		file.addPlayer(listOfPlayers.get(3));
		
		assertEquals(hasR1R2R3, file.getAllKeys());
		assertEquals(FedNad, file.getSpecifiedValues(wilson));
		assertEquals(Djok, file.getSpecifiedValues(head));
		assertEquals(Waw, file.getSpecifiedValues(yonex));
		assertEquals(hasR1R2R3, file.getAllKeys());
		
		FedDjokWaw.add(listOfPlayers.get(3));
		
		// Should now contain nadal
		assertEquals(FedDjokWaw, file.getAllValues());
	}
	
	@Test 
	public void testMostPopular() {
		
		file = new DataBase(listOfRackets);
		
		// Adds Federer, Djokovic, and Wawrinka.
		file.addPlayer(listOfPlayers.get(0));
		file.addPlayer(listOfPlayers.get(1));
		file.addPlayer(listOfPlayers.get(2));
		file.addPlayer(listOfPlayers.get(3));
		
		assertEquals(FedNad, file.mostPopular());
	}
}
