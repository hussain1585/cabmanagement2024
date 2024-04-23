package com.expatrio.cabmanagement.usecases;

import com.expatrio.cabmanagement.dto.booking.BookCarRequest;
import com.expatrio.cabmanagement.enums.CarState;
import com.expatrio.cabmanagement.exceptions.BookingAlreadyExistsException;
import com.expatrio.cabmanagement.exceptions.CarNotFoundException;
import com.expatrio.cabmanagement.exceptions.CustomerNotFoundException;
import com.expatrio.cabmanagement.exceptions.IllegalBookingStateForReservationException;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import com.expatrio.cabmanagement.ports.jpa.repository.booking.BookingEntityRepository;
import com.expatrio.cabmanagement.ports.jpa.repository.car.CarEntityRepository;
import com.expatrio.cabmanagement.ports.jpa.repository.customer.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AddBookingUseCase {

    private final BookingEntityRepository bookingEntityRepository;

    private final CarEntityRepository carEntityRepository;

    private final CustomerEntityRepository customerEntityRepository;

    public BookingEntity reserveCar(int carId, int customerId, LocalDateTime startTime, LocalDateTime endTime) {
        CarEntity carEntity = carEntityRepository.findById(carId).orElseThrow(() -> new CarNotFoundException("car not found with id :" + carId));
        CustomerEntity customerEntity = customerEntityRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("customer not found with id :" + customerId));

        List<BookingEntity> bookingEntityList = bookingEntityRepository.findByCarEntity_Id(carId);
        List<BookingEntity> conflictingBookingLIst = bookingEntityList.stream()
                .filter(booking -> booking.getStartTime().isAfter(startTime) && booking.getEndTime().isBefore(endTime))
                .toList();

        if (!conflictingBookingLIst.isEmpty())
            throw new BookingAlreadyExistsException("Booking already exists for the given time window", conflictingBookingLIst);

        BookingEntity newBookingEntity = BookingEntity.builder()
                .carEntity(carEntity)
                .customerEntity(customerEntity)
                .startTime(startTime)
                .endTime(endTime)
                .state(CarState.RESERVED)
                .build();

        return bookingEntityRepository.save(newBookingEntity);
    }

    public BookingEntity bookCar(int carId, int customerId) {
        CarEntity carEntity = carEntityRepository.findById(carId).orElseThrow(() -> new CarNotFoundException("car not found with id :" + carId));
        CustomerEntity customerEntity = customerEntityRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("customer not found with id :" + customerId));

        BookingEntity reservedBooking = bookingEntityRepository.findByCarEntity_IdAndCustomerEntity_Id(carId, customerId);

        if(!reservedBooking.getState().equals(CarState.RESERVED))
        {
            throw new IllegalBookingStateForReservationException("Car is not reserved for the customer");
        }

        reservedBooking.setState(CarState.RENTED);
        return bookingEntityRepository.save(reservedBooking);
    }
}
