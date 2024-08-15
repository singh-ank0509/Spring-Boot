package com.ank.uber.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ank.uber.dtos.DriverDto;
import com.ank.uber.dtos.RideDto;
import com.ank.uber.dtos.RideRequestDto;
import com.ank.uber.dtos.RiderDto;
import com.ank.uber.entities.RideRequest;
import com.ank.uber.entities.Rider;
import com.ank.uber.entities.User;
import com.ank.uber.enums.RideRequestStatus;
import com.ank.uber.exception.ResourceNotFoundException;
import com.ank.uber.repository.RideRequestRepository;
import com.ank.uber.repository.RiderRepository;
import com.ank.uber.services.RiderService;
import com.ank.uber.strategies.DriverMatchingStrategy;
import com.ank.uber.strategies.RideFareCalculationStrategy;
import com.ank.uber.strategies.impl.RideStrategyManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

	private final ModelMapper mapper;
//	private final RideFareCalculationStrategy rideFareCalculationStrategy;
//	private final DriverMatchingStrategy driverMatchingStrategy;
	private final RideStrategyManager rideStrategyManager;
	
	private final RideRequestRepository rideRequestRepository;
	private final RiderRepository riderRepository;
	
	@Override
	@Transactional
	public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

		Rider currrentRider = getCurrrentRider();
		RideRequest rideRequest = mapper.map(rideRequestDto, RideRequest.class);
		rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
		rideRequest.setRider(currrentRider);
		
		double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
		rideRequest.setFare(fare);
		
		RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
		
		rideStrategyManager.driverMatchingStrategy(currrentRider.getRatings()).findMatchingDrivers(rideRequest);
	
		log.info(rideRequest.toString());
		return mapper.map(savedRideRequest, RideRequestDto.class);
	}

	@Override
	public RideRequestDto cancelRide(Long rideId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDto rateDriver(Long rideId, Integer rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiderDto getMyProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RideDto> getMyRides() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rider createNewRider(User user) {

		Rider rider = Rider
						.builder()
						.user(user)
						.ratings(0.0)
						.build();
		riderRepository.save(rider);
		return rider;
	}

	@Override
	public Rider getCurrrentRider() {
		// TODO Spring security implementation
		Rider rider = riderRepository.findById(1l).orElseThrow(() -> {
			throw new ResourceNotFoundException("No Rider with id : "+1);
		});
		return rider;
	}

}
