package com.ank.uber.exception;

public class DriverNotAvailableException extends RuntimeException {

	public DriverNotAvailableException() {}

	public DriverNotAvailableException(String message) {
		super(message);
	}

}
