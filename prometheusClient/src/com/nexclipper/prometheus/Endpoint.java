package com.nexclipper.prometheus;

public interface Endpoint {
	String apiVer = "/api/v1";
	String metricList = apiVer + "/label/__name__/values";
	
}
