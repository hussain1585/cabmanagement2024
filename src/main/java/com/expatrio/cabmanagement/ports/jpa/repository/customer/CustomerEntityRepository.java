package com.expatrio.cabmanagement.ports.jpa.repository.customer;

import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findByEmail(String email);
}
