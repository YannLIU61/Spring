package com.yann.transaction;

public interface BookShopDao {

	public int getPrice(String bookName);

	public void updateStock(String bookName);

	public void updateAccount(String userName, int price);
}
