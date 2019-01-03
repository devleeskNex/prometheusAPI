package com.nexclipper.prometheus.service;

import com.nexclipper.prometheus.Endpoint;
import com.nexclipper.prometheus.util.Connection;

public class Label {
	private Connection connection;
	private Endpoint endpoint;
	public Label() {
		connection = new Connection();
	}
	
	public String getMetricList() {
		return connection.get(endpoint.metricList);
	}
}
