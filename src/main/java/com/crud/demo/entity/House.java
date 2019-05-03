package com.crud.demo.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "room_count")
    private int roomCount;

    public House() {
    }

    public House(Date created, int roomCount) {
        this.created = created;
        this.roomCount = roomCount;
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

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return getId() == house.getId() &&
                getRoomCount() == house.getRoomCount() &&
                Objects.equals(getCreated(), house.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreated(), getRoomCount());
    }

    public static class Builder {

        private Date created;
        private int roomCount;

        public Builder() {
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder roomCount(int roomCount) {
            this.roomCount = roomCount;
            return this;
        }

        public House build() {
            return new House(created, roomCount);
        }

    }
}
