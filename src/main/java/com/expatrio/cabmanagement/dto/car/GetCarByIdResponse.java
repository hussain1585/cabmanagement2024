package com.expatrio.cabmanagement.dto.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetCarByIdResponse {
    private CarDTO carDTO;
}
