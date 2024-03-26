package com.foodUtilitySystem.KhaanaBachaoApp.rest;

public class FoodExceptionHandler {
	private int statuscode;
    private String errormessage;
    private long timestamp;
	public FoodExceptionHandler(int statuscode, String errormessage, long timestamp) {
		super();
		this.statuscode = statuscode;
		this.errormessage = errormessage;
		this.timestamp = timestamp;
	}
	public FoodExceptionHandler() {
		
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
    
}
