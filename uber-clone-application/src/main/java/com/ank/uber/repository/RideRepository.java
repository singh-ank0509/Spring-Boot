package com.ank.uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.uber.entities.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {

}
