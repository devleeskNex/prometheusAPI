package com.nexclipper.prometheus.domain.query;

import java.util.List;

public class Data {
	private String resultType;
	private List<Result> result;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}
	public Data(String resultType, List<Result> result) {
		super();
		this.resultType = resultType;
		this.result = result;
	}
}
