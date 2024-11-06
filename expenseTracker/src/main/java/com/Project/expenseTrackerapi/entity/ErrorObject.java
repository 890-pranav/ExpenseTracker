package com.Project.expenseTrackerapi.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorObject {
	private Integer statusCode;
	private String message;
	public ErrorObject(Integer statusCode, String message, Date timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public ErrorObject() {
		super();
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	private Date timeStamp;
}
