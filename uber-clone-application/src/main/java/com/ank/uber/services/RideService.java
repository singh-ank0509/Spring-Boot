package com.ank.uber.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ank.uber.dtos.RideRequestDto;
import com.ank.uber.entities.Driver;
import com.ank.uber.entities.Ride;
import com.ank.uber.entities.RideRequest;
import com.ank.uber.enums.RideStatus;

public interface RideService {

	void getRideById(Long rideId);
	
	void matchWithDriver(RideRequestDto rideRequestDto);
	
	Ride createNewRide(RideRequest rideRequest, Driver driver);
	
	void updateRideStatus(Long rideId, RideStatus rideStatus);
	
	Page<Ride> getAllRidesOfRider(Long rideId, PageRequest pageRequest);
	
	Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
