package beans.properties;

import java.sql.SQLException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Test {

	public static void main(String[] args) throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_properties.xml");
		Dao ds= (Dao) ac.getBean("dataSource");
		System.out.println(ds.toString());

	}

}
