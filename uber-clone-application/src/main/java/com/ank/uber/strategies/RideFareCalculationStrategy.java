package com.ank.uber.strategies;

import com.ank.uber.entities.RideRequest;

public interface RideFareCalculationStrategy {

	double RIDE_FARE_MULTIPLIER = 10;
	
	double calculateFare(RideRequest rideRequest);
}
