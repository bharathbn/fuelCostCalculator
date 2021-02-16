package com.benz.calculator.service;

import java.util.Collections;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.benz.calculator.model.CityFuelPrice;
import com.benz.calculator.utils.Constants;

@Service
public class FuelPriceService {


	@Autowired
	RestTemplate restTemplate;

	@Cacheable(value = "CityFuelPrices", key = "#cityName")
	public CityFuelPrice getFuelPrice(String cityName) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> str = restTemplate.exchange(Constants.LAT_LONG_API + cityName, HttpMethod.GET, entity,
				String.class);

		JSONObject obj = new JSONObject(str.getBody());

		String latitude = obj.getJSONObject("Response").getJSONArray("View").getJSONObject(0).getJSONArray("Result")
				.getJSONObject(0).getJSONObject("Location").getJSONObject("DisplayPosition").get("Latitude").toString();
		String longitude = obj.getJSONObject("Response").getJSONArray("View").getJSONObject(0).getJSONArray("Result")
				.getJSONObject(0).getJSONObject("Location").getJSONObject("DisplayPosition").get("Longitude")
				.toString();
		System.out.println("city latitude:" + latitude);
		System.out.println("city longitude:" + longitude);
		float fuelPrice = getFuelCostForLatLong(latitude, longitude);

		CityFuelPrice cityFuelPrice = new CityFuelPrice(cityName, fuelPrice);
		System.out.println("Live Fuel price : "+ cityFuelPrice.getFuelPrice() + " for city " + cityFuelPrice.getCityName());
		return cityFuelPrice;
	}

	private float getFuelCostForLatLong(String latitude, String longitude) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> str = restTemplate.exchange(Constants.FUEL_PRICE_API + latitude + "/" + longitude,
				HttpMethod.GET, entity, String.class);

		JSONObject obj = new JSONObject(str.getBody());

		String price = obj.getJSONArray("pumps").getJSONObject(0).get("Petrol Price").toString();

		return Float.valueOf(price);

	}

	public CityFuelPrice getFuelPriceRetry(String cityName) {
		float fuelPrice = Constants.DEFAULT_FUEL_PRICE;
		CityFuelPrice cityFuelPrice = new CityFuelPrice(cityName, fuelPrice);
		return cityFuelPrice;
	}

}
