package com.benz.calculator.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.benz.calculator.model.FuelLidOpen;

public interface FuelLidOpenRepository extends CrudRepository<FuelLidOpen, Long> {

	List<FuelLidOpen> findByUserId(String userId);

	FuelLidOpen findById(long id);
	
}
