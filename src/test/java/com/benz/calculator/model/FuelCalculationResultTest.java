package com.benz.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FuelCalculationResultTest {

	FuelCalculationResult fuelCalculationResult;
	long time = System.currentTimeMillis();
	
	@BeforeEach
	public void setup() {
		fuelCalculationResult = new FuelCalculationResult("bharath" , "bengaluru" , 92.8,time, time, 100.00);
	}
	
	@Test
	public void cityNameCheck() {
		assertEquals("bengaluru", fuelCalculationResult.getCityName());
	}
	
	@Test
	public void time1Check() {
		assertEquals(time, fuelCalculationResult.getOpenTime());
	}
	
	@Test
	public void time2Check() {
		assertEquals(time, fuelCalculationResult.getCloseTime());
	}
	
	@Test
	public void useridCheck() {
		assertEquals("bharath", fuelCalculationResult.getUserId());
	}
	
	@Test
	public void coseCheck() {
		assertEquals(100.00, fuelCalculationResult.getCost());
	}
	
	
	@Test
	public void fuelPriceCheck() {
		assertEquals(92,8, fuelCalculationResult.getFuelPrice());
	}
	
}
