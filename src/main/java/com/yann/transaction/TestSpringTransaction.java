package com.yann.transaction;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringTransaction {

	private ApplicationContext ac = null;
	private BookShopService bs = null;
	private Cashier cs = null;

	{
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		bs = ac.getBean(BookShopService.class);
		cs = ac.getBean(Cashier.class);
	}

	@Test
	public void testBookservice() {
//		bs.purchase("Java", "liuyan");
		cs.checkout("liuyan", Arrays.asList("Java","PHP"));
	}
}
