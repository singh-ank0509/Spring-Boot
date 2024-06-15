package com.spring.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.batch.entity.FeederDetails;

public interface FeederDetailsRepo extends JpaRepository<FeederDetails, Integer> {

}
