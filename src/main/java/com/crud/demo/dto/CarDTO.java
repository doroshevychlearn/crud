package com.crud.demo.dto;

import java.util.Date;

public class CarDTO {
    private String name;
    private Date created;
    private int doorCount;

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
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", doorCount=" + doorCount +
                '}';
    }
}
