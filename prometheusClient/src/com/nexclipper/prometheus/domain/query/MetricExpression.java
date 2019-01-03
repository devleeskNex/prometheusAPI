package com.nexclipper.prometheus.domain.query;

public class MetricExpression {
	private String status;
	private Data data;
	
	public MetricExpression() {
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public MetricExpression(String status, Data data) {
		super();
		this.status = status;
		this.data = data;
	}
}
