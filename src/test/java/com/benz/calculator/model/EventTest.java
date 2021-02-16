package com.benz.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventTest {
	
	Event event;
	String userId = "bharath";
	String cityName = "bengaluru";
	boolean eventValue = true;
	long time = System.currentTimeMillis();
	
	@BeforeEach
	public void setup() {
		event = new Event();
		event.setCityName(cityName);
		event.setEventValue(eventValue);
		event.setTime(time);
		event.setUserId(userId);
	}
	
	
	@Test
	public void cityNameCheck() {
		assertEquals("bengaluru", event.getCityName());
	}
	
	@Test
	public void eventValueCheck() {
		assertEquals(true, event.isEventValue());
	}
	
	@Test
	public void timeCheck() {
		assertEquals(time, event.getTime());
	}
	
	@Test
	public void useridCheck() {
		assertEquals(userId, event.getUserId());
	}
	

}
