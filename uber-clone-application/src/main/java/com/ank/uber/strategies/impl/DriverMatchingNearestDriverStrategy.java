package com.ank.uber.strategies.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ank.uber.entities.Driver;
import com.ank.uber.entities.RideRequest;
import com.ank.uber.repository.DriverRepository;
import com.ank.uber.strategies.DriverMatchingStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

	private final DriverRepository driverRepository;
	
	@Override
	public List<Driver> findMatchingDrivers(RideRequest rideRequest) {		
		return driverRepository.findTenNearestMatchingDrivers(rideRequest.getPickUpLocation());
	}

}
