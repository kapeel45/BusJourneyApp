package com.tutorial.deloitte.BusJourneyApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Journey {

	private String route;
	
	private Date dateandTime;

	@OneToMany
	@JoinColumn
	private Customer customer;

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Date getDateandTime() {
		return dateandTime;
	}

	public void setDateandTime(Date dateandTime) {
		this.dateandTime = dateandTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
