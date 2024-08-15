package com.ank.uber.dtos;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import com.ank.uber.enums.PaymentMethod;
import com.ank.uber.enums.RideRequestStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {

	private Long id;
	
	private PointDto pickUpLocation;
	
	private PointDto dropLocation;
	
	private PaymentMethod paymentMethod;
	
	private LocalDateTime requestedTime;
	
	private RiderDto rider;
	
	private Double fare;
	
	private RideRequestStatus rideRequestStatus;
}
