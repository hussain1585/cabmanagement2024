package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.customer.CustomerDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerToCustomerEntityMapper {

    CustomerEntity customerDTOToCustomerEntity(CustomerDTO customerDTO);

    CustomerDTO customerEntityToCustomerDTO(CustomerEntity customerEntity);

    List<CustomerDTO> customerEntityListToCustomerDTOList(List<CustomerEntity> customerEntityList);
}
