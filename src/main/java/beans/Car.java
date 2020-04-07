package beans;

public class Car {
private String band;
private String city;
private double price;
public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


private int maxSpeed;


public Car(String band, String city, double price) {
	super();
	this.band = band;
	this.city = city;
	this.price = price;
}


public Car(String band, String city, int maxSpeed) {
	super();
	this.band = band;
	this.city = city;
	this.maxSpeed = maxSpeed;
}


@Override
public String toString() {
	return "Car [band=" + band + ", city=" + city + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
}

}
