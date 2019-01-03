package com.nexclipper.prometheus.service;

import com.nexclipper.prometheus.ENDPOINT;
import com.nexclipper.prometheus.util.Connection;

public class Series {
	private Connection connection;
	
	public Series() {
		connection = new Connection();
	}
	
	public String findSeriesByLabelMatchers(String label) {
		return connection.get(ENDPOINT.SERIES.LIST + "?match[]=" + label);
	}
}
