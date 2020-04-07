package beans.factory;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
	private String band;

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Car(band,600000);
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

}
