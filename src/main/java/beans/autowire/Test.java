package beans.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowireContext.xml");
		Person p1 = ac.getBean(Person.class);
		System.out.println(p1.toString());

	}

}
