package com.benz.calculator.utils;

public class Constants {

	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CONTENT_TYPE_JSON = "application/json";
	public static final String LAT_LONG_API = "https://geocoder.ls.hereapi.com/6.2/geocode.json?apiKey=PBQnrwTjpZjnN5faHOrSPdz_uNXo3btb5lpfz_A8kds&searchtext=";
	public static final String FUEL_PRICE_API = "https://www.newsrain.in/petrol-diesel-prices/near-lat-long/";
	
	public static final String DEFAULT_USERID = "bharath";
	
	public static final float DEFAULT_FUEL_PRICE = (float) 92.8;
	public static final int LITERS_IN_SECONDS = 30;
	public static final int MILLI_SECONDS = 1000;
	
	
	public static final String TOPIC_EXCHANGE_NAME = "benz-exchange";
	public static final String QUEUE_NAME  = "benz-queue";
	public static final String EXCHANGE_KEY_HASH = "benz.exchange.key.#";
	public static final String EXCHANGE_KEY = "benz.exchange.key";
	public static final String RECIEVE_MESSAGE = "receiveMessage";
	
	
	public static final String AUTH_MATCHER_PATH = "/fuelCostCalculator/v1/*";
	public static final String FUEL_COST_PATH = "/fuelCostCalculator/v1/fuelcost";
	public static final String FUEL_EVENT_PATH = "/fuelCostCalculator/v1/fuelevent";
	
	
	public static final String USERID ="userId";
	
	public static final String API_KEY = "API_KEY";
	public static final String API_KEY_VALUE = "Password1";

}
