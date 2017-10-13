package com.target.myRetail.dao;

import com.target.myRetail.domain.ProductsPrice;

public interface IPriceDAO {

	public ProductsPrice getPrice(int id);
	public void savePrice(double value, String currency_code, int id);
}
