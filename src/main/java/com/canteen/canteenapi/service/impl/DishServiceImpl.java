package com.canteen.canteenapi.service.impl;

import com.canteen.canteenapi.converter.ModelConverter;
import com.canteen.canteenapi.exception.DishNotFoundException;
import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.entity.DishEntity;
import com.canteen.canteenapi.model.request.AddDishRequest;
import com.canteen.canteenapi.model.request.UpdateDishRequest;
import com.canteen.canteenapi.model.response.DishInfo;
import com.canteen.canteenapi.repository.DishRepository;
import com.canteen.canteenapi.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    private final static Logger logger = LoggerFactory.getLogger(DishServiceImpl.class);

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Page<DishInfo> getAllDishes(Pageable pageable) {
        return new PageImpl<>(dishRepository.findAll(pageable)
                .stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList()));
    }

    @Override
    public Page<DishInfo> getAllDishesByCategory(Pageable pageable, DishCategory category) {
        return new PageImpl<>(dishRepository.findAllByCategory(pageable, category)
                .stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList()));
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
}
