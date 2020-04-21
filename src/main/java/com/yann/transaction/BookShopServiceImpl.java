package com.yann.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	/*
	 * 1.使用propagation指定事物传播行为 2.isolation 隔离级别, 默认 READ_COMMITTED
	 * 3. 可以指定设置回滚与否 noRollbackFor
	 * 4. readonly 指定事物是否为只读
	 * 5.使用timeout 指定强制回滚前事物可以占用的时间
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	@Override
	public void purchase(String bookName, String userName) {
		int price = bookShopDao.getPrice(bookName);

		bookShopDao.updateStock(bookName);

		bookShopDao.updateAccount(userName, price);

	}
}
