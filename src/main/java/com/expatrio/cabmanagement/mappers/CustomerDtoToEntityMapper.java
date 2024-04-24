package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.customer.CustomerDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerDtoToEntityMapper {

    CustomerEntity dtoToEntity(CustomerDTO customerDTO);

    CustomerDTO entityToDto(CustomerEntity customerEntity);

    List<CustomerDTO> entityListToDtoList(List<CustomerEntity> customerEntityList);
}
