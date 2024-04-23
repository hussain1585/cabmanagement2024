package com.expatrio.cabmanagement.exceptions;

public class IllegalBookingStateForReservationException extends RuntimeException{
    public IllegalBookingStateForReservationException(String message) {
        super(message);
    }
}
