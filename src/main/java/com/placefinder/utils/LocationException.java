package com.placefinder.utils;

public class LocationException extends RuntimeException {

	private static final long serialVersionUID = -7092561340174699021L;

	public LocationException() {
	}

	public LocationException(String message) {
		super(message);
	}

	public LocationException(Throwable cause) {
		super(cause);
	}

	public LocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public LocationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
