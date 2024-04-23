package com.expatrio.cabmanagement.api;

import com.expatrio.cabmanagement.dto.car.*;
import com.expatrio.cabmanagement.mappers.CarToCarEntityMapper;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.usecases.GetCarUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/cars")
public class CabController {

    private final GetCarUseCase getCarUseCase;

    private final CarToCarEntityMapper mapper;

    @PostMapping("/addCar")
    public AddCarResponse addCar(@RequestBody AddCarRequest addCarRequest) {
        CarEntity carEntity = getCarUseCase.addCar(addCarRequest.getCarDTO());
        CarDTO carDTO = mapper.carEntityToCarDTO(carEntity);
        return AddCarResponse.builder().carDTO(carDTO).build();
    }

    @PostMapping("/addCars")
    public AddCarsResponse addCars(@RequestBody AddCarsRequest addCarsRequest) {
        List<CarEntity> carEntities = getCarUseCase.addCarList(addCarsRequest.getCarList());
        List<CarDTO> cars = mapper.carEntityListToCarDTOList(carEntities);
        return AddCarsResponse.builder().cars(cars).build();
    }

    @GetMapping("/getCarById")
    public GetCarByIdResponse gerCarById(@RequestParam int id) {
        CarEntity carEntity = getCarUseCase.gerCarById(id);
        CarDTO carDTO = mapper.carEntityToCarDTO(carEntity);
        return GetCarByIdResponse.builder().carDTO(carDTO).build();
    }

    @GetMapping("/getAllCars")
    public GetAllCarsResponse getAllCars() {
        List<CarEntity> allCars = getCarUseCase.getAllCars();
        List<CarDTO> carDTOList = mapper.carEntityListToCarDTOList(allCars);
        return GetAllCarsResponse.builder().carList(carDTOList).build();
    }


    @PutMapping("/updateCar")
    public UpdateCarResponse updateCar(@RequestBody UpdateCarRequest updateCarRequest) {
        CarEntity carEntity = getCarUseCase.updateCar(updateCarRequest.getCar());
        CarDTO carDTO = mapper.carEntityToCarDTO(carEntity);
        return UpdateCarResponse.builder().car(carDTO).build();
    }

    @DeleteMapping("/deleteCar")
    public void deleteCar(@RequestParam int id) {
        getCarUseCase.deleteCar(id);
    }
}
