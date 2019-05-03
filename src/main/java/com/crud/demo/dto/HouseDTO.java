package com.crud.demo.dto;

import java.util.Date;

public class HouseDTO {
    private Date created;
    private int roomCount;

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
    public String toString() {
        return "HouseDTO{" +
                "created=" + created +
                ", roomCount=" + roomCount +
                '}';
    }
}
