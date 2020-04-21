package com.yann.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringTransaction {

	private ApplicationContext ac = null;
	private BookShopService bs = null;

	{
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		bs = ac.getBean(BookShopService.class);
	}

	@Test
	public void testBookservice() {
		bs.purchase("Java", "liuyan");
	}
}
