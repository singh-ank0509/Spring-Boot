package com.ank.uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.uber.entities.RideRequest;

public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {

}
