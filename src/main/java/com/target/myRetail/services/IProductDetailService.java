package com.target.myRetail.services;

import com.target.myRetail.domain.ProductDetail;
import com.target.myRetail.domain.ProductInfo;
import com.target.myRetail.domain.ProductsPrice;

public interface IProductDetailService {

	public ProductInfo getProductInfo(int id);
	public ProductsPrice getProductPrice(int id);
	public ProductDetail getProductDetail(int id);
	public void saveProductPriceDetail(int id, double value, String currency_code);
}
