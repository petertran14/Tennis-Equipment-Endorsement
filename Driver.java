package test;

import tennis.Equipment;
import tennis.Player;
import tennis.Racket;
import tennis.DataBase;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		
		String wilson = "wilson";
		String head = "head";
		String yonex = "yonex";
		
		String red = "Red";
		String blue = "Blue";
		String orange = "Orange";
		
		int normal = 199;
		int notSoCheap = 219;
		int ripOff = 249; 
		
		String sixteenbynineteen = "16x19";
		String eighteenbytwenty = "18x20";
		
		int stiff = 75;
		int flexible = 65;
		
		int light = 280;
		int heavy = 330;
	
		Racket r1 = new Racket(wilson, red, ripOff, sixteenbynineteen, flexible, heavy);
		Racket r2 = new Racket(head, blue, notSoCheap, eighteenbytwenty, flexible, light);
		Racket r3 = new Racket(yonex, orange, normal, sixteenbynineteen, stiff, heavy);
		
		List<Racket> listOfRackets = new ArrayList<>();
		listOfRackets.add(r1);
		listOfRackets.add(r2);
		listOfRackets.add(r3);
		
		Player p1 = new Player("Roger", "Federer", 37, r1);
		Player p2 = new Player("Novak", "Djokovic", 31, r2);
		Player p3 = new Player("Stan", "Wawrinka", 33, r3);
		Player p4 = new Player("Rafael", "Nadal", 32, r1);
		
		List<Player> listOfPlayers = new ArrayList<>();
		listOfPlayers.add(p1);
		listOfPlayers.add(p2);
		listOfPlayers.add(p3);
		listOfPlayers.add(p4);
		
		DataBase obj = new DataBase(listOfRackets);
		
		System.out.println("Empty Map\n" + obj + "\n");
		
		obj.addPlayer(p1);
		obj.addPlayer(p2);
		obj.addPlayer(p3);
		obj.addPlayer(p4);
		
		System.out.println("Filled Map");
		
		obj.display();
		
		// New racket
		Racket r4 = new Racket("dunlop", "black", normal, sixteenbynineteen, stiff, heavy);
		
		// New players
		Player p5 = new Player("James", "Blake", 38, r1);
		Player p6 = new Player("Andy", "Roddick", 35, r2);
		Player p7 = new Player("Andy", "Murray", 31, r2);
		Player p8 = new Player("Kei", "Nishikori", 28, r2);
		Player p9 = new Player("John", "McEnroe", 59, r4);
		
		obj.addPlayer(p5);
		obj.addPlayer(p6);
		obj.addPlayer(p7);
		obj.addPlayer(p8);
		obj.addPlayer(p9);
		
		System.out.println("\n\nMore Filled Map");
		
		obj.display();
		
		System.out.println("\n\nGetting all Players of Wilson: ");
		
		Set<Player> s = obj.getSpecifiedValues("wilson");
		
		for (Player p : s) {
			
			System.out.print(p.getLastName() + " ");
		}
		
		System.out.println("\n\nGetting all Players: ");
		
		s = obj.getAllValues();
		
		for (Player p : s) {
			
			System.out.print(p.getLastName() + " ");
		}
		
		System.out.println("\n\nGetting all Brands: ");
		
		Set<String> key = obj.getAllKeys();
		
		for (String item : key) {
			
			System.out.print(item + " ");
		}
		
		System.out.println("\n\nList of Players who endorse most Popular Brand: ");
		
		s = obj.mostPopular();
		
		for (Player p : s) {
			
			System.out.print(p.getLastName() + " ");
		}
		
		System.out.println("\n\nRemoving Roddick: ");
		
		obj.removePlayer(p6);
		
		obj.display();
		
		System.out.println("\n\nRemoving Roddick again: ");
		
		obj.removePlayer(p6);
		
		obj.display();
		
		System.out.println("\n\nRemoving Dunlop: ");
		
		obj.removeBrand("dunlop");
		
		obj.display();
		
		System.out.println("\n\nRemoving Dunlop again: ");
		
		obj.removeBrand("dunlop");
		
		obj.display();

	}
}
