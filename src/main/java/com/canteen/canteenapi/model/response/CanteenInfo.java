package com.canteen.canteenapi.model.response;

import com.canteen.canteenapi.model.entity.DishEntity;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public class CanteenInfo {

    private UUID canteenUid = UUID.randomUUID();
    private String name;
    private String location;
    private Instant workFromMillis;
    private Instant workTillMillis;
    private Set<DishEntity> dishes;

    public CanteenInfo(
            UUID canteenUid,
            String name,
            String location,
            Instant workFromMillis,
            Instant workTillMillis,
            Set<DishEntity> dishes) {
        this.canteenUid = canteenUid;
        this.name = name;
        this.location = location;
        this.workFromMillis = workFromMillis;
        this.workTillMillis = workTillMillis;
        this.dishes = dishes;
    }

    @JsonGetter("canteenUid")
    public UUID getCanteenUid() {
        return canteenUid;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("location")
    public String getLocation() {
        return location;
    }

    @JsonGetter("workFromMillis")
    public Instant getWorkFromMillis() {
        return workFromMillis;
    }

    @JsonGetter("workTillMillis")
    public Instant getWorkTillMillis() {
        return workTillMillis;
    }

    @JsonGetter("dishes")
    public Set<DishEntity> getDishes() {
        return dishes;
    }
}
