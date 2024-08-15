package com.ank.uber.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ank.uber.exception.DriverNotAvailableException;
import com.ank.uber.exception.ResourceNotFoundException;
import com.ank.uber.exception.RideRequestStatusNotPending;
import com.ank.uber.exception.RuntimeConflictException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeConflictException.class)
	public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException exp) {
		ApiError apiError = ApiError.builder()
									.status(HttpStatus.CONFLICT)
									.message(exp.getMessage())
									.build();
		
		return buildErrorResponseEntity(apiError);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exp) {
		ApiError apiError = ApiError.builder()
									.status(HttpStatus.NOT_FOUND)
									.message(exp.getMessage())
									.build();
		
		return buildErrorResponseEntity(apiError);
	}
	
	@ExceptionHandler(RideRequestStatusNotPending.class)
	public ResponseEntity<ApiResponse<?>> handleRideRequestStatusNotPending(RideRequestStatusNotPending exp) {
		ApiError apiError = ApiError.builder()
									.status(HttpStatus.INTERNAL_SERVER_ERROR)
									.message(exp.getMessage())
									.build();
		
		return buildErrorResponseEntity(apiError);
	}
	
	@ExceptionHandler(DriverNotAvailableException.class)
	public ResponseEntity<ApiResponse<?>> handleDriverNotAvailableException(DriverNotAvailableException exp) {
		ApiError apiError = ApiError.builder()
									.status(HttpStatus.INTERNAL_SERVER_ERROR)
									.message(exp.getMessage())
									.build();
		
		return buildErrorResponseEntity(apiError);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exp) {
		ApiError apiError = ApiError.builder()
									.status(HttpStatus.INTERNAL_SERVER_ERROR)
									.message(exp.getMessage())
									.build();
		
		return buildErrorResponseEntity(apiError);
	}
	
	public ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
	}
}
