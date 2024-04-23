package com.expatrio.cabmanagement.usecases;

import com.expatrio.cabmanagement.ports.jpa.entity.BookingEntity;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.enums.CarState;
import com.expatrio.cabmanagement.ports.jpa.entity.CustomerEntity;
import com.expatrio.cabmanagement.ports.jpa.repository.booking.BookingEntityRepository;
import com.expatrio.cabmanagement.ports.jpa.repository.car.CarEntityRepository;
import com.expatrio.cabmanagement.ports.jpa.repository.customer.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BootUpUseCase implements CommandLineRunner {

    private final CarEntityRepository carEntityRepository;
    private final CustomerEntityRepository customerEntityRepository;

    private final BookingEntityRepository bookingEntityRepository;

    private List<CarEntity> cars;
    private List<CustomerEntity> customers;

    private CarEntity carAudi, carMerc, carBMW, carTata, carFord, carHonda, carHyundai, carSuzuki, carKia, carFiat, carRenault;

    private CustomerEntity customer1, customer2, customer3, customer4, customer5;

    @Override
    public void run(String... args) throws Exception {
//        bootUpCars();
//        bootUpCustomers();
        //bootUpBookings();
    }

    private void bootUpCars() {
        carAudi = CarEntity.builder().make("AUDI").model("Q3").color("BLUE").releaseYear(2024).pricePerHour(10).build();
        carMerc = CarEntity.builder().make("MERCEDES").model("MAYBACH").color("WHITE").releaseYear(2024).pricePerHour(11).build();
        carBMW = CarEntity.builder().make("BMW").model("X4").color("BLACK").releaseYear(2024).pricePerHour(12).build();
        carTata = CarEntity.builder().make("TATA").model("ALTROZ").color("RED").releaseYear(2024).pricePerHour(13).build();
        carFord = CarEntity.builder().make("FORD").model("FIGO").color("BLUE").releaseYear(2024).pricePerHour(14).build();
        carHonda = CarEntity.builder().make("HONDA").model("AMAZE").color("WHITE").releaseYear(2024).pricePerHour(15).build();
        carHyundai = CarEntity.builder().make("HYUNDAI").model("CRETA").color("BLACK").releaseYear(2024).pricePerHour(16).build();
        carSuzuki = CarEntity.builder().make("SUZUKI").model("CIAZ").color("RED").releaseYear(2024).pricePerHour(17).build();
        carKia = CarEntity.builder().make("KIA").model("SONNET").color("BLUE").releaseYear(2024).pricePerHour(18).build();
        carFiat = CarEntity.builder().make("FIAT").model("PUNTO").color("WHITE").releaseYear(2024).pricePerHour(19).build();
        carRenault = CarEntity.builder().make("RENAULT").model("DUSTER").color("BLACK").releaseYear(2024).pricePerHour(20).build();
        cars = List.of(carAudi, carMerc, carBMW, carTata, carFord, carHonda, carHyundai, carSuzuki, carKia, carFiat, carRenault);
        carEntityRepository.saveAll(cars);
    }

    private void bootUpCustomers() {
        customer1 = CustomerEntity.builder().email("a1@gmail.com").address("BERLIN").build();
        customer2 = CustomerEntity.builder().email("a2@gmail.com").address("BERLIN").build();
        customer3 = CustomerEntity.builder().email("a3@gmail.com").address("BERLIN").build();
        customer4 = CustomerEntity.builder().email("a4@gmail.com").address("BERLIN").build();
        customer5 = CustomerEntity.builder().email("a5@gmail.com").address("BERLIN").build();
        customers = List.of(customer1, customer2, customer3, customer4, customer5);
        customerEntityRepository.saveAll(customers);
    }

    private void bootUpBookings() {
        LocalDateTime startTime = LocalDateTime.now();
        List<BookingEntity> bookingList = new ArrayList<>();

        for (CustomerEntity customer : customers) {
            for (CarEntity car : cars) {
                BookingEntity booking = BookingEntity.builder()
                        .customerEntity(customer)
//                        .carEntity(car)
                        .startTime(startTime)
                        .endTime(startTime.plusMinutes(240))
                        .build();
                bookingList.add(booking);
                bookingEntityRepository.save(booking);
                startTime = startTime.plusMinutes(30);
            }
        }
    }

}
