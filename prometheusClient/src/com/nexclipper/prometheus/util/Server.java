package com.nexclipper.prometheus.util;

public class Server {
	private String host = "192.168.0.172";
	private int port = 22222;
	
	public String info() {
		return "http://" + host + ":" + port;
	}
}
