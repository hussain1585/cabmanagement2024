package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.car.CarDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarToCarEntityMapper {

    CarEntity carDTOToCarEntity(CarDTO carDTO);

    CarDTO carEntityToCarDTO(CarEntity carEntity);

    List<CarDTO> carEntityListToCarDTOList(List<CarEntity> carEntityList);
}
