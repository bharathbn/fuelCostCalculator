package com.benz.calculator.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.benz.calculator.model.FuelCalculationResult;

public interface FuelCalculationResultRepository extends CrudRepository<FuelCalculationResult, Long> {

	List<FuelCalculationResult> findByUserId(String userId);

	FuelCalculationResult findById(long id);
}
