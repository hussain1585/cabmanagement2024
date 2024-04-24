package com.expatrio.cabmanagement.ports.jpa.repository.customer;

import com.expatrio.cabmanagement.ports.jpa.entity.customer.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity, Integer> {
}
