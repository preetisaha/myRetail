package com.target.myRetail.services;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myRetail.api.TargetApiClient;
import com.target.myRetail.dao.IPriceDAO;
import com.target.myRetail.domain.ProductDetail;
import com.target.myRetail.domain.ProductsPrice;
import com.target.myRetail.domain.ProductInfo;
import com.target.myRetail.exception.InternalServerErrorException;
import com.target.myRetail.exception.ResourceNotFoundException;

@Service
public class ProductDetailService implements IProductDetailService {

	@Autowired
	IPriceDAO priceDAO;

	@Autowired
	TargetApiClient apiClient;

	public ProductInfo getProductInfo(int id) {
		try {
			return apiClient.getProductInfo(id).execute().body();

		} catch (IOException e) {
			throw new InternalServerErrorException("Failed to get reponse from Target API", e);
		}
	}

	public ProductsPrice getProductPrice(int id) {
		return priceDAO.getPrice(id);
	}

	public ProductDetail getProductDetail(int id) {
		ProductInfo productInfo = getProductInfo(id);
		
		// Sending 404 if ID is not valid
		if(productInfo == null){
			throw new ResourceNotFoundException(" Invalid Product ID ");
		}
		
		ProductsPrice productPrice = getProductPrice(id);
		
		// if productPrice is null I sent only product Name
		if(productPrice == null){
			return new ProductDetail(id, productInfo.getProduct().getItem().getProductDescription().getTitle());
		}else{
			return new ProductDetail(id,
					productInfo.getProduct().getItem().getProductDescription().getTitle(), productPrice.getValue(),
					productPrice.getCurrencyCode());
		}
	}

	public void saveProductPriceDetail(int id, double value, String currencyCode) {
		priceDAO.savePrice(value, currencyCode, id);
	}
}
