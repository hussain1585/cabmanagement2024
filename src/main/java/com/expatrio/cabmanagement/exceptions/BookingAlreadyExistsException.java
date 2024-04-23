package com.expatrio.cabmanagement.exceptions;

import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BookingAlreadyExistsException extends RuntimeException{

    public BookingAlreadyExistsException(String message, List<BookingEntity> checkBookingListWithConflict) {
        super(message);
        log.debug("Booking already exists for the given time window" + checkBookingListWithConflict);
    }

    public BookingAlreadyExistsException(String message) {
        super(message);
    }
}
