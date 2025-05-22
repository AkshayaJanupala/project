package com.capgemini.exception;

// Custom exception for handling invalid vehicle status
public class InvalidStatusException extends Exception {

	// Constructor that accepts a custom error message
	public InvalidStatusException(String message) {
		super(message);
	}
}