package com.yann.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {
	
	@Autowired
	private BookShopService bs;
	@Transactional
	@Override
	public void checkout(String userName, List<String> bookNames) {
		for(String book : bookNames) {
			bs.purchase(book, userName);
		}

	}

}
