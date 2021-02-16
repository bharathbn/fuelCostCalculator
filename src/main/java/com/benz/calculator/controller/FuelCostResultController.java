package com.benz.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.benz.calculator.model.FuelCalculationResult;
import com.benz.calculator.repo.FuelCalculationResultRepository;
import com.benz.calculator.utils.Constants;

@RestController
public class FuelCostResultController {

	@Autowired
	FuelCalculationResultRepository fuelCalculationResultRepository;

	@RequestMapping(method = RequestMethod.GET, value = Constants.FUEL_COST_PATH)
	public List<FuelCalculationResult> getFuelCost(@RequestHeader(Constants.USERID) String userName) {
		if( userName == null || userName == "") userName = Constants.DEFAULT_USERID;
		List<FuelCalculationResult> result = fuelCalculationResultRepository.findByUserId(userName);
		return result;
	}
}
