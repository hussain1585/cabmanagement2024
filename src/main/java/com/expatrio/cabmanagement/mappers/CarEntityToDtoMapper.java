package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.car.CarDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarEntityToDtoMapper {

    CarEntity dtoToEntity(CarDTO carDTO);

    CarDTO entityToDto(CarEntity carEntity);

    List<CarDTO> entityListToDtoList(List<CarEntity> carEntityList);
}
