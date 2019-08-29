package com.tutorial.deloitte.BusJourneyApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String customerId;

	private String customerName;
	
	private String customerType;
	
	private String favouriteRoute;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
