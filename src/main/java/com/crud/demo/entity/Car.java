package com.crud.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "age")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "door_count")
    private int doorCount;

    public Car() {
    }

    public Car(Date created, int doorCount) {
        this.created = created;
        this.doorCount = doorCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() &&
                getDoorCount() == car.getDoorCount() &&
                Objects.equals(getCreated(), car.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreated(), getDoorCount());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", created=" + created +
                ", doorCount=" + doorCount +
                '}';
    }

    public static class Builder {

        private Date created;
        private int doorCount;

        public Builder() {
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder roomCount(int doorCount) {
            this.doorCount = doorCount;
            return this;
        }

        public Car build() {
            return new Car(created, doorCount);
        }

    }

}
