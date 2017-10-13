package com.target.myRetail.domain;

public class ProductsPrice {

	private int id;
	private double value;
	private String currencyCode;
	
	public ProductsPrice(int id, double value, String currencyCode) {
	
		this.id = id;
		this.value = value;
		this.currencyCode = currencyCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
