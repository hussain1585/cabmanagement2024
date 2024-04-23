package com.expatrio.cabmanagement.dto.customer;

import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UpdateCustomerRequest {
    private CustomerDTO customerDTO;
}
