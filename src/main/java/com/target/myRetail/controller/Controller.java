package com.target.myRetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.myRetail.domain.ProductDetail;
import com.target.myRetail.services.IProductDetailService;

@RestController
public class Controller {
	
	@Autowired
	private IProductDetailService productDetailService;
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ProductDetail getProduct(@PathVariable int id ){
		return productDetailService.getProductDetail(id);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public void updateDataBase(@PathVariable int id, @RequestBody ProductDetail productDetail ){
		productDetailService.saveProductPriceDetail(id, productDetail.getCurrentPrice().getValue(), productDetail.getCurrentPrice().getCurrencyCode());
	}
}
