package com.nagarro.weatherapi.Model;

public class Weather {

	private double longitude;
	private double latitude;
	private String description;
	private String city;

	public Weather() {

	}

	public Weather(double longitude, double latitude, String description, String city) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.city = city;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Weather [longitude=" + longitude + ", latitude=" + latitude + ", description=" + description + ", city="
				+ city + "]";
	}

}
