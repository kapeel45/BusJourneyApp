package com.tutorial.deloitte.BusJourneyApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.deloitte.BusJourneyApp.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long>{

}
