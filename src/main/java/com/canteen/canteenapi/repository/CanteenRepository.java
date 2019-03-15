package com.canteen.canteenapi.repository;

import com.canteen.canteenapi.model.entity.CanteenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CanteenRepository extends JpaRepository<CanteenEntity, Integer> {


    Optional<CanteenEntity> findByCanteenUid(UUID canteenUid);

    void deleteByCanteenUid(UUID canteenUid);
}
