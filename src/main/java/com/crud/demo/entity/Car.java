package com.crud.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "door_count")
    private int doorCount;

    public Car() {
    }

    public Car(String name, Date created, int doorCount) {
        this.name = name;
        this.created = created;
        this.doorCount = doorCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                doorCount == car.doorCount &&
                Objects.equals(name, car.name) &&
                Objects.equals(created, car.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, doorCount);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", doorCount=" + doorCount +
                '}';
    }

    public static class Builder {

        private String name;
        private Date created;
        private int doorCount;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
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
            return new Car(name, created, doorCount);
        }

    }

}
