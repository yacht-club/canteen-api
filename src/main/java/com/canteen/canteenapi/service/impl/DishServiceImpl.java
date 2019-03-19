package com.canteen.canteenapi.service.impl;

import com.canteen.canteenapi.converter.ModelConverter;
import com.canteen.canteenapi.exception.DishNotFoundException;
import com.canteen.canteenapi.model.entity.DishCategoryEntity;
import com.canteen.canteenapi.model.entity.DishEntity;
import com.canteen.canteenapi.model.request.AddDishRequest;
import com.canteen.canteenapi.model.request.DishFilterRequest;
import com.canteen.canteenapi.model.request.UpdateDishRequest;
import com.canteen.canteenapi.model.response.DishCategoryInfo;
import com.canteen.canteenapi.model.response.DishInfo;
import com.canteen.canteenapi.repository.DishCategoryRepository;
import com.canteen.canteenapi.repository.DishRepository;
import com.canteen.canteenapi.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    private final static Logger logger = LoggerFactory.getLogger(DishServiceImpl.class);

    private final DishRepository dishRepository;
    private final DishCategoryRepository dishCategoryRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, DishCategoryRepository dishCategoryRepository) {
        this.dishRepository = dishRepository;
        this.dishCategoryRepository = dishCategoryRepository;
    }

    @Override
    public List<DishInfo> getAllDishes() {
        return dishRepository.findAll()
                .stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<DishInfo> getAllDishes(DishFilterRequest dishFilterRequest) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<DishEntity> example = Example.of(ModelConverter.convert(dishFilterRequest), matcher);

        return dishRepository.findAll(example)
                .stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public DishInfo getDish(UUID dishUid) {
        return dishRepository.findByDishUid(dishUid)
                .map(ModelConverter::convert)
                .orElseThrow(() -> {
                    logger.warn("Dish not found with uid: {}", dishUid);
                    return new DishNotFoundException("Dish not found with uid: " + dishUid);
                });
    }

    @Override
    public UUID addDish(AddDishRequest request) {
        return dishRepository.save(ModelConverter.convert(request)).getDishUid();
    }

    @Override
    public void updateDish(UpdateDishRequest request) {
        DishEntity entity = dishRepository.findByDishUid(request.getDishUid())
                .map(it -> it.copy(ModelConverter.convert(request)))
                .orElseThrow(() -> {
                    logger.warn("Dish not found with uid: {}", request.getDishUid());
                    return new DishNotFoundException("Dish not found with uid: " + request.getDishUid());
                });

        dishRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteDish(UUID dishUid) {
        dishRepository.deleteByDishUid(dishUid);
    }

    public List<DishCategoryInfo> getAllCategories() {
        return dishCategoryRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(DishCategoryEntity::getOrder))
                .map(ModelConverter::convert)
                .collect(Collectors.toList());
    }
}
