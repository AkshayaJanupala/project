package com.capgemini.exception;

// Custom exception for handling cases where a vehicle is not found
public class VehicleNotFoundException extends RuntimeException {

	// Constructor that accepts a custom error message
	public VehicleNotFoundException(String message) {
		super(message);
	}
}
