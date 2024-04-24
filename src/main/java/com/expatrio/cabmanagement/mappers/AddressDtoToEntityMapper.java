package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.customer.AddressDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressDtoToEntityMapper {
    @Mapping(target = "id", ignore = true)
    AddressEntity dtoToEntity(AddressDTO addressDTO);
    AddressDTO entityToDto(AddressEntity addressEntity);
    List<AddressDTO> entityListToDtoList(List<AddressEntity> addressEntityList);

}
