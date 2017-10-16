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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
			long temp;
			temp = Double.doubleToLongBits(value);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CurrentPrice other = (CurrentPrice) obj;
			if (currencyCode == null) {
				if (other.currencyCode != null)
					return false;
			} else if (!currencyCode.equals(other.currencyCode))
				return false;
			if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
				return false;
			return true;
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProductTitle other = (ProductTitle) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentPrice == null) ? 0 : currentPrice.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetail other = (ProductDetail) obj;
		if (currentPrice == null) {
			if (other.currentPrice != null)
				return false;
		} else if (!currentPrice.equals(other.currentPrice))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
}
