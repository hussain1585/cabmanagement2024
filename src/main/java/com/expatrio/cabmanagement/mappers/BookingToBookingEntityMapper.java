package com.expatrio.cabmanagement.mappers;

import com.expatrio.cabmanagement.dto.booking.BookingDTO;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingToBookingEntityMapper {

    BookingEntity bookingDTOToBookingEntity(BookingDTO bookingDTO);

    BookingDTO bookingEntityToBookingDTO(BookingEntity bookingEntity);

    List<BookingDTO> bookingEntityListToBookingDTOList(List<BookingEntity> bookingEntityList);
}
