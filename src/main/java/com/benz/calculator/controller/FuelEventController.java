package com.benz.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.benz.calculator.model.Event;
import com.benz.calculator.service.RabbitMQMsgSenderService;
import com.benz.calculator.utils.Constants;

@RestController
public class FuelEventController {

	@Autowired
	RabbitMQMsgSenderService sender;

	@RequestMapping(method = RequestMethod.POST, value = Constants.FUEL_EVENT_PATH)
	public ResponseEntity getFuelEvent(@RequestBody Event event, @RequestHeader(Constants.USERID) String userName) {
		
		if(userName !=null )event.setUserId(userName);
		else event.setUserId(Constants.DEFAULT_USERID);
		event.setTime(System.currentTimeMillis());
		System.out.println("from Sender: "+event.toString());
		sender.send(event);
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
}
