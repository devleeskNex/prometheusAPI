package com.nexclipper.prometheus.service;

import com.nexclipper.prometheus.ENDPOINT;
import com.nexclipper.prometheus.util.Connection;

public class Query {
	private Connection connection;
	
	public Query() {
		connection = new Connection();
	}
	
	public String findMetricExpressionByLabel(String label) {
		return connection.get(ENDPOINT.QUERY.LIST + "?query=" + label);
	}
	

}
