package com.nexclipper.prometheus;

public class Client {
	public static void main(String[] args) {
		//System.out.println("run test");
		String urlStr = "http://192.168.0.172:22222/api/v1/label/__name__/values";
		String result = new Connection().get(urlStr);
	}
}
