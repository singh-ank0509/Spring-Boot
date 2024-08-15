package com.ank.uber.services;

import com.ank.uber.entities.RideRequest;

public interface RideRequestService {

	RideRequest findRideRequestById(Long rideId);

}
