package com.benz.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.calculator.model.Event;
import com.benz.calculator.model.FuelCalculationResult;
import com.benz.calculator.model.FuelLidOpen;
import com.benz.calculator.repo.FuelCalculationResultRepository;
import com.benz.calculator.utils.Constants;

@Service
public class FuelCalculatorService {

	@Autowired
	FuelCalculationResultRepository fuelCalculationResultRepository;

	public double calculateCost(FuelLidOpen flo, Event closeEvent) {
		Double cost = 0.0;
		long duration = closeEvent.getTime() - flo.getOpenTime();
		if(duration <= 0) {
			cost = 0.0;
		}
		else {
			double duraitonInSec = duration / Constants.MILLI_SECONDS;
			double litres = duraitonInSec / Constants.LITERS_IN_SECONDS;
			cost =  litres * flo.getFuelPrice();
		}
		FuelCalculationResult fuelCalculationResult = new FuelCalculationResult(flo.getUserId(), flo.getCityName(), flo.getFuelPrice(),
				flo.getOpenTime(), closeEvent.getTime(), cost);
		System.out.println(fuelCalculationResult.toString());
		fuelCalculationResultRepository.save(fuelCalculationResult);
		
		return cost;
	}

}
