package com.nexclipper.prometheus;

import java.util.Map;
import com.google.gson.Gson;
import com.nexclipper.prometheus.service.Label;
import com.nexclipper.prometheus.service.Series;
import com.nexclipper.prometheus.service.Target;

public class ClientTest1 {
	private static Gson gson = new Gson();
	public static void main(String[] args) {
		Label label = new Label();
		Target target = new Target();
		Series series = new Series();
		
//		System.out.println(label.getMetricList());
//		System.out.println(target.getTargetList());
		Map<String, Object> metricObject = gson.fromJson(label.getMetricList(), Map.class);
//		for (String key : metricObject.keySet()) {
//			System.out.println(key);
//		}
//		System.out.println(metricObject.get("status"));
//		System.out.println(metricObject.get("data"));
		String[] metricLabelList = gson.fromJson(gson.toJson(metricObject.get("data")), String[].class);
		String metricLabel = metricLabelList[33];
		System.out.println(metricLabel);
		String seriesStr = series.findSeriesByLabelMatchers(metricLabel);
		System.out.println(seriesStr);
//		Result seriesObject = gson.fromJson(seriesStr, Result.class);
//		System.out.println(seriesObject.getData().get(0).get__name__());
//		for (String key : seriesObject.keySet()) {
//			System.out.println(key);
//		}
		//Map<String, Object>[] metricLabelList = gson.fromJson(gson.toJson(metricObject.get("data")), String[].class);
//		System.out.println(seriesObject.get("status"));
//		System.out.println(seriesObject.get("data"));
		
		
//		for (String metricLabel : metricLabelList) {
//			System.out.println(metricLabel);
//			System.out.println(series.findSeriesByLabelMatchers(metricLabel));
//		}
	}
}
