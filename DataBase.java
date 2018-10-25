package tennis;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DataBase {

	// Have keys represent racket brand, and have values be players who endorse the racket brand
	private Map<String, Set<Player>> paintBrush;
	
	public DataBase(List<Racket> sticks) {
		
		this.paintBrush = new HashMap<>();
		
		// Call add method to create a key out of the rackets
		for (int i = 0; i < sticks.size(); i++) {
			
			this.paintBrush.put(sticks.get(i).getCompanyBrand(), new HashSet<>());
		}
	}
	
	/**
	 * Returns a copy of the map.
	 * 
	 * @return copy
	 */
	public Map<String, Set<Player>> getMap() {
		
		Map<String, Set<Player>> copy = new HashMap<>(this.paintBrush);
		
		return copy;
	}
	
	/**
	 * Adds a player to the set of players that is associated with the brand of the racket they endorse.
	 * 
	 * If the key is new, create a new key.
	 *
	 * @param player
	 */
	public void addPlayer(Player player) {
		
		// Get the key to associate players with
		String key = player.getRacket().getCompanyBrand();
		
		//if the key is not found
		if (!this.paintBrush.containsKey(key)) {
			
			//add the player to a set
			Set<Player> setOfPlayers = new HashSet<>();
			setOfPlayers.add(player);
			
			//instantiate the key and add the set that contains the player
			this.paintBrush.put(key, setOfPlayers);
		}
		
		//use a set to point to the set associated with the key
		Set<Player> setOfPlayers = this.paintBrush.get(key);
		
		//add the player to the set associated with the key
		setOfPlayers.add(player);
	}
	
	/**
	 * Returns a set of players who use the most popular racket.
	 * 
	 * @return most
	 */
	public Set<Player> mostPopular() {
		
		Set<Player> most = new HashSet<>();
		
		// If the map is empty
		if (this.paintBrush.isEmpty()) {
			
			return most;
		}
	
		int longest = -1;
		
		for (String key : this.paintBrush.keySet()) {
			
			if(this.paintBrush.get(key).size() > longest) {
				
				longest = this.paintBrush.get(key).size();
				most = this.paintBrush.get(key);
			}
		}
		
		return most;
	}
	
	/**
	 * Returns the key of the map. In our case, the key is the company brand of the racket.
	 * 
	 * @return Set<String>
	 */
	public Set<String> getAllKeys() {
		
		Set<String> keys = new HashSet<>();
		
		// The map is empty
		if (this.paintBrush.isEmpty()) {
			
			return keys;
		}
		
		// Iterate through our set of keys
		for (String key : this.paintBrush.keySet()) {
			
			// Add each key in the map to a set of keys
			keys.add(key);
		}
		
		// Return the set of keys held by our local variable
		return keys;
	}
	
	/**
	 * Returns all players that are in our database.
	 * 
	 * The players are stored in a set so that their names do not repeat.
	 * 
	 * @return Set<Player>
	 */
	public Set<Player> getAllValues() {
		
		Set<Player> pawns = new HashSet<>();
		Set<Player> ourPawns = new HashSet<>();
		
		// If the map is empty
		if (this.paintBrush.isEmpty()) {
			
			return ourPawns;
		}
		
		// Iterate through the map, getting each key(String)
		for (String key : this.paintBrush.keySet()) {
			
			// Get the Set<Player> that is associated with the key
			pawns = this.paintBrush.get(key);
			
			// Get each player that is in the Set<Player>
			for (Player item : pawns) {
				
				// Add the player to our collection
				ourPawns.add(item);
			}
		}
		
		// Return the collection of players
		return ourPawns;
	}	
	
	/**
	 * Returns the set of players that endorse a particular brand.
	 * 
	 * The set of players returned are merely copies of the map.
	 * 
	 * @param String, the name of the brand of the racket
	 * @return Set<Player>
	 */
	public Set<Player> getSpecifiedValues(String brand) {
		
		Set<Player> pawns = new HashSet<>();
		
		// This loop will only be entered if the map isn't empty.
		for (String key : this.paintBrush.keySet()) {
			
			if (key.equals(brand)) {
				
				pawns = this.paintBrush.get(key);
				
				return pawns;
			}
		}
		
		// If the map is empty or the brand name doesn't exist.
		return pawns;
	}
	
	/**
	 * Removes a player from the map.
	 * 
	 * @param other
	 */
	public void removePlayer(Player other) {
		
		// Get the racket brand of the player
		String brand = other.getRacket().getCompanyBrand();
		
		// If the brand does not exist in our map, then he/she is not in our map, else...
		if (this.paintBrush.containsKey(brand)) {
			
			// Does the player exist in our values, if so
			if (this.paintBrush.get(brand).contains(other)) {
				
				// Remove the player
				this.paintBrush.get(brand).remove(other);
			}
		}
	}
	
	/**
	 * Removes the brand of rackets and all of the associate players who use it, from this map.
	 * 
	 * @param brand
	 */
	public void removeBrand(String brand) {
		
		// Does our map have the brand
		if (this.paintBrush.containsKey(brand)) {
			
			// Clear the set that was previously occupied with this key
			this.paintBrush.get(brand).clear();
			
			// Remove the key from the map
			this.paintBrush.remove(brand);
		}
	}
	
	/**
	 * Returns a string representation of our map.
	 * 
	 * @return String
	 */
	public String toString() {
		
		return this.paintBrush.toString();
	}
	
	/**
	 * Displays the information on the map
	 * 
	 */
	public void display() {
		
		// If the map is Empty
		if (this.paintBrush.isEmpty()) {
			
			System.out.println(this.paintBrush.toString());
		}
		
		else {
			
			int outer = 0;
			int inner = 0;
			Set<Player> set = new HashSet<>();
			
			System.out.print("{");
			
			for (String key : this.paintBrush.keySet()) {
				
				System.out.print(key + "=[");
				inner = 0;
				
				set = this.paintBrush.get(key);
				
				for (Player p : set) {
					
					System.out.print(p.getLastName());
					
					if (set.size() - 1 != inner) {
					
						System.out.print(", ");
					}
					
					inner++;
				}
				
				System.out.print("]");
				
				if (this.paintBrush.size() - 1 != outer) {
					
					System.out.print(", ");
				}
				
				outer++;
			}
			
			System.out.print("}");
		}
	}
	
	public String accessLastName(Player p) {
		
		return p.getLastName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paintBrush == null) ? 0 : paintBrush.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataBase other = (DataBase) obj;
		if (paintBrush == null) {
			if (other.paintBrush != null)
				return false;
		} else if (!paintBrush.equals(other.paintBrush))
			return false;
		return true;
	}
}
