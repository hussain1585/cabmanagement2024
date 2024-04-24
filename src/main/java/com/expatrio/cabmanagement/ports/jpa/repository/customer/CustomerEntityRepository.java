package com.expatrio.cabmanagement.ports.jpa.repository.customer;

import com.expatrio.cabmanagement.ports.jpa.entity.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findByEmail(String email);
}
