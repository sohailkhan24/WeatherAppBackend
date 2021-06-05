package com.nagarro.weatherapi.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.weatherapi.Model.Weather;
import com.nagarro.weatherapi.Values.Values;

@Service
public class WeatherService {

	@SuppressWarnings("unchecked")
	// Get Data from api
	public Weather getWeatherData(String cityInp) {
		RestTemplate restTemplate = new RestTemplate();

		// Storing data in LinkedHashMap (data)
		LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) restTemplate
				.getForObject(Values.url + "?q=" + cityInp + "&appid=" + Values.appId, Object.class);

		// Getting the data that is required for the functionality

		// coordinates
		LinkedHashMap<String, Object> coord = (LinkedHashMap<String, Object>) data.get("coord");
		double longitude = (double) coord.get("lon");
		double latitude = (double) coord.get("lat");

		// weather description
		ArrayList<?> weather = (ArrayList<?>) data.get("weather");
		LinkedHashMap<String, ?> weatherObj = (LinkedHashMap<String, ?>) weather.get(0);
		String description = (String) weatherObj.get("description");

		// Your City
		String city = (String) data.get("name");



//		Save Data 
		Weather weatherApp = new Weather(longitude, latitude, description, city);

		return weatherApp;

	}

}
