package com.ank.uber.exception;

public class RideRequestStatusNotPending extends RuntimeException {

	public RideRequestStatusNotPending() {}
	
	public RideRequestStatusNotPending(String message) {
		super(message);
	}
}
