package com.expatrio.cabmanagement.dto.customer;

import com.expatrio.cabmanagement.dto.car.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetCustomerByIdResponse {
    private CustomerDTO customerDTO;
}