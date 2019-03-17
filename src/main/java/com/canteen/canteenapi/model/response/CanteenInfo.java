package com.canteen.canteenapi.model.response;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.Instant;
import java.util.UUID;

public class CanteenInfo {

    private UUID canteenUid;
    private String name;
    private String building;
    private String location;
    private Instant workFromMillis;
    private Instant workTillMillis;
    private String imageUrl;

    public CanteenInfo(
            UUID canteenUid,
            String name,
            String building,
            String location,
            Instant workFromMillis,
            Instant workTillMillis,
            String imageUrl) {
        this.canteenUid = canteenUid;
        this.name = name;
        this.building = building;
        this.location = location;
        this.workFromMillis = workFromMillis;
        this.workTillMillis = workTillMillis;
        this.imageUrl = imageUrl;
    }

    @JsonGetter("canteenUid")
    public UUID getCanteenUid() {
        return canteenUid;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("building")
    public String getBuilding() {
        return building;
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

    @JsonGetter("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }
}
