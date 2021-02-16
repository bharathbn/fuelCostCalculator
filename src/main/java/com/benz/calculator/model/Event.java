package com.benz.calculator.model;

import java.io.Serializable;

public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String userId;
	String cityName;
	boolean eventValue;
	long time;

	public String toString() {
		return String.format("Event[userName =%s, eventValue='%s', cityName='%s'  , time='%s']" ,
				userId, eventValue,cityName, time);
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userName) {
		this.userId = userName;
	}

	public boolean isEventValue() {
		return eventValue;
	}

	public void setEventValue(boolean eventValue) {
		this.eventValue = eventValue;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
