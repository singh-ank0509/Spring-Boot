package com.ank.uber.dtos;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import com.ank.uber.enums.PaymentMethod;
import com.ank.uber.enums.RideStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {

	private Long id;
	
	private Point pickUpLocation;
	
	private Point dropLocation;
	
	private LocalDateTime createdTime;
	
	private RiderDto rider;
	
	private DriverDto driver;
	
	private PaymentMethod paymentMethod;
	
	private RideStatus rideStatus;
	
	private Double fare;
	
	private String otp;
	
	private LocalDateTime startedAt;
	
	private LocalDateTime endedAt;
}
