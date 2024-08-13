package com.ank.uber.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ank.uber.dtos.RideRequestDto;
import com.ank.uber.services.RiderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rider")
@RequiredArgsConstructor
public class RiderController {
	
	private final RiderService riderService;

	@PostMapping("/requestRide")
	private ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto) {
		return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
	}
}
