package com.expatrio.cabmanagement.usecases;

import com.expatrio.cabmanagement.exceptions.BookingDoesNotExistException;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.ports.jpa.repository.booking.BookingEntityRepository;
import com.expatrio.cabmanagement.ports.jpa.repository.car.CarEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetBookingUseCase {

    private final BookingEntityRepository bookingEntityRepository;

    private final CarEntityRepository carEntityRepository;

    public BookingEntity getBookingById(int id) {
        return bookingEntityRepository.findById(id).orElseThrow(()-> new BookingDoesNotExistException("Booking not found with Id " + id));
    }

    public List<BookingEntity> getAllBookings() {
        return bookingEntityRepository.findAll();
    }

    public List<CarEntity> getAvailableCars(LocalDateTime startTime, LocalDateTime endTime) {

//        LocalDateTime startTime = addBookingRequest.getStartTime();
//        LocalDateTime endTime = addBookingRequest.getEndTime();
//        CarEntity carEntity = carEntityRepository.findById(addBookingRequest.getCarId())
//                .orElseThrow(() -> new CarNotFoundException("car not found with id :" + addBookingRequest.getCarId()));
//        CustomerEntity customerEntity = customerEntityRepository.findById(addBookingRequest.getCustomerId())
//                .orElseThrow(() -> new CustomerNotFoundException("customer not found with id :" + addBookingRequest.getCarId()));

        List<BookingEntity> bookingInTimeWindow = bookingEntityRepository.findByStartTimeGreaterThanEqualOrEndTimeLessThanEqual(startTime, endTime);
        Set<CarEntity> carSetWithConflictingBooking = bookingInTimeWindow.stream().map(BookingEntity::getCar).collect(Collectors.toSet());
        List<CarEntity> allCars = carEntityRepository.findAll();
        allCars.removeAll(carSetWithConflictingBooking);
        return allCars;
    }
}
