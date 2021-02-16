package com.benz.calculator.model;

import java.io.Serializable;


public class CityFuelPrice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CityFuelPrice(String cityName, float fuelPrice) {
		this.cityName = cityName;
		this.fuelPrice = fuelPrice;
		lastUpdatedTime = System.currentTimeMillis();
	}
	
	float fuelPrice;
	long lastUpdatedTime;
	String cityName;
	
	public float getFuelPrice() {
		return fuelPrice;
	}
	public void setFuelPrice(float fuelPrice) {
		this.fuelPrice = fuelPrice;
	}
	public long getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(long lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

	
}
