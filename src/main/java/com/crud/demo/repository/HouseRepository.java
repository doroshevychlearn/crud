package com.crud.demo.repository;

import com.crud.demo.entity.House;
import com.crud.demo.repository.crud.CRUDRepository;

public interface HouseRepository extends CRUDRepository<House, Long> {
    void save(House house);
}
