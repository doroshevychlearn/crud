package com.crud.demo.dto;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
    private Long id;
    private Date created;
    private int roomCount;
}
