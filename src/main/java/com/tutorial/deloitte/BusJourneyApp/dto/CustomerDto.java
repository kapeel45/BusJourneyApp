package com.tutorial.deloitte.BusJourneyApp.dto;

public class CustomerDto {

	private String customerName;
	
	private String customerId;
	
	private String customerType;
	
	private String favouriteRoute;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getFavouriteRoute() {
		return favouriteRoute;
	}

	public void setFavouriteRoute(String favouriteRoute) {
		this.favouriteRoute = favouriteRoute;
	}
	
}
