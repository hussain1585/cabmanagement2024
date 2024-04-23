package com.expatrio.cabmanagement.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddCustomerRequest {
    private CustomerDTO customerDTO;
}
