package com.benz.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuelLidOpen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String cityName;
	private Double fuelPrice;
	private long openTime;
	
	
	protected FuelLidOpen() {}

	public FuelLidOpen(String userId, String cityName, long time, double d) {
		this.userId = userId;
		this.cityName = cityName;
		this.fuelPrice = d;
		this.openTime = time;;
	}

	@Override
	public String toString() {
		return String.format("FuelLidOpen[id=%d, userId='%s', cityName='%s'  , fuelPrice='%f' , openTime='%s']", id,
				userId, cityName, fuelPrice, openTime);
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

}
