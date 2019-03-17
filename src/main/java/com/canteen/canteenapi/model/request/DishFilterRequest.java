package com.canteen.canteenapi.model.request;

import com.canteen.canteenapi.model.DishCategory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class DishFilterRequest {
    private UUID canteenUid;
    private DishCategory category;

    @JsonCreator
    public DishFilterRequest(
            @JsonProperty("canteenUid") UUID canteenUid,
            @JsonProperty("category") DishCategory category) {
        this.canteenUid = canteenUid;
        this.category = category;
    }

    public UUID getCanteenUid() {
        return canteenUid;
    }

    public void setCanteenUid(UUID canteenUid) {
        this.canteenUid = canteenUid;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }
}
