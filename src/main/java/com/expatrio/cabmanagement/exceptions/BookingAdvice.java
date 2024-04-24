package com.expatrio.cabmanagement.exceptions;

import com.expatrio.cabmanagement.dto.ExistingBookingExceptionResponse;
import com.expatrio.cabmanagement.dto.booking.AddBookingResponse;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@ControllerAdvice
public class BookingAdvice {

    @ExceptionHandler(BookingAlreadyExistsException.class)
    public ResponseEntity<ExistingBookingExceptionResponse> handleBookingAlreadyExistsException(BookingAlreadyExistsException exception)
    {
        log.debug("handling API exception => BookingAlreadyExistsException ");
        ExistingBookingExceptionResponse cabApplicationExceptionResponse = ExistingBookingExceptionResponse
                .builder()
                .error(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(cabApplicationExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
