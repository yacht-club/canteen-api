package com.canteen.canteenapi.model.request;

import com.canteen.canteenapi.model.entity.DishEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

public class AddCanteenRequest {

    @NotBlank
    @ApiModelProperty(example = "Canteen Name")
    private String name;

    @NotBlank
    @ApiModelProperty(example = "Canteen Location")
    private String location;

    @NotNull
    private Instant workFromMillis;

    @NotNull
    private Instant workTillMillis;

    @NotNull
    private Set<DishEntity> dishes;

    public AddCanteenRequest(
            @JsonProperty("name") String name,
            @JsonProperty("location") String location,
            @JsonProperty("workFromMillis") Instant workFromMillis,
            @JsonProperty("workTillMillis") Instant workTillMillis,
            @JsonProperty("dishes") Set<DishEntity> dishes) {
        this.name = name;
        this.location = location;
        this.workFromMillis = workFromMillis;
        this.workTillMillis = workTillMillis;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Instant getWorkFromMillis() {
        return workFromMillis;
    }

    public Instant getWorkTillMillis() {
        return workTillMillis;
    }

    public Set<DishEntity> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
