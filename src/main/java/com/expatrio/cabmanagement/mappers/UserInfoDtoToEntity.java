package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.customer.UserInfoDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressDtoToEntityMapper.class, ContactDtoToEntityMapper.class})
public interface UserInfoDtoToEntity {

    @Mapping(target = "id", ignore = true)
    UserInfoEntity dtoToEntity(UserInfoDTO userInfoDTO);

//    @Mapping(target = "address", source = "address")
//    @Mapping(target = "contact", source = "contact")
    UserInfoDTO entityToDto(UserInfoEntity userInfoEntity);

//    @Mapping(target = "address", source = "address")
//    @Mapping(target = "contact", source = "contact")
    List<UserInfoDTO> entityListToDtoList(List<UserInfoEntity> userInfoEntityList);
}
