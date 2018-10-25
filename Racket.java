package tennis;

public class Racket extends Equipment {
	
	private String stringBed;
	private int stiffness;
	private int swingweight;
	
	public Racket(String companyBrand, String color, int price, String stringBed, int stiffness, int swingweight) throws IllegalArgumentException {
		
		if (!stringBed.equals("16x19") && !stringBed.equals("18x20")) {
			
			throw new IllegalArgumentException();
		}
		
		this.companyBrand = companyBrand;
		this.color = color; 
		this.price = price;
		this.stringBed = stringBed;
		this.stiffness = stiffness;
		this.swingweight = swingweight;
	}

	@Override
	public void setCompanyBrand(String companyBrand) {
	
		this.companyBrand = companyBrand;
	}

	@Override
	public void setColor(String color) {
		
		this.color = color;
	}

	@Override
	public void setPrice(int price) {
		
		this.price = price;
	}

	@Override
	public String getCompanyBrand() {
		
		return this.companyBrand.toLowerCase();
	}

	@Override
	public String getColor() {
		
		return this.color.toLowerCase();
	}

	@Override
	public int getPrice() {
		
		return this.price;
	}
	
	public String getStringBed() {
		
		return this.stringBed;
	}
	
	public int getSwingWeight() {
		
		return this.swingweight;
	}
	
	public int getStiffness() {
		
		return this.stiffness;
	}

	public boolean beginner() {
		
		if (this.stringBed.equals("16x19") && this.swingweight < 285 && this.stiffness < 66) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stiffness;
		result = prime * result + ((stringBed == null) ? 0 : stringBed.hashCode());
		result = prime * result + swingweight;
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
		Racket other = (Racket) obj;
		if (stiffness != other.stiffness)
			return false;
		if (stringBed == null) {
			if (other.stringBed != null)
				return false;
		} else if (!stringBed.equals(other.stringBed))
			return false;
		if (swingweight != other.swingweight)
			return false;
		return true;
	}
}
