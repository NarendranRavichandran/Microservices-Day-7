package com.oneenterprise.orderservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oneenterprise.orderservice.exception.UserServiceUnavailableException;
import java.util.LinkedHashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(
	            UserServiceUnavailableException.class
	    )
	    public ResponseEntity<Map<String, Object>>
	    handleUserServiceUnavailable(
	            UserServiceUnavailableException exception) {

	        Map<String, Object> response =
	                new LinkedHashMap<>();

	        response.put(
	                "timestamp",
	                LocalDateTime.now()
	        );

	        response.put(
	                "status",
	                503
	        );

	        response.put(
	                "error",
	                "USER_SERVICE_UNAVAILABLE"
	        );

	        response.put(
	                "message",
	                "User Service is temporarily unavailable. "
	                        + "Please try again later."
	        );

	        return ResponseEntity
	                .status(HttpStatus.SERVICE_UNAVAILABLE)
	                .body(response);
	    }
	
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Map<String, Object>>
    handleOrderNotFound(
            OrderNotFoundException exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now()
        );

        response.put(
                "status",
                404
        );

        response.put(
                "error",
                "ORDER_NOT_FOUND"
        );

        response.put(
                "message",
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(
            CircuitOpenException.class
    )
    public ResponseEntity<Map<String, Object>>
    handleCircuitOpen(
            CircuitOpenException exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now()
        );

        response.put(
                "status",
                503
        );

        response.put(
                "error",
                "PAYMENT_SERVICE_UNAVAILABLE"
        );

        response.put(
                "message",
                "Payment service is temporarily unavailable. "
                        + "Please try again later."
        );

        return ResponseEntity
                .status(
                        HttpStatus.SERVICE_UNAVAILABLE
                )
                .body(response);
    }

    @ExceptionHandler(
            PaymentServiceException.class
    )
    public ResponseEntity<Map<String, Object>>
    handlePaymentFailure(
            PaymentServiceException exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now()
        );

        response.put(
                "status",
                503
        );

        response.put(
                "error",
                "PAYMENT_SERVICE_UNAVAILABLE"
        );

        response.put(
                "message",
                "Payment service is temporarily unavailable. "
                        + "Please try again later."
        );

        return ResponseEntity
                .status(
                        HttpStatus.SERVICE_UNAVAILABLE
                )
                .body(response);
    }

    @ExceptionHandler(
            DownstreamServiceException.class
    )
    public ResponseEntity<Map<String, Object>>
    handleUserServiceFailure(
            DownstreamServiceException exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now()
        );

        response.put(
                "status",
                503
        );

        response.put(
                "error",
                "USER_SERVICE_UNAVAILABLE"
        );

        response.put(
                "message",
                "User service is temporarily unavailable. "
                        + "Please try again later."
        );

        return ResponseEntity
                .status(
                        HttpStatus.SERVICE_UNAVAILABLE
                )
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>>
    handleGeneralException(
            Exception exception) {

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "timestamp",
                LocalDateTime.now()
        );

        response.put(
                "status",
                500
        );

        response.put(
                "error",
                "INTERNAL_SERVER_ERROR"
        );

        response.put(
                "message",
                "An unexpected error occurred"
        );

        return ResponseEntity
                .status(
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
                .body(response);
    }
    
   
}