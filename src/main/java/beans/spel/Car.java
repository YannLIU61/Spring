package beans.spel;

public class Car {
	private String band;
	private double price;
	private double taille;
	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [band=" + band + ", price=" + price + ", taille=" + taille + "]";
	}


}
