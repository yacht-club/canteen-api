package com.canteen.canteenapi.model.response;

import com.canteen.canteenapi.model.DishCategory;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.UUID;

public class DishInfo {

    private UUID dishUid;
    private DishCategory category;
    private String name;
    private Integer price;
    private Integer weight;
    private Double calories;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;
    private UUID canteenUid;

    public DishInfo(
            UUID dishUid,
            DishCategory category,
            String name,
            Integer price,
            Integer weight,
            Double calories,
            Double proteins,
            Double fats,
            Double carbohydrates,
            UUID canteenUid) {
        this.dishUid = dishUid;
        this.category = category;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.canteenUid = canteenUid;
    }

    @JsonGetter("dishUid")
    public UUID getDishUid() {
        return dishUid;
    }

    @JsonGetter("category")
    public DishCategory getCategory() {
        return category;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("price")
    public Integer getPrice() {
        return price;
    }

    @JsonGetter("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonGetter("calories")
    public Double getCalories() {
        return calories;
    }

    @JsonGetter("proteins")
    public Double getProteins() {
        return proteins;
    }

    @JsonGetter("fats")
    public Double getFats() {
        return fats;
    }

    @JsonGetter("carbohydrates")
    public Double getCarbohydrates() {
        return carbohydrates;
    }

    @JsonGetter("canteenUid")
    public UUID getCanteenUid() {
        return canteenUid;
    }
}
