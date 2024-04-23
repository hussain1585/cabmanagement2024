package com.expatrio.cabmanagement.dto.booking;

import com.expatrio.cabmanagement.dto.customer.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetBookingByIdResponse {
    private BookingDTO bookingDTO;
}
