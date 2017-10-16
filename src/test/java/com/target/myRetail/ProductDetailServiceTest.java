package com.target.myRetail;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.target.myRetail.api.TargetApiClient;
import com.target.myRetail.dao.IPriceDAO;
import com.target.myRetail.domain.ProductDetail;
import com.target.myRetail.domain.ProductInfo;
import com.target.myRetail.domain.ProductInfo.Item;
import com.target.myRetail.domain.ProductInfo.Product;
import com.target.myRetail.domain.ProductInfo.ProductDescription;
import com.target.myRetail.exception.InternalServerErrorException;
import com.target.myRetail.exception.ResourceNotFoundException;
import com.target.myRetail.services.ProductDetailService;

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailServiceTest {
	
	@Mock
	IPriceDAO priceDAO;

	@Mock
	TargetApiClient apiClient;
	
	@InjectMocks
	ProductDetailService productDetailService;
	
	@Test(expected = InternalServerErrorException.class)
	public void getProductInfoTest(){
		int id = 10;
		when(apiClient.getProductInfo(id)).thenThrow(IOException.class);
		
		productDetailService.getProductInfo(id);	
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void productDetailTest(){
		int id = 10;
		ProductDetailService spyProductDetailService = spy(productDetailService);
		doReturn(null).when(spyProductDetailService).getProductInfo(id);
		
		spyProductDetailService.getProductDetail(id);
	}

	@Test
	public void productDetailTestCaseSecond(){
		int id = 10;
		String title = "hello world";
		ProductDetailService spyProductDetailService = spy(productDetailService);
		
		ProductInfo productInfo = new ProductInfo();
		Product product = new Product();
		Item item = new Item();
		ProductDescription productDescription = new ProductDescription();
		
		productDescription.setTitle(title);
		item.setProductDescription(productDescription);
		product.setItem(item);
		productInfo.setProduct(product);
		
		doReturn(productInfo).when(spyProductDetailService).getProductInfo(id);
		doReturn(null).when(spyProductDetailService).getProductPrice(id);
		
		ProductDetail actualProductDetail = spyProductDetailService.getProductDetail(id);	
		
		ProductDetail expectedProductDetail = new ProductDetail(id, title);
		
		assertTrue( actualProductDetail.equals(expectedProductDetail));
	}
}






