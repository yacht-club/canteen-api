package com.canteen.canteenapi.repository;

import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Integer> {
    Page<DishEntity> findAllByCategory(Pageable pageable, DishCategory category);

    Optional<DishEntity> findByDishUid(UUID dishUid);

    void deleteByDishUid(UUID dishUid);
}
