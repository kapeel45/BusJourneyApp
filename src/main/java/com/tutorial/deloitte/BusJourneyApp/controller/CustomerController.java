package com.tutorial.deloitte.BusJourneyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.deloitte.BusJourneyApp.dto.CustomerDto;
import com.tutorial.deloitte.BusJourneyApp.dto.JourneyDto;
import com.tutorial.deloitte.BusJourneyApp.entity.Customer;
import com.tutorial.deloitte.BusJourneyApp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService custService;

	
	@PostMapping("/register")
	public @ResponseBody Customer registerCustomer(@RequestBody CustomerDto custDto) {
		
		Customer cust = custService.registerCustomer(custDto);
		
		return cust;
	}
	
	@PostMapping("/add-journey")
	public @ResponseBody boolean addjourney(@RequestBody JourneyDto journeyDto) {
		
		boolean result = custService.addJourney(journeyDto);
		
		return result;
	}
	
	
	
}
