package com.fmsproject.exception;

public class NullValueFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;
	
	public NullValueFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		 return message;
	}
	
}
