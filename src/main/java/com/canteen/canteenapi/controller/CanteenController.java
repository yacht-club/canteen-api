package com.canteen.canteenapi.controller;

import com.canteen.canteenapi.model.request.AddCanteenRequest;
import com.canteen.canteenapi.model.request.UpdateCanteenRequest;
import com.canteen.canteenapi.model.response.CanteenInfo;
import com.canteen.canteenapi.service.CanteenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/canteens", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CanteenController {
    private static final Logger logger = LoggerFactory.getLogger(CanteenController.class);

    private final CanteenService canteenService;

    @Autowired
    public CanteenController(CanteenService canteenService) {
        this.canteenService = canteenService;
    }

    @GetMapping
    public ResponseEntity<List<CanteenInfo>> getAllCanteens() {
        logger.debug("Getting all canteens");

        return ResponseEntity.ok(canteenService.getAllCanteens());
    }

    @GetMapping("/{canteenUid}")
    public ResponseEntity<CanteenInfo> getCanteen(@PathVariable UUID canteenUid) {
        logger.debug("Getting canteen with uid: {} ", canteenUid);

        return ResponseEntity.ok(canteenService.getCanteen(canteenUid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UUID> addCanteen(@RequestBody @Valid AddCanteenRequest request) {
        logger.debug("Adding canteen with name: {}", request.getName());

        return ResponseEntity.ok(canteenService.addCanteen(request));
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updateCanteen(@RequestBody @Valid UpdateCanteenRequest request) {
        logger.debug("Updating canteen with name: {}", request.getName());

        canteenService.updateCanteen(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{canteenUid}")
    public ResponseEntity<Void> deleteCanteen(@PathVariable UUID canteenUid) {
        logger.debug("Deleting canteen with uid: {}", canteenUid);

        canteenService.deleteCanteen(canteenUid);
        return ResponseEntity.noContent().build();
    }
}
