package com.MS.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timeStamp;
	private String message;
	private String desc;
	public ErrorDetails(LocalDateTime timeStamp, String message, String desc) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.desc = desc;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
