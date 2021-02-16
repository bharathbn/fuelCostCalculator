package com.benz.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuelCalculationResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String cityName;
	private Double fuelPrice;
	private long openTime;
	private long closeTime;
	private Double cost;
	
	
	protected FuelCalculationResult() {};

	public FuelCalculationResult(String userId, String cityName, double d, long openTime, long closeTime, Double cost) {
		this.userId = userId;
		this.cityName = cityName;
		this.fuelPrice = d;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("FuelLidOpen[id=%d, userId='%s', cityName='%s'  , fuelPrice='%f' , openTime='%s' , closeTime='%s' , cost = '%s' ]", id,
				userId, cityName, fuelPrice, openTime, closeTime, cost);
	}

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getCityName() {
		return cityName;
	}

	public Double getFuelPrice() {
		return fuelPrice;
	}

	public long getOpenTime() {
		return openTime;
	}

	public long getCloseTime() {
		return closeTime;
	}

	public Double getCost() {
		return cost;
	}
	

}
