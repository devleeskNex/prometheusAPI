package com.nexclipper.prometheus;

import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.nexclipper.prometheus.domain.query.Data;
import com.nexclipper.prometheus.domain.query.MetricExpression;
import com.nexclipper.prometheus.domain.query.Result;
import com.nexclipper.prometheus.service.Label;
import com.nexclipper.prometheus.service.Query;

public class Client {
	private static Gson gson = new Gson();
	private static Query query = new Query();
	private static Label label = new Label();
	private static int idx = 0;
	public static void main(String[] args) {
		
		Map<String, Object> metricLabelListObject = gson.fromJson(label.getMetricList(), Map.class);
		String[] metricLabelList = gson.fromJson(gson.toJson(metricLabelListObject.get("data")), String[].class);
		
		for (String metricLabel : metricLabelList) {
			String metricExpressionStr = findMetricExpressionByLabel(metricLabel);
			MetricExpression metricExpressionResult = gson.fromJson(metricExpressionStr, MetricExpression.class);
			drawMetricExpressionResult(metricExpressionResult, metricLabel);
			//System.out.println(metricExpressionResult.getData().getResult().get(0).getMetric().keySet());
		}
		
		
	}
	public static String findMetricExpressionByLabel (String metricLabel) {
		return query.findMetricExpressionByLabel(metricLabel);
	}
	public static void drawMetricExpressionResult(MetricExpression metricExpressionResult, String metricLabel) {
		if ("success".equals(metricExpressionResult.getStatus()))
			drawMetricExpression(metricExpressionResult.getData(), metricLabel);
		else System.out.println(metricExpressionResult.getStatus());
	}
	public static void drawMetricExpression (Data data, String metricLabel) {
		if ("vector".equals(data.getResultType()))
			drawVector(data.getResult(), metricLabel);
		else System.out.println(data.getResultType());
				
	}
	public static void drawVector(List<Result> results, String metricLabel) {
		System.out.println("[[" + metricLabel + "]]");
		for (Result result : results) {
			for (String key : result.getMetric().keySet()) {
				System.out.println("\t" + key + " : " + result.getMetric().get(key));
			}
			System.out.println("\tvalue : " + result.getValue().get(1));
		}
	}
}
