package com.expatrio.cabmanagement.dto.booking;

import com.expatrio.cabmanagement.dto.car.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GetAvailableCarsResponse {
    private List<CarDTO> availableCarList;
}
