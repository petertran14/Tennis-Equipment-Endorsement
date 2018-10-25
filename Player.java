package tennis;

public class Player {

	private String firstName;
	private String lastName;
	private int age;
	Racket stickOfChoice;
	
	public Player(String firstName, String lastName, int age, Racket racket) throws IllegalArgumentException {
		
		if (age < 1 || age > 90) {
			
			throw new IllegalArgumentException();
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.stickOfChoice = racket;
		this.age = age;
	}
	
	/**
	 * Changes the racket of the player.
	 * 
	 * @param racket
	 */
	public void changeRacket(Racket racket) {
		
		this.stickOfChoice = racket;
	}
	
	/**
	 * Returns the first name of the player
	 * 
	 * @return String
	 */
	public String getFirstName() {
		
		return this.firstName;
	}
	
	/**
	 * Returns the last name of the player
	 * 
	 * @return String
	 */
	public String getLastName() {
		
		return this.lastName;
	}
	
	/**
	 * Returns the age of the player.
	 * 
	 * @return int
	 */
	public int getAge() {
		
		return this.age;
	}
	
	/**
	 * Returns the racket of preference of the player.
	 * 
	 * @return Racket
	 */
	public Racket getRacket() {
		
		return this.stickOfChoice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((stickOfChoice == null) ? 0 : stickOfChoice.hashCode());
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
		Player other = (Player) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (stickOfChoice == null) {
			if (other.stickOfChoice != null)
				return false;
		} else if (!stickOfChoice.equals(other.stickOfChoice))
			return false;
		return true;
	}
}
