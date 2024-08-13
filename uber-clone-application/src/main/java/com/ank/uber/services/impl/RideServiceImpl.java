package com.ank.uber.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ank.uber.dtos.RideRequestDto;
import com.ank.uber.entities.Driver;
import com.ank.uber.entities.Ride;
import com.ank.uber.enums.RideStatus;
import com.ank.uber.services.RideService;

public class RideServiceImpl implements RideService {

	@Override
	public void getRideById(Long rideId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void matchWithDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createNewRide(RideRequestDto rideRequestDto, Driver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRideStatus(Long rideId, RideStatus rideStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Ride> getAllRidesOfRider(Long rideId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
