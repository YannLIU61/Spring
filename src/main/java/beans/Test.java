package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		创建IOC容齐
//		ApplicationContext 是 BeanFactory 的子接口
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld h1 = (HelloWorld) ac.getBean("helloWorld");
		h1.hello();

		Car c1 = (Car) ac.getBean("car");
		Car c2 = (Car) ac.getBean("car2");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		Person p1 = ac.getBean(Person.class);
		System.out.println(p1.toString());
	}

}
