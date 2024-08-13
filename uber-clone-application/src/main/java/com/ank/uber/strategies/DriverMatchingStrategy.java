package com.ank.uber.strategies;

import java.util.List;

import com.ank.uber.entities.Driver;
import com.ank.uber.entities.RideRequest;

public interface DriverMatchingStrategy {

	List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
