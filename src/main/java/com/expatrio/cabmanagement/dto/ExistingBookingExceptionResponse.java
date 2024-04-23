package com.expatrio.cabmanagement.dto;

import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ExistingBookingExceptionResponse {
    private String error;
    private List<BookingEntity> bookings;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;
}
