package com.expatrio.cabmanagement.ports.jpa.repository.booking;

import com.expatrio.cabmanagement.exceptions.CarNotFoundException;
import com.expatrio.cabmanagement.exceptions.CustomerNotFoundException;
import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import com.expatrio.cabmanagement.ports.jpa.repository.car.CarEntityRepository;
import com.expatrio.cabmanagement.ports.jpa.repository.customer.CustomerEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookingEntityRepositoryTest {

    @Autowired
    private BookingEntityRepository bookingEntityRepository;

    @MockBean
    private CarEntityRepository carEntityRepository;

    @MockBean
    private CustomerEntityRepository customerEntityRepository;

//    @Test
    public void testSaveBooking(){
        CarEntity carEntity = carEntityRepository.findById(1).get();
        CustomerEntity customerEntity = customerEntityRepository.findById(1).get();
        BookingEntity booking = BookingEntity.builder()
                .startTime(LocalDateTime.parse("2024-04-18T10:00:00"))
                .endTime(LocalDateTime.parse("2024-04-18T11:30:00"))
                .carEntity(carEntity)
                .customerEntity(customerEntity)
                .build();

        BookingEntity save = bookingEntityRepository.save(booking);
        System.out.println();

    }

    @Test
    public void testUpdateBooking(){}

    @Test
    public void testDeleteBooking(){}

    @Test
    public void testGetBooking(){}


//    @Test
//    public void testFindByCarEntityId() {
//        // Given
//        int carId = 123;
//        CarEntity carEntity = new CarEntity();
//        carEntity.setId(carId);
//
//        BookingEntity booking1 = new BookingEntity(); // create BookingEntity objects as needed
//        BookingEntity booking2 = new BookingEntity();
//        List<BookingEntity> bookings = new ArrayList<>();
//        bookings.add(booking1);
//        bookings.add(booking2);
//
//        // Mocking the behavior of the repository method
//        when(carEntityRepository.findById(carId)).thenReturn(java.util.Optional.ofNullable(carEntity));
//        when(bookingEntityRepository.findByCarEntity_Id(carId)).thenReturn(bookings);
//
//        // When
//        List<BookingEntity> result = bookingEntityRepository.findByCarEntity_Id(carId);
//
//        // Then
//        assertEquals(2, result.size()); // Assuming there are two bookings for the given car ID
//        // Add more assertions as needed
//    }

}