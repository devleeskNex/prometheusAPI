package com.nexclipper.prometheus;

public interface ENDPOINT {
	String APIVERSION = "/api/v1";
	public interface LABEL {
		String LIST = APIVERSION + "/label/__name__/values";	
	}
	
	public interface TARGET {
		String LIST = APIVERSION + "/targets";
	}	
	
}