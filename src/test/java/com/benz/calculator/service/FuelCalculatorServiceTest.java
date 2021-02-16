package com.benz.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.benz.calculator.model.Event;
import com.benz.calculator.model.FuelLidOpen;

public class FuelCalculatorServiceTest {

	FuelLidOpen fuelLidOpen;
	long time = System.currentTimeMillis();
	long time2 = time + 30000;

	Event event;
	String userId = "bharath";
	String cityName = "bengaluru";
	boolean eventValue = true;

	@BeforeEach
	public void setup() {
		fuelLidOpen = new FuelLidOpen(userId, cityName, time, 92.8);
		event = new Event();
		event.setCityName(cityName);
		event.setEventValue(eventValue);
		event.setTime(time2);
		event.setUserId(userId);

	}

	@InjectMocks
	private FuelCalculatorService service;

	
	public void CalculateTest() throws Exception {
		double cost = service.calculateCost(fuelLidOpen, event);
		assertEquals(92.8, cost);
	}
}
