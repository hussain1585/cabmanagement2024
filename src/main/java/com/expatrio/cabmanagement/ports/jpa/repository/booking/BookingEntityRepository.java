package com.expatrio.cabmanagement.ports.jpa.repository.booking;

import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingEntityRepository extends JpaRepository<BookingEntity, Integer> {
    BookingEntity findByCarEntity_IdAndCustomerEntity_Id(int id, int id1);
    List<BookingEntity> findByStartTimeGreaterThanEqualOrEndTimeLessThanEqual(LocalDateTime startTime, LocalDateTime endTime);
    List<BookingEntity> findByCarEntity_Id(int id);
}
