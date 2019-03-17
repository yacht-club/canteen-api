package com.canteen.canteenapi.model.response;

import com.canteen.canteenapi.model.DishCategory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DishCategoryInfo {
    private DishCategory name;
    private String description;

    @JsonCreator
    public DishCategoryInfo(
            @JsonProperty("name") DishCategory name,
            @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    @JsonGetter("name")
    public DishCategory getName() {
        return name;
    }

    public void setName(DishCategory name) {
        this.name = name;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
