package com.canteen.canteenapi.converter;

import com.canteen.canteenapi.model.entity.CanteenEntity;
import com.canteen.canteenapi.model.entity.DishCategoryEntity;
import com.canteen.canteenapi.model.entity.DishEntity;
import com.canteen.canteenapi.model.request.AddCanteenRequest;
import com.canteen.canteenapi.model.request.AddDishRequest;
import com.canteen.canteenapi.model.request.DishFilterRequest;
import com.canteen.canteenapi.model.request.UpdateCanteenRequest;
import com.canteen.canteenapi.model.request.UpdateDishRequest;
import com.canteen.canteenapi.model.response.CanteenInfo;
import com.canteen.canteenapi.model.response.DishCategoryInfo;
import com.canteen.canteenapi.model.response.DishInfo;

public class ModelConverter {

    public static CanteenEntity convert(AddCanteenRequest request) {
        return new CanteenEntity()
                .setLocation(request.getLocation())
                .setName(request.getName())
                .setWorkFromMillis(request.getWorkFromMillis())
                .setWorkTillMillis(request.getWorkTillMillis());
    }

    public static CanteenEntity convert(UpdateCanteenRequest request) {
        return new CanteenEntity()
                .setCanteenUid(request.getCanteenUid())
                .setLocation(request.getLocation())
                .setName(request.getName())
                .setWorkFromMillis(request.getWorkFromMillis())
                .setWorkTillMillis(request.getWorkTillMillis());
    }

    public static DishEntity convert(AddDishRequest request) {
        return new DishEntity()
                .setCalories(request.getCalories())
                .setCarbohydrates(request.getCarbohydrates())
                .setCategory(request.getCategory())
                .setFats(request.getFats())
                .setName(request.getName())
                .setPrice(request.getPrice())
                .setWeight(request.getWeight())
                .setProteins(request.getProteins());
    }

    public static DishEntity convert(UpdateDishRequest request) {
        return new DishEntity()
                .setDishUid(request.getDishUid())
                .setCalories(request.getCalories())
                .setCarbohydrates(request.getCarbohydrates())
                .setCategory(request.getCategory())
                .setFats(request.getFats())
                .setName(request.getName())
                .setPrice(request.getPrice())
                .setWeight(request.getWeight())
                .setProteins(request.getProteins());
    }

    public static CanteenInfo convert(CanteenEntity entity) {
        return new CanteenInfo(
                entity.getCanteenUid(),
                entity.getName(),
                entity.getBuilding(),
                entity.getLocation(),
                entity.getWorkFromMillis(),
                entity.getWorkTillMillis(),
                entity.getImageUrl());
    }

    public static DishInfo convert(DishEntity entity) {
        return new DishInfo(
                entity.getDishUid(),
                entity.getCategory(),
                entity.getName(),
                entity.getPrice(),
                entity.getWeight(),
                entity.getCalories(),
                entity.getProteins(),
                entity.getFats(),
                entity.getCarbohydrates(),
                entity.getCanteen().getCanteenUid());
    }

    public static DishEntity convert(DishFilterRequest dishFilterRequest) {
        CanteenEntity canteenEntity = new CanteenEntity()
                .setCanteenUid(dishFilterRequest.getCanteenUid());

        return new DishEntity()
                .setCategory(dishFilterRequest.getCategory())
                .setCanteen(canteenEntity);
    }

    public static DishCategoryInfo convert(DishCategoryEntity dishCategoryEntity) {
        return new DishCategoryInfo(
                dishCategoryEntity.getCategory(),
                dishCategoryEntity.getDescription());
    }
}
