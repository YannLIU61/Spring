package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Caculator ca = (Caculator) ac.getBean(Caculator.class);
		System.out.println(ca.add(2, 3));
		System.out.println(ca.div(2, 0));

	}

}
