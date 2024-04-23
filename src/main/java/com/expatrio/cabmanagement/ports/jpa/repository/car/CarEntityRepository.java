package com.expatrio.cabmanagement.ports.jpa.repository.car;

import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.enums.CarState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {
}
