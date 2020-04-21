package com.yann.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	
	@Transactional
	@Override
	public void purchase(String bookName, String userName) {
		int price = bookShopDao.getPrice(bookName);
		
		bookShopDao.updateStock(bookName);
		
		bookShopDao.updateAccount(userName, price);

	}

}
