package com.benz.calculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.benz.calculator.service.RabbitMQMsgSenderService;

public class FuelEventControllerTest {

	@Mock
	RabbitMQMsgSenderService rabbitMQMsgSenderService;

	@InjectMocks
	FuelEventController fuelEventController;

	@BeforeEach
	public void setUp() throws Exception {
		// initMock();
	}
	
	public void getFuelEventCheck() {
		
	}
}
