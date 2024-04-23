package com.expatrio.cabmanagement.dto.car;

import com.expatrio.cabmanagement.enums.CarState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddCarResponse {
    private CarDTO carDTO;
}
