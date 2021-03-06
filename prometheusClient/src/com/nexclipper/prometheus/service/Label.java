package com.nexclipper.prometheus.service;

import com.nexclipper.prometheus.ENDPOINT;
import com.nexclipper.prometheus.util.Connection;

public class Label {
	private Connection connection;
	
	public Label() {
		connection = new Connection();
	}
	
	public String getMetricList() {
		return connection.get(ENDPOINT.LABEL.LIST);
	}
}
