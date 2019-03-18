package com.canteen.canteenapi.controller;

import com.canteen.canteenapi.model.DishCategory;
import com.canteen.canteenapi.model.request.AddDishRequest;
import com.canteen.canteenapi.model.request.DishFilterRequest;
import com.canteen.canteenapi.model.request.UpdateDishRequest;
import com.canteen.canteenapi.model.response.DishCategoryInfo;
import com.canteen.canteenapi.model.response.DishInfo;
import com.canteen.canteenapi.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/dishes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DishController {
    private static final Logger logger = LoggerFactory.getLogger(DishController.class.getName());

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<DishCategoryInfo>> getCategories() {
        logger.debug("Getting all categories");

        // TODO implement
        return ResponseEntity.ok(dishService.getAllCategories());
    }

    @GetMapping
    public ResponseEntity<List<DishInfo>> getAllDishes() {
        logger.debug("Getting all dishes");

        return ResponseEntity.ok(dishService.getAllDishes());
    }

    @GetMapping("/{dishUid}")
    public ResponseEntity<DishInfo> getDish(@PathVariable UUID dishUid) {
        logger.debug("Getting dish with uid: {} ", dishUid);

        return ResponseEntity.ok(dishService.getDish(dishUid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UUID> addDish(@RequestBody @Valid AddDishRequest request) {
        logger.debug("Adding dish with name: {}", request.getName());

        return ResponseEntity.ok(dishService.addDish(request));
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updateDish(@RequestBody @Valid UpdateDishRequest request) {
        logger.debug("Updating dish with name: {}", request.getName());

        dishService.updateDish(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{dishUid}")
    public ResponseEntity<Void> deleteDish(@PathVariable UUID dishUid) {
        logger.debug("Deleting dish with uid: {}", dishUid);

        dishService.deleteDish(dishUid);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<DishInfo>> filterDish(@RequestBody @Valid DishFilterRequest dishFilterRequest) {
        logger.debug("Getting all dishes with filter: {}", dishFilterRequest);

        return ResponseEntity.ok(dishService.getAllDishes(dishFilterRequest));
    }
}
