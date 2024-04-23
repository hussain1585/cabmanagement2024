package com.expatrio.cabmanagement.usecases;

import com.expatrio.cabmanagement.dto.car.*;
import com.expatrio.cabmanagement.exceptions.CarNotFoundException;
import com.expatrio.cabmanagement.mappers.CarToCarEntityMapper;
import com.expatrio.cabmanagement.ports.jpa.entity.CarEntity;
import com.expatrio.cabmanagement.ports.jpa.repository.car.CarEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCarUseCase {

    private final CarEntityRepository carEntityRepository;
    private final CarToCarEntityMapper mapper;

    public CarEntity gerCarById(int id) {
        return carEntityRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found with Id: " + id));
    }

    public List<CarEntity> getAllCars() {
        return carEntityRepository.findAll();
    }

    public CarEntity addCar(CarDTO carDTO) {
        CarEntity carEntity = mapper.carDTOToCarEntity(carDTO);
        return carEntityRepository.save(carEntity);
    }

    public List<CarEntity> addCarList(List<CarDTO> carList) {
        return carList.stream().map(carDTO -> addCar(carDTO)).toList();
    }

    public CarEntity updateCar(CarDTO carDTO) {
        carEntityRepository.findById(carDTO.getId()).orElseThrow(() -> new CarNotFoundException("Car not found with Id: " + carDTO.getId()));
        CarEntity carEntity = mapper.carDTOToCarEntity(carDTO);
        return carEntityRepository.save(carEntity);
    }

    public void deleteCar(Integer carId) {
        carEntityRepository.deleteById(carId);
    }
}
