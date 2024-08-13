package com.ank.uber.services;

import java.util.List;

import com.ank.uber.dtos.DriverDto;
import com.ank.uber.dtos.RideDto;
import com.ank.uber.dtos.RideRequestDto;
import com.ank.uber.dtos.RiderDto;
import com.ank.uber.entities.Rider;
import com.ank.uber.entities.User;

public interface RiderService {
	
	RideRequestDto requestRide(RideRequestDto rideRequestDto);
	
	RideRequestDto cancelRide(Long rideId);
	
	DriverDto rateDriver(Long rideId, Integer rating);
	
	RiderDto getMyProfile();
	
	List<RideDto> getMyRides();
	
	Rider createNewRider(User user);
	
	Rider getCurrrentRider();
}
