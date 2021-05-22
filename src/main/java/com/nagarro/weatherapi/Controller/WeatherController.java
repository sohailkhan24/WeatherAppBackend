package com.nagarro.weatherapi.Controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.weatherapi.Model.Weather;
import com.nagarro.weatherapi.Service.EmailService;
import com.nagarro.weatherapi.Service.WeatherService;

@RestController
@CrossOrigin(origins = "*")
public class WeatherController {

	@Autowired
	private WeatherService WeatherService;
	
	@Autowired
	private EmailService EmailService;

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	public ResponseEntity<Weather> getWeatherData(@RequestBody LinkedHashMap<String, ?> data) {
		String city = (String) data.get("city");
		Weather weatherApp = WeatherService.getWeatherData(city);
		return ResponseEntity.status(HttpStatus.OK).body(weatherApp);
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "Api working";
	}
	
//	@Scheduled(cron = "0 30 9 * * ?")
	// @Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of
	// week] [Year]")
	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public void sendMail() {
		EmailService.sendPeriodicEmail();
	}

}
