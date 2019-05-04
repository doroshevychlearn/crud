package com.crud.demo.controller;

import com.crud.demo.dto.CarDTO;
import com.crud.demo.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public ResponseEntity getAllCars() {
        return ResponseEntity.ok(this.carService.getAllCars());
    }


    @PostMapping("/")
    public ResponseEntity saveCar(@RequestBody CarDTO car) {
        this.carService.saveCar(car);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity updateCar(@RequestBody CarDTO car) {
        this.carService.updateCar(car);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable(name = "id") Long id) {
        this.carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.carService.getCarById(id));
    }

}
