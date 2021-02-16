package com.benz.calculator.service;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.calculator.model.CityFuelPrice;
import com.benz.calculator.model.Event;
import com.benz.calculator.model.FuelLidOpen;
import com.benz.calculator.repo.FuelLidOpenRepository;

@Service
public class FuelEventHandlerService {

	@Autowired
	FuelLidOpenRepository fuelLidOpenRepository;

	@Autowired
	FuelPriceService fuelPriceService;

	@Autowired
	FuelCalculatorService fuelCalculatorService;

	public void handleEvent(Event event) {
		if (event != null) {
			if (event.isEventValue() == true) {
				// handle true
				CityFuelPrice cityFuelPrice = null;
				try {
					cityFuelPrice = fuelPriceService.getFuelPrice(event.getCityName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error while Fetching Fuel price for the city: " + event.getCityName());
					//e.printStackTrace();
				}
				if(cityFuelPrice != null) {
					cityFuelPrice.getFuelPrice();
				}
				else {
					// implement resilient pattern 
					System.out.println("Error while Fetching Fuel price for the city: " + event.getCityName());
					cityFuelPrice = fuelPriceService.getFuelPriceRetry(event.getCityName());
				}
				System.out.println("Fuel price : "+ cityFuelPrice.getFuelPrice() + " for city " + cityFuelPrice.getCityName());
				List<FuelLidOpen> lastOpen = fuelLidOpenRepository.findByUserId(event.getUserId());
				if (lastOpen == null || lastOpen.size() <= 0) {
					fuelLidOpenRepository.save(new FuelLidOpen(event.getUserId(), event.getCityName(), event.getTime(),
							cityFuelPrice.getFuelPrice()));
				}
				else {
					System.out.println("Fuel lid in true state as same as last status.");
				}
				

			} else {
				// Handle false
				List<FuelLidOpen> lastOpen = fuelLidOpenRepository.findByUserId(event.getUserId());
				if (lastOpen != null && lastOpen.size() > 0) {
					FuelLidOpen flo = lastOpen.get(0);
					System.out.println(flo);
					fuelLidOpenRepository.delete(flo);
					fuelCalculatorService.calculateCost(flo, event);

				}else {
					System.out.println("Fuel lid in false state as same as last status.");
				}

			}
		}
	}

}
