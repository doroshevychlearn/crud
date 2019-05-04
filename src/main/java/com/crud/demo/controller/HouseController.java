package com.crud.demo.controller;

import com.crud.demo.dto.HouseDTO;
import com.crud.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/")
    public ResponseEntity getAllHouses() {
        return ResponseEntity.ok(this.houseService.getAllHouses());
    }


    @PostMapping("/")
    public ResponseEntity saveHouse(@RequestBody HouseDTO house) {
        this.houseService.saveHouse(house);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity updateHouse(@RequestBody HouseDTO house) {
        this.houseService.updateHouse(house);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity deleteHouse(@PathVariable(name = "id") Long id) {
        this.houseService.deleteHouse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getHouseById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.houseService.getHouseById(id));
    }

}
