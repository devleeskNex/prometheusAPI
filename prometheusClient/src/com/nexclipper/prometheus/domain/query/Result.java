package com.nexclipper.prometheus.domain.query;

import java.util.List;
import java.util.Map;

public class Result {
	private Map<String, Object> metric;
	private List<Object> value;
	
	public Map<String, Object> getMetric() {
		return metric;
	}
	public void setMetric(Map<String, Object> metric) {
		this.metric = metric;
	}
	public List<Object> getValue() {
		return value;
	}
	public void setValue(List<Object> value) {
		this.value = value;
	}
	public Result(Map<String, Object> metric, List<Object> value) {
		super();
		this.metric = metric;
		this.value = value;
	}
}
