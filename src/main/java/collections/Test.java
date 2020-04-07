package collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = (Person) ac.getBean("person2");
		System.out.println(p.toString());
		Person p2 = (Person) ac.getBean("person3");
		System.out.println(p2.toString());

	}

}
