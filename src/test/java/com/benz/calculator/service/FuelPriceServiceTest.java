package com.benz.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;

import com.benz.calculator.model.CityFuelPrice;
import com.benz.calculator.utils.Constants;

public class FuelPriceServiceTest {

	@InjectMocks
	private FuelPriceService service;
	
	
	public void getFuelPriceRetryTest() {
		CityFuelPrice cfp = service.getFuelPriceRetry("test");
		assertEquals(Constants.DEFAULT_FUEL_PRICE, cfp.getFuelPrice());
	}
}
