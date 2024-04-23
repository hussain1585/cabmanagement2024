package com.expatrio.cabmanagement.dto.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private int id;
    private String make;
    private String model;
    private String color;
    private int releaseYear;
    private double pricePerHour;
}
