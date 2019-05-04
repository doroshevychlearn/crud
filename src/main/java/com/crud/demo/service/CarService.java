package com.crud.demo.service;

import java.util.Set;
import com.crud.demo.dto.CarDTO;

public interface CarService {

    void deleteCar(Long id);

    Set<CarDTO> getAllCars();

    CarDTO getCarById(Long id);

    void saveCar(CarDTO houseDTO);

    void updateCar(CarDTO houseDTO);

}
