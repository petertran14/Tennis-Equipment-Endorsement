package tennis;

public abstract class Equipment {

	protected String companyBrand;
	protected String color;
	protected int price;
	
	abstract void setCompanyBrand(String companyBrand);
	abstract void setColor(String color);
	abstract void setPrice(int price);
	
	abstract String getCompanyBrand();
	abstract String getColor();
	abstract int getPrice();
}
