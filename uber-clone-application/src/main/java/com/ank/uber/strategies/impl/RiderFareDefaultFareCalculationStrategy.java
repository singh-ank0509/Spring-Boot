package com.ank.uber.strategies.impl;

import org.springframework.stereotype.Service;

import com.ank.uber.entities.RideRequest;
import com.ank.uber.services.DistanceService;
import com.ank.uber.strategies.RideFareCalculationStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

	private final DistanceService distanceService;
		
	@Override
	public double calculateFare(RideRequest rideRequest) {

		double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
																	 rideRequest.getDropLocation());
		
		
		return distance*RIDE_FARE_MULTIPLIER;
	}

}
