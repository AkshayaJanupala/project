package com.vms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(PaymentNotFoundException.class)
   public ResponseEntity<String> handlePaymentNotFoundException(PaymentNotFoundException ex) {
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<String> handleGlobalException(Exception ex) {
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
   }
   @ExceptionHandler(VehicleNotFoundException.class)
   public ResponseEntity<?> handleVehicleNotFoundException(VehicleNotFoundException exception) {
       return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }
}