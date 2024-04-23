package com.expatrio.cabmanagement.dto.car;

import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UpdateCarResponse {
    private CarDTO car;
}
