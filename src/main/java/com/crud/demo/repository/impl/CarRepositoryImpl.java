package com.crud.demo.repository.impl;

import com.crud.demo.entity.Car;
import com.crud.demo.repository.CarRepository;
import org.springframework.stereotype.Repository;
import com.crud.demo.repository.crud.impl.CRUDRepositoryImpl;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Repository
public class CarRepositoryImpl extends CRUDRepositoryImpl<Car, Long> implements CarRepository {
    private static final String TABLE = "car";
    private static final Class<Car> CLASS = Car.class;
    private static final String INSERT_SQL = "insert into " +
            TABLE + " (" +
            "name, " +
            "created, " +
            "door_count) " +
            "values (?, ?, ?)";
    private static final String UPDATE_SQL = "update " +
            TABLE + " set " +
            "name = ?, " +
            "created = ?, " +
            "door_count = ? " +
            "where id = ?";

    public CarRepositoryImpl() {
        super(TABLE, CLASS);
    }

    @Override
    public void save(Car car) {
        if (isNull(car)) {
            throw new IllegalArgumentException("The car must be not null!");
        }
        Long id = car.getId();
        if (nonNull(id) && nonNull(super.getOne(id))) {
            super.save(UPDATE_SQL, car.getName(), car.getCreated(), car.getDoorCount(), id);
        } else {
            super.save(INSERT_SQL, car.getName(), car.getCreated(), car.getDoorCount());
        }
    }
}
