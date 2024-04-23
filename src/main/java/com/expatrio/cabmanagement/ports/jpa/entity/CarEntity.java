package com.expatrio.cabmanagement.ports.jpa.entity;

import com.expatrio.cabmanagement.enums.CarState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    //Each car in the system should have a unique identifier, make, model, year ,price
    //per hour, and current state (available, reserved, rented).

    @Id
    @GeneratedValue
    private int id;
    private String make;
    private String model;
    private String color;
    private int releaseYear;
    private double pricePerHour;
//    private String state;
//    @Enumerated(EnumType.STRING)
//    private CarState state;

}
