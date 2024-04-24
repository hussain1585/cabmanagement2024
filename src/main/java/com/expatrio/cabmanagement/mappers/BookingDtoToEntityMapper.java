package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.booking.BookingDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarEntityToDtoMapper.class, CustomerDtoToEntityMapper.class})
public interface BookingDtoToEntityMapper {

    @Mapping(target = "car.id", source = "carId")
    @Mapping(target = "customer.id", source = "customerId")
    BookingEntity dtoToEntity(BookingDTO bookingDTO);

    @Mapping(source = "car.id", target = "carId")
    @Mapping(source = "customer.id", target = "customerId")
    BookingDTO entityToDto(BookingEntity bookingEntity);

    List<BookingDTO> entityListToDtoList(List<BookingEntity> bookingEntityList);
}
