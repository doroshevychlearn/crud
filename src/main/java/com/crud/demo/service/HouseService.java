package com.crud.demo.service;

import java.util.Set;
import com.crud.demo.dto.HouseDTO;

public interface HouseService {

    void deleteHouse(Long id);

    Set<HouseDTO> getAllHouses();

    HouseDTO getHouseById(Long id);

    void saveHouse(HouseDTO houseDTO);

    void updateHouse(HouseDTO houseDTO);

}
