package beans.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
	private  Map<String, Car> cars =null;

	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("audi", new Car("Audi", 450000));
		cars.put("bmw", new Car("BMW", 500000));
	}
	public  Car getCar(String name) {
		return cars.get(name);
	}

}
