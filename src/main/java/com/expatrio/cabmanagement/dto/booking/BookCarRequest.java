package com.expatrio.cabmanagement.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookCarRequest {

    private int carId;
    private int customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
