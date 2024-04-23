package com.expatrio.cabmanagement.ports.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue
    private int id;
    private String address;

    private String email;

}
