package com.ank.uber.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ank.uber.dtos.RideRequestDto;
import com.ank.uber.entities.Driver;
import com.ank.uber.entities.Ride;
import com.ank.uber.entities.RideRequest;
import com.ank.uber.enums.RideRequestStatus;
import com.ank.uber.enums.RideStatus;
import com.ank.uber.services.RideService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

	private final ModelMapper mapper;
	
	@Override
	public void getRideById(Long rideId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void matchWithDriver(RideRequestDto rideRequestDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ride createNewRide(RideRequest rideRequest, Driver driver) {
		rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);
		
		Ride ride = mapper.map(rideRequest, Ride.class);
		ride.setRideStatus(RideStatus.CONFIRMED);
		ride.setDriver(driver);
		
		
		
		
		return null;
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
