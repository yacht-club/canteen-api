package com.canteen.canteenapi.service;

import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.request.AddDishRequest;
import com.canteen.canteenapi.model.request.UpdateDishRequest;
import com.canteen.canteenapi.model.response.DishInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DishService {

    Page<DishInfo> getAllDishes(Pageable pageable);

    Page<DishInfo> getAllDishesByCategory(Pageable pageable, DishCategory category);

    DishInfo getDish(UUID dishUid);

    UUID addDish(AddDishRequest request);

    void updateDish(UpdateDishRequest request);

    void deleteDish(UUID dishUid);

}
