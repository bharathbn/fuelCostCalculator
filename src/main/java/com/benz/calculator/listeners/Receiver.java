package com.benz.calculator.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.benz.calculator.model.Event;
import com.benz.calculator.service.FuelEventHandlerService;

@Component
public class Receiver {

	@Autowired
	FuelEventHandlerService fuelEventHandlerService;

	public void receiveMessage(Event event) {
		System.out.println("from Reciever: "+event.toString());
		fuelEventHandlerService.handleEvent(event);
	}
}
