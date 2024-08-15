package com.ank.uber.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ank.uber.dtos.DriverDto;
import com.ank.uber.dtos.RideDto;
import com.ank.uber.entities.Driver;
import com.ank.uber.entities.RideRequest;
import com.ank.uber.enums.RideRequestStatus;
import com.ank.uber.exception.DriverNotAvailableException;
import com.ank.uber.exception.RideRequestStatusNotPending;
import com.ank.uber.repository.DriverRepository;
import com.ank.uber.repository.RideRequestRepository;
import com.ank.uber.services.DriverService;
import com.ank.uber.services.RideRequestService;
import com.ank.uber.services.RideService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
	
	private final RideRequestService rideRequestService;
	private final DriverRepository driverRepository;
	private final RideService rideService;
	
	@Override
	public RideDto cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto acceptRide(Long rideId) {
		RideRequest rideRequest = rideRequestService.findRideRequestById(rideId);
		if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
			throw new RideRequestStatusNotPending("Ride Request cannot be accepted, status is " + rideRequest.getRideRequestStatus());
		}
		
		if(!getCurrentDriver().getAvailable()) {
			throw new DriverNotAvailableException("Ride Request cannot be accepted, status is " + rideRequest.getRideRequestStatus());
		}
		
		rideService.createNewRide(rideRequest, getCurrentDriver());
		
		
		return null;
	}

	@Override
	public RideDto startRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto endRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RideDto rateRide(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDto> getMyRides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver getCurrentDriver() {
		Driver driver = driverRepository.findById(2l).get();
		return driver;
	}

}
