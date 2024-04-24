package com.expatrio.cabmanagement.api;

import com.expatrio.cabmanagement.dto.booking.*;
import com.expatrio.cabmanagement.dto.car.CarDTO;
import com.expatrio.cabmanagement.dto.car.ReserveCarResponse;
import com.expatrio.cabmanagement.mappers.BookingDtoToEntityMapper;
import com.expatrio.cabmanagement.mappers.CarEntityToDtoMapper;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.usecases.AddBookingUseCase;
import com.expatrio.cabmanagement.usecases.GetBookingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/booking")
public class BookingController {

    private final GetBookingUseCase getBookingUseCase;

    private final AddBookingUseCase addBookingUseCase;
    private final BookingDtoToEntityMapper bookingMapper;
    private final CarEntityToDtoMapper carMapper;

    @GetMapping("/getBookingById")
    public GetBookingByIdResponse gerBookingById(@RequestParam int id) {
        BookingEntity bookingEntity = getBookingUseCase.getBookingById(id);
        BookingDTO bookingDTO = bookingMapper.entityToDto(bookingEntity);
        return GetBookingByIdResponse.builder().bookingDTO(bookingDTO).build();
    }

    @GetMapping("/getAllBookings")
    public GetAllBookingResponse getAllBookings() {
        List<BookingEntity> bookingEntityList = getBookingUseCase.getAllBookings();
        List<BookingDTO> bookingDTOList = bookingMapper.entityListToDtoList(bookingEntityList);
        return GetAllBookingResponse.builder().bookingDTOList(bookingDTOList).build();
    }


    @GetMapping("/getAvailableCars")
    public GetAvailableCarsResponse getAvailableCars(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
                                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime) {
        List<CarEntity> availableCars = getBookingUseCase.getAvailableCars(startTime, endTime);
        List<CarDTO> cars = carMapper.entityListToDtoList(availableCars);
        return GetAvailableCarsResponse.builder().availableCarList(cars).build();
    }

    @PostMapping("/reserveCar")
    public ReserveCarResponse reserveCar(@RequestParam int carId,
                                         @RequestParam int customerId,
                                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
                                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime) {
        BookingEntity reservedCarEntity = addBookingUseCase.reserveCar(carId, customerId, startTime, endTime);
        CarDTO reservedCarDTO = carMapper.entityToDto(reservedCarEntity.getCar());
        return ReserveCarResponse.builder().reservedCar(reservedCarDTO).build();
    }


    @PostMapping("/bookCar")
    public BookingEntity bookCar(@RequestParam int carId, @RequestParam int customerId) {

        return addBookingUseCase.bookCar(carId, customerId);
    }
}
