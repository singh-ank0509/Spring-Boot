package com.ank.uber.strategies.impl;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.ank.uber.strategies.DriverMatchingStrategy;
import com.ank.uber.strategies.RideFareCalculationStrategy;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
	
	private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
	private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
	private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;
	private final RiderFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;

	public DriverMatchingStrategy driverMatchingStrategy(double riderRatings) {
		if(riderRatings > 4.75) {
			return highestRatedDriverStrategy;
		} else {
			return nearestDriverStrategy;
		}
	}
	
	public RideFareCalculationStrategy rideFareCalculationStrategy() {
		// Based on peak hours 5PM to 9PM
		LocalTime surgeStartTime = LocalTime.of(17, 0);
		LocalTime surgeEndTime = LocalTime.of(21, 0);
		LocalTime currentTime = LocalTime.now();
		
		boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
		if(isSurgeTime) {
			return surgePricingFareCalculationStrategy;
		} else {
			return defaultFareCalculationStrategy;
		}
	}
}
