package com.tutorial.deloitte.BusJourneyApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.deloitte.BusJourneyApp.entity.Journey;

@Repository
public interface JourneyRepo extends CrudRepository<Journey, String>{

	@Query("select * from j journey where dateandTime = :?")
	List<Journey> getCustomerlast48HoursJourney(String dateNTime);
	
}
