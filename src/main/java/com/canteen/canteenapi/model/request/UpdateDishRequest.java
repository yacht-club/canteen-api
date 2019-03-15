package com.canteen.canteenapi.model.request;

import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.entity.CanteenEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public class UpdateDishRequest {

    @NotNull
    @ApiModelProperty(example = "8152e3f9-449f-44c1-9d3a-e3c6f1afd752")
    private UUID dishUid;

    @NotNull
    private Set<CanteenEntity> canteens;

    @NotNull
    private DishCategory category;

    @NotBlank
    @ApiModelProperty(example = "Canteen Name")
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer weight;

    @NotNull
    private Double calories;

    @NotNull
    private Double proteins;

    @NotNull
    private Double fats;

    @NotNull
    private Double carbohydrates;

    @JsonCreator
    public UpdateDishRequest(
            @JsonProperty("dishUid") UUID dishUid,
            @JsonProperty("canteens") Set<CanteenEntity> canteens,
            @JsonProperty("category") DishCategory category,
            @JsonProperty("name") String name,
            @JsonProperty("price") Integer price,
            @JsonProperty("weight") Integer weight,
            @JsonProperty("calories") Double calories,
            @JsonProperty("proteins") Double proteins,
            @JsonProperty("fats") Double fats,
            @JsonProperty("carbohydrates") Double carbohydrates) {
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

    public UUID getDishUid() {
        return dishUid;
    }

    public Set<CanteenEntity> getCanteens() {
        return canteens;
    }

    public DishCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getProteins() {
        return proteins;
    }

    public Double getFats() {
        return fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}