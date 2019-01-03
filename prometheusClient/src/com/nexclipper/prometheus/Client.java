package com.nexclipper.prometheus;

import com.nexclipper.prometheus.service.Label;

public class Client {
	public static void main(String[] args) {
		Label label = new Label();
		
		System.out.println(label.getMetricList());
		
	}
}
