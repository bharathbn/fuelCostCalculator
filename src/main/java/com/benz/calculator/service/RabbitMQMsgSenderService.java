package com.benz.calculator.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.benz.calculator.FuelCostCalculatorApplication;
import com.benz.calculator.listeners.Receiver;
import com.benz.calculator.model.Event;
import com.benz.calculator.utils.Constants;

@Service
public class RabbitMQMsgSenderService {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;

	public RabbitMQMsgSenderService(Receiver receiver, RabbitTemplate rabbitTemplate) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(Event event) {
		rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, Constants.EXCHANGE_KEY, event);
	}
}
