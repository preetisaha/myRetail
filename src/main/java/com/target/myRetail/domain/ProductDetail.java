package com.target.myRetail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetail {

	private int id;
	private String title;
	
	@JsonProperty("current_price")
	private CurrentPrice currentPrice;

	public ProductDetail() {

	}
	
	public ProductDetail(int id, String title){
		this.id = id;
		this.title = title;
	}

	public ProductDetail(int id, String title, double value, String currencyCode) {
		this.id = id;
		this.title = title;
		this.currentPrice = new CurrentPrice(value, currencyCode);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CurrentPrice getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(CurrentPrice currentPrice) {
		this.currentPrice = currentPrice;
	}

	public static class CurrentPrice {

		private double value;
		
		@JsonProperty("currency_code")
		private String currencyCode;

		public CurrentPrice() {

		}

		public CurrentPrice(double value, String currencyCode) {
			this.value = value;
			this.currencyCode = currencyCode;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public String getCurrencyCode() {
			return currencyCode;
		}

		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
	}

	public static class ProductTitle {

		private String name;

		public ProductTitle(String name) {
			this.name = name;
		}

		public String getTitle() {
			return name;
		}

		public void setTitle(String name) {
			this.name = name;
		}
	}

}
