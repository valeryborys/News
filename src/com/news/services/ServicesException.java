package com.news.services;

public class ServicesException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServicesException() {
		super();
	}
	public ServicesException(String message) {
		super(message);
	}
	
	public ServicesException(Exception e) {
		super(e);
	}	
	
	public ServicesException(String message, Exception e) {
		super(message, e);
	}
	
}
