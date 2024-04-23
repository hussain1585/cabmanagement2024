package com.expatrio.cabmanagement.exceptions;

public class BookingDoesNotExistException extends RuntimeException{
    public BookingDoesNotExistException(String message) {
        super(message);
    }
}
