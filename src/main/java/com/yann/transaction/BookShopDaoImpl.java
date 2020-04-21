package com.yann.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yann.exception.BookException;
import com.yann.exception.UserAccountException;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int getPrice(String bookName) {
		String sql = "SELECT price FROM BOOK WHERE bookname = ?";

		return jdbcTemplate.queryForObject(sql, Integer.class, bookName);
	}

	@Override
	public void updateStock(String bookName) {
//		Test stock
		String sql2 = "SELECT stock FROM BOOK WHERE bookname = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class,bookName);
		if(stock == 0) {
			throw new BookException("库存不足!!!");
		}
		String sql = "UPDATE BOOK SET stock = stock - 1 WHERE bookname = ?";
		jdbcTemplate.update(sql, bookName);

	}

	@Override
	public void updateAccount(String userName, int price) {
		String sql2 = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, userName);
		if(balance < price) {
			throw new UserAccountException("余额不足!!!");
		}
		String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql, price,userName);
	}


}
