package com.ank.uber.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.uber.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

}
