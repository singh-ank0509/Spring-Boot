package com.ank.uber.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ank.uber.advices.ApiResponse;
import com.ank.uber.dtos.RideDto;
import com.ank.uber.services.DriverService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
	
	private final DriverService driverService;

	@PostMapping("/acceptRideRequest/{rideId}")
	public ResponseEntity<RideDto> acceptRideRequest(@PathVariable("rideId") Long rideId) {
		return new ResponseEntity<>(driverService.acceptRide(rideId), HttpStatus.OK);
	}
}
