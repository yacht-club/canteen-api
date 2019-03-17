package com.canteen.canteenapi.repository;

import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.entity.DishCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCategoryRepository extends JpaRepository<DishCategoryEntity, DishCategory> {
}
