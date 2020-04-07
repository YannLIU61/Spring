package beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_factory.xml");
		Car c= (Car)ac.getBean("car");
		System.out.println(c);
		Car c2= (Car)ac.getBean("car2");
		System.out.println(c2);
		Car c3= (Car)ac.getBean("car3");
		System.out.println(c3);
	}

}
