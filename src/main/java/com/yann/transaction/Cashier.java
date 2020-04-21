package com.yann.transaction;

import java.util.List;

public interface Cashier {

	public void checkout(String userName, List<String>bookNames);
}
