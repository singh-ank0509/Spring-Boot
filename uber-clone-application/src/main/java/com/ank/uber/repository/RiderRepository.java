package com.ank.uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.uber.entities.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {

}
