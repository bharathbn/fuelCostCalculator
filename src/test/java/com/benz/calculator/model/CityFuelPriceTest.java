package com.benz.calculator.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityFuelPriceTest {

	CityFuelPrice cityFuelPrice;

	@BeforeEach
	public void setup() {
		cityFuelPrice = new CityFuelPrice("Bengaluru", (float) 92.8);
	}

	@Test
	public void cityNameCheck() {
		assertEquals("Bengaluru", cityFuelPrice.getCityName());
	}

	@Test
	public void fuelPriceCheck() {
		assertEquals((float) 92.8, cityFuelPrice.getFuelPrice());
	}

}
