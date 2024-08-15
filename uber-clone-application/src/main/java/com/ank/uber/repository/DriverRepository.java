package com.ank.uber.repository;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ank.uber.entities.Driver;

// ST_DISTANCE(point1, point2)
// ST_DWithin(POINT1, 10000)

public interface DriverRepository extends JpaRepository<Driver, Long> {

	@Query(value = "SELECT d.*, ST_DISTANCE(d.current_location, :pickUpLocation) AS distance \n"
				 + "FROM driver d \n"
				 + "WHERE available = true AND ST_DWithin(d.current_location, :pickUpLocation, 10000) \n"
				 + "ORDER BY distance \n"
				 + "LIMIT 10", nativeQuery = true)
	List<Driver> findTenNearestMatchingDrivers(Point pickUpLocation);
	
	@Query(value = "SELECT d.*  \n"
			 + "FROM driver d \n"
			 + "WHERE available = true AND ST_DWithin(d.current_location, :pickUpLocation, 10000) \n"
			 + "ORDER BY d.ratings DESC \n"
			 + "LIMIT 10", nativeQuery = true)
	List<Driver> findTenTopRatedNearbyMatchingDrivers(Point pickUpLocation);
}
