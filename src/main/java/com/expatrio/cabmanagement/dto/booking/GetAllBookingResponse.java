package com.expatrio.cabmanagement.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetAllBookingResponse {
    private List<BookingDTO> bookingDTOList;
}
