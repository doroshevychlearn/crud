package com.crud.demo.repository;

import com.crud.demo.entity.Car;
import com.crud.demo.repository.crud.CRUDRepository;

public interface CarRepository extends CRUDRepository<Car, Long> {
    void save(Car car);
}
