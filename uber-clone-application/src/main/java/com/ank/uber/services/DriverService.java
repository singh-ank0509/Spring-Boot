package com.ank.uber.services;

import java.util.List;

import com.ank.uber.dtos.DriverDto;
import com.ank.uber.dtos.RideDto;
import com.ank.uber.entities.Driver;

public interface DriverService {

	RideDto cancelRide(Long rideId);
	
	RideDto acceptRide(Long rideId);
	
	RideDto startRide(Long rideId);
	
	RideDto endRide(Long rideId);
	
	RideDto rateRide(Long rideId, Integer rating);
	
	DriverDto getMyProfile();
	
	List<RideDto> getMyRides();
	
	Driver getCurrentDriver();
}
