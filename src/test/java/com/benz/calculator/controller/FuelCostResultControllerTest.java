package com.benz.calculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.benz.calculator.repo.FuelCalculationResultRepository;

public class FuelCostResultControllerTest {

	@Mock
	FuelCalculationResultRepository fuelCalculationResultRepository;

	@InjectMocks
	FuelCostResultController fuelCostResultController;

	@BeforeEach
	public void setUp() throws Exception {
		// initMock();
	}
	
	public void getFuelCostCheck() {
		
	}

}
