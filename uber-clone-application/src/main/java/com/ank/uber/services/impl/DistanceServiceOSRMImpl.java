package com.ank.uber.services.impl;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ank.uber.services.DistanceService;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Service
@Primary
public class DistanceServiceOSRMImpl implements DistanceService {

	private static final String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";

	@Override
	public Double calculateDistance(Point src, Point dest) {

		try {
			OSRMResponseDto body = RestClient.builder()
					  .baseUrl(OSRM_API_BASE_URL)
					  .build()
					  .get()
					  .uri("{},{};{},{}"+src.getX(), src.getY(), dest.getX(), dest.getY())
					  .retrieve()
					  .body(OSRMResponseDto.class);
					
			System.err.println(body);
			return body.getRoutes().get(0).getDistance();
		} catch(Exception e) {
			throw new RuntimeException("Error getting OSRM data : " + e.getMessage());
		}
		
	}
}

@Data
class OSRMResponseDto {
	private List<OSRMRoute> routes;   
}

@Data
class OSRMRoute {
	private Double distance;
}