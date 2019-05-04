package com.crud.demo.service.impl;

import com.crud.demo.dto.HouseDTO;
import com.crud.demo.entity.House;
import com.crud.demo.service.HouseService;
import org.springframework.stereotype.Service;
import com.crud.demo.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void deleteHouse(Long id) {
        this.houseRepository.delete(id);
    }

    @Override
    public Set<HouseDTO> getAllHouses() {
        List<House> houses = this.houseRepository.findAll();
        if (isNull(houses)) {
            houses = new ArrayList<>();
        }
        return houses.stream().map(house -> HouseDTO.builder()
                .id(house.getId())
                .created(house.getCreated())
                .roomCount(house.getRoomCount())
                .build()).collect(Collectors.toSet());
    }

    @Override
    public void saveHouse(HouseDTO houseDTO) {
        House house = House.builder()
                .created(new Date())
                .roomCount(houseDTO.getRoomCount())
                .build();
        this.houseRepository.save(house);
    }

    @Override
    public void updateHouse(HouseDTO houseDTO) {
        House house = this.houseRepository.getOne(houseDTO.getId());
        if (nonNull(house)) {
            house = House.builder()
                    .id(houseDTO.getId())
                    .created(new Date())
                    .roomCount(houseDTO.getRoomCount())
                    .build();
            this.houseRepository.save(house);
        } else {
            throw new IllegalArgumentException("The house does not exist!");
        }
    }

    @Override
    public HouseDTO getHouseById(Long id) {
        HouseDTO houseDTO = new HouseDTO();
        House house = this.houseRepository.getOne(id);
        if (nonNull(house)) {
            houseDTO = HouseDTO.builder()
                    .id(house.getId())
                    .created(house.getCreated())
                    .roomCount(house.getRoomCount())
                    .build();
        }
        return houseDTO;
    }

}
