package com.tutorial.deloitte.BusJourneyApp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.deloitte.BusJourneyApp.dto.CustomerDto;
import com.tutorial.deloitte.BusJourneyApp.dto.JourneyDto;
import com.tutorial.deloitte.BusJourneyApp.entity.Customer;
import com.tutorial.deloitte.BusJourneyApp.entity.Journey;
import com.tutorial.deloitte.BusJourneyApp.repository.CustomerRepo;
import com.tutorial.deloitte.BusJourneyApp.repository.JourneyRepo;

@Service
public class CustomerService {
	
	@Autowired
	JourneyRepo journeyDao;

	@Autowired
	CustomerRepo customerDao;
	
	
	public Customer registerCustomer(CustomerDto custDto) {
		
		Customer cust = new Customer();
		if(custDto != null) {		
				cust.setCustomerId(custDto.getCustomerId());
				cust.setCustomerName(custDto.getCustomerName());
				cust.setCustomerType(custDto.getCustomerType());
				cust.setFavouriteRoute(custDto.getFavouriteRoute());
		}
		
		return cust;
	}
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public double addJourney(JourneyDto journeyDto) {
		
		double price = 80;
		double disc = 0.0;
		
		
		Optional<Customer> customer = customerDao.findById(Long.parseLong(journeyDto.getCustomerId()));
		
		Journey journeyO = new Journey();
		
		journeyO.setCustomer(customer.get());
		Date d1 = df.parse(journeyDto.getDateNTime());
		
		journeyO.setDateandTime(d1);
		journeyO.setRoute(journeyDto.getRoutename());
		
		Journey journeyObj= journeyDao.save(journeyO);
		
		if(customer.get().getCustomerType().equals("VIP")) {
			price = price / 2;
			return price;
		}
		if(customer.get().getFavouriteRoute().equals(journeyDto.getRoutename())) {
			disc = price * 0.30;
			price = price - disc;
			
			return price;
		}
		
		List<Journey> lstJourney = journeyDao.getCustomerlast48HoursJourney(journeyDto.getDateNTime());
		
		for(Journey journey : lstJourney) {
			if(journey.getRoute().equals(journeyDto.getRoutename()) && journey.getDateandTime().before(journeyDto.getDateNTime())) {
				//extra 10 % discount for journey 
				disc = price * 0.40;
				price = price - disc;
				
				return price;
			}
		}
		
		return price;
	}
	
	
	
}
