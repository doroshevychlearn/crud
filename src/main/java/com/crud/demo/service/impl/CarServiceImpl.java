package com.crud.demo.service.impl;

import com.crud.demo.dto.CarDTO;
import com.crud.demo.entity.Car;
import com.crud.demo.service.CarService;
import org.springframework.stereotype.Service;
import com.crud.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void deleteCar(Long id) {
        this.carRepository.delete(id);
    }

    @Override
    public Set<CarDTO> getAllCars() {
        List<Car> cars = this.carRepository.findAll();
        if (isNull(cars)) {
            cars = new ArrayList<>();
        }
        return cars.stream().map(car -> CarDTO.builder()
                .id(car.getId())
                .name(car.getName())
                .created(car.getCreated())
                .doorCount(car.getDoorCount())
                .build()).collect(Collectors.toSet());
    }

    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = Car.builder()
                .id(carDTO.getId())
                .name(carDTO.getName())
                .created(new Date())
                .doorCount(carDTO.getDoorCount())
                .build();
        this.carRepository.save(car);
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        Car car = this.carRepository.getOne(carDTO.getId());
        if (nonNull(car)) {
            car = Car.builder()
                    .id(carDTO.getId())
                    .name(carDTO.getName())
                    .created(new Date())
                    .doorCount(carDTO.getDoorCount())
                    .build();
            this.carRepository.save(car);
        } else {
            throw new IllegalArgumentException("The house does not exist!");
        }
    }

    @Override
    public CarDTO getCarById(Long id) {
        CarDTO carDTO = new CarDTO();
        Car car = this.carRepository.getOne(id);
        if (nonNull(car)) {
            carDTO = CarDTO.builder()
                    .id(car.getId())
                    .name(car.getName())
                    .created(car.getCreated())
                    .doorCount(car.getDoorCount())
                    .build();
        }
        return carDTO;
    }

}
