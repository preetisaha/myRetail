package com.target.myRetail.domain;

public class ProductInfo {

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public static class Product {

		private Item item;
		
		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}
	}

	public static class Item {
		
		private ProductDescription product_description;

		public ProductDescription getProductDescription() {
			return product_description;
		}

		public void setProductDescription(ProductDescription product_description) {
			this.product_description = product_description;
		}
	}

	public static class ProductDescription {

		private String title;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}