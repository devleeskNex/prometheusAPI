package com.nexclipper.prometheus.service;

import com.nexclipper.prometheus.ENDPOINT;
import com.nexclipper.prometheus.util.Connection;

public class Target {
	private Connection connection;

	public Target() {
		connection = new Connection();
	}
	public String getTargetList() {
		return this.connection.get(ENDPOINT.TARGET.LIST);
	}

}
