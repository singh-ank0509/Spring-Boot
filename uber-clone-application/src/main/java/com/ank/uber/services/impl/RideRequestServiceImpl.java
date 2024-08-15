package com.ank.uber.services.impl;

import org.springframework.stereotype.Service;

import com.ank.uber.entities.RideRequest;
import com.ank.uber.repository.RideRequestRepository;
import com.ank.uber.services.RideRequestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

	private final RideRequestRepository rideRequestRepository;
	@Override
	public RideRequest findRideRequestById(Long rideId) {
		return rideRequestRepository.findById(rideId).get();
	}

}
