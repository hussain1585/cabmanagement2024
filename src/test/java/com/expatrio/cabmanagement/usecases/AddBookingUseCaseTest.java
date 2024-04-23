package com.expatrio.cabmanagement.usecases;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
class AddBookingUseCaseTest {

    @Autowired
    AddBookingUseCase addBookingUseCase;

    @Test
    void check() {
        LocalDateTime start = LocalDateTime.parse("2024-04-18T08:00:00");
        LocalDateTime end = LocalDateTime.parse("2024-04-18T12:00:00");

        // valid
        LocalDateTime s1 = LocalDateTime.parse("2024-04-18T05:00:00");
        LocalDateTime e1 = LocalDateTime.parse("2024-04-18T07:00:00");

        // valid
        LocalDateTime s2 = LocalDateTime.parse("2024-04-18T13:00:00");
        LocalDateTime e2 = LocalDateTime.parse("2024-04-18T15:00:00");

        // invalid
        LocalDateTime s3 = LocalDateTime.parse("2024-04-18T05:00:00");
        LocalDateTime e3 = LocalDateTime.parse("2024-04-18T10:00:00");

        // invalid
        LocalDateTime s4 = LocalDateTime.parse("2024-04-18T10:00:00");
        LocalDateTime e4 = LocalDateTime.parse("2024-04-18T15:00:00");

        // invalid
        LocalDateTime s5 = LocalDateTime.parse("2024-04-18T08:00:00");
        LocalDateTime e5 = LocalDateTime.parse("2024-04-18T12:00:00");

        // invalid
        LocalDateTime s6 = LocalDateTime.parse("2024-04-18T05:00:00");
        LocalDateTime e6 = LocalDateTime.parse("2024-04-18T15:00:00");

        // invalid
        LocalDateTime s7 = LocalDateTime.parse("2024-04-18T05:00:00");
        LocalDateTime e7 = LocalDateTime.parse("2024-04-18T08:00:00");

        // invalid
        LocalDateTime s8 = LocalDateTime.parse("2024-04-18T12:00:00");
        LocalDateTime e8 = LocalDateTime.parse("2024-04-18T15:00:00");


        boolean b1 = check2(start, end, s1,e1);
        boolean b2 = check2(start, end, s2,e2);
        boolean b3 = check2(start, end, s3,e3);
        boolean b4 = check2(start, end, s4,e4);
        boolean b5 = check2(start, end, s5,e5);
        boolean b6 = check2(start, end, s6,e6);
        boolean b7 = check2(start, end, s7,e7);
        boolean b8 = check2(start, end, s8,e8);


        System.out.println();

        assertTrue(b1);

    }

    private boolean check2(LocalDateTime start, LocalDateTime end, LocalDateTime s1, LocalDateTime e1) {
        boolean b1 = start.isAfter(e1) || end.isBefore(s1);

        //boolean b = (start.isEqual(s1) && end.isEqual(e1));
        return b1 ;
    }
}