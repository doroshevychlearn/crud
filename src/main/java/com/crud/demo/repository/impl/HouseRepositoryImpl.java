package com.crud.demo.repository.impl;

import com.crud.demo.entity.House;
import com.crud.demo.repository.HouseRepository;
import org.springframework.stereotype.Repository;
import com.crud.demo.repository.crud.impl.CRUDRepositoryImpl;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Repository
public class HouseRepositoryImpl extends CRUDRepositoryImpl<House, Long> implements HouseRepository {
    private static final String TABLE = "house";
    private static final Class<House> CLASS = House.class;
    private static final String INSERT_SQL = "insert into " +
            TABLE + " (" +
            "created, " +
            "room_count) " +
            "values (?, ?)";
    private static final String UPDATE_SQL = "update " +
            TABLE + " set " +
            "created = ?, " +
            "room_count = ? " +
            "where id = ?";

    public HouseRepositoryImpl() {
        super(TABLE, CLASS);
    }

    @Override
    public void save(House house) {
        if (isNull(house)) {
            throw new IllegalArgumentException("The House must be not null!");
        }
        Long id = house.getId();
        if (nonNull(id) && nonNull(super.getOne(id))) {
            super.save(UPDATE_SQL, house.getCreated(), house.getRoomCount(), id);
        } else {
            super.save(INSERT_SQL, house.getCreated(), house.getRoomCount());
        }
    }
}
