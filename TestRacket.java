package test;

import tennis.Racket;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

public class TestRacket {

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
	}
			
	@Test
	public void testCorrectBrand() {
		
		assertEquals("wilson", listOfRackets.get(0).getCompanyBrand());
		assertEquals("head", listOfRackets.get(1).getCompanyBrand());
		assertEquals("yonex", listOfRackets.get(2).getCompanyBrand());
	}
	
	@Test 
	public void testCorrectColor() {
		
		assertEquals("red", listOfRackets.get(0).getColor());
		assertEquals("blue", listOfRackets.get(1).getColor());
		assertEquals("orange", listOfRackets.get(2).getColor());
	}
	
	@Test
	public void testCorrectPrice() {
		
		assertEquals(249, listOfRackets.get(0).getPrice());
		assertEquals(219, listOfRackets.get(1).getPrice());
		assertEquals(199, listOfRackets.get(2).getPrice());
	}
	
	@Test
	public void testCorrectStringPattern() {
		
		assertEquals("16x19", listOfRackets.get(0).getStringBed());
		assertEquals("18x20", listOfRackets.get(1).getStringBed());
		assertEquals("16x19", listOfRackets.get(2).getStringBed());
	}
	
	@Test 
	public void testCorrectStiffness() {
		
		assertEquals(65, listOfRackets.get(0).getStiffness());
		assertEquals(65, listOfRackets.get(1).getStiffness());
		assertEquals(75, listOfRackets.get(2).getStiffness());
	}
	
	@Test 
	public void testCorrectSwingWeight() {
		
		assertEquals(330, listOfRackets.get(0).getSwingWeight());
		assertEquals(280, listOfRackets.get(1).getSwingWeight());
		assertEquals(330, listOfRackets.get(2).getSwingWeight());
	}
	
	@Test
	public void testBeginnerRacket() {
		
		assertFalse(listOfRackets.get(0).beginner());
		assertFalse(listOfRackets.get(1).beginner());
		assertFalse(listOfRackets.get(2).beginner());
	}
}
