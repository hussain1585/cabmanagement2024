package com.expatrio.cabmanagement.api;

import com.expatrio.cabmanagement.dto.car.*;
import com.expatrio.cabmanagement.mappers.CarEntityToDtoMapper;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.usecases.GetCarUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/cars")
public class CabController {

    private final GetCarUseCase getCarUseCase;

    private final CarEntityToDtoMapper mapper;

    @PostMapping("/addCar")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public AddCarResponse addCar(@RequestBody AddCarRequest addCarRequest) {
        CarEntity carEntity = getCarUseCase.addCar(addCarRequest.getCarDTO());
        CarDTO carDTO = mapper.entityToDto(carEntity);
        return AddCarResponse.builder().carDTO(carDTO).build();
    }

    @PostMapping("/addCars")
    public AddCarsResponse addCars(@RequestBody AddCarsRequest addCarsRequest) {
        List<CarEntity> carEntities = getCarUseCase.addCarList(addCarsRequest.getCarList());
        List<CarDTO> cars = mapper.entityListToDtoList(carEntities);
        return AddCarsResponse.builder().cars(cars).build();
    }

    @GetMapping("/getCarById")
    public GetCarByIdResponse gerCarById(@RequestParam int id) {
        CarEntity carEntity = getCarUseCase.gerCarById(id);
        CarDTO carDTO = mapper.entityToDto(carEntity);
        return GetCarByIdResponse.builder().carDTO(carDTO).build();
    }

    @GetMapping("/getAllCars")
    public GetAllCarsResponse getAllCars() {
        List<CarEntity> allCars = getCarUseCase.getAllCars();
        List<CarDTO> carDTOList = mapper.entityListToDtoList(allCars);
        return GetAllCarsResponse.builder().carList(carDTOList).build();
    }


    @PutMapping("/updateCar")
    public UpdateCarResponse updateCar(@RequestBody UpdateCarRequest updateCarRequest) {
        CarEntity carEntity = getCarUseCase.updateCar(updateCarRequest.getCar());
        CarDTO carDTO = mapper.entityToDto(carEntity);
        return UpdateCarResponse.builder().car(carDTO).build();
    }

    @DeleteMapping("/deleteCar")
    public void deleteCar(@RequestParam int id) {
        getCarUseCase.deleteCar(id);
    }
}
