package com.expatrio.cabmanagement.ports.jpa.repository.booking;

import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingEntityRepository extends JpaRepository<BookingEntity, Integer> {
    BookingEntity findByCar_IdAndCustomer_Id(int carId, int customerId);

    List<BookingEntity> findByStartTimeGreaterThanEqualOrEndTimeLessThanEqual(LocalDateTime startTime, LocalDateTime endTime);
    List<BookingEntity> findByCar_Id(int carId);


}
