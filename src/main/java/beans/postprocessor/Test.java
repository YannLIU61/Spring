package beans.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_cycle.xml");
		Car c= (Car)ac.getBean("car");
		System.out.println(c);

	}

}
