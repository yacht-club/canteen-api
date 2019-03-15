package com.canteen.canteenapi.model.response;

import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.entity.CanteenEntity;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Set;
import java.util.UUID;

public class DishInfo {

    private UUID dishUid;
    private Set<CanteenEntity> canteens;
    private DishCategory category;
    private String name;
    private Integer price;
    private Integer weight;
    private Double calories;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;

    public DishInfo(
            UUID dishUid,
            Set<CanteenEntity> canteens,
            DishCategory category,
            String name,
            Integer price,
            Integer weight,
            Double calories,
            Double proteins,
            Double fats,
            Double carbohydrates) {
        this.dishUid = dishUid;
        this.canteens = canteens;
        this.category = category;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    @JsonGetter("dishUid")
    public UUID getDishUid() {
        return dishUid;
    }

    @JsonGetter("canteens")
    public Set<CanteenEntity> getCanteens() {
        return canteens;
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
}
