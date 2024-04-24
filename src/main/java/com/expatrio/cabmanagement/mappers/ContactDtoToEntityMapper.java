package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.customer.ContactDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactDtoToEntityMapper {
    @Mapping(target = "id", ignore = true)
    ContactEntity dtoToEntity(ContactDTO contactDTO);

    ContactDTO entityToDto(ContactEntity contactEntity);

    List<ContactDTO> entityListToDtoList(List<ContactEntity> contactEntityList);
}
