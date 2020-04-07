package beans.factory;

import java.util.Hashtable;

public class StaticCarFactory {
	private static Hashtable<String, Car> cars = new Hashtable<String, Car>();
	static {
		cars.put("audi", new Car("Audi", 450000));
		cars.put("bmw", new Car("BMW", 500000));
	}

	public static Car getCar(String name) {
		return cars.get(name);
	}

}
