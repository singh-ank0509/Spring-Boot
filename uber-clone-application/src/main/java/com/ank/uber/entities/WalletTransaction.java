package com.ank.uber.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.ank.uber.enums.TransactionMethod;
import com.ank.uber.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WalletTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Enumerated(EnumType.STRING)
	private TransactionMethod transactionMethod;	
	
	private String transactionId;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Ride ride;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Wallet wallet;
	
	@CreationTimestamp
	private LocalDateTime timestamp;
}
