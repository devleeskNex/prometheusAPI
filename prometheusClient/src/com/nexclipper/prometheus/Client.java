package com.nexclipper.prometheus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.nexclipper.prometheus.service.Label;
import com.nexclipper.prometheus.service.Series;
import com.nexclipper.prometheus.service.Target;

public class Client {
	private static Gson gson = new Gson();
	public static void main(String[] args) {
		Label label = new Label();
		Target target = new Target();
		Series series = new Series();
		
//		System.out.println(label.getMetricList());
//		System.out.println(target.getTargetList());
		Map<String, Object> resultObject = gson.fromJson(label.getMetricList(), Map.class);
//		for (String key : resultObject.keySet()) {
//			System.out.println(key);
//		}
//		System.out.println(resultObject.get("status"));
//		System.out.println(resultObject.get("data"));
		String[] metricLabelList = gson.fromJson(gson.toJson(resultObject.get("data")), String[].class);
		for (String metricLabel : metricLabelList) {
			//System.out.println(metricLabel);
			System.out.println(series.findSeriesByLabelMatchers(metricLabel));
		}
	}
}
