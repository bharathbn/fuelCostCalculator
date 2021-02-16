package com.benz.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;

import com.benz.calculator.model.Event;

public class FuelEventHandlerServiceTest {

	long time = System.currentTimeMillis();

	Event event;
	String userId = "bharath";
	String cityName = "bengaluru";
	boolean eventValue = true;

	@BeforeEach
	public void setup() {
		event = new Event();
		event.setCityName(cityName);
		event.setEventValue(eventValue);
		event.setTime(time);
		event.setUserId(userId);

	}
	
	@InjectMocks
	private FuelEventHandlerService service;
	
	
	public void handleEventTest() throws Exception {
	 service.handleEvent(event);
		//check the repo for test result
	}

}
