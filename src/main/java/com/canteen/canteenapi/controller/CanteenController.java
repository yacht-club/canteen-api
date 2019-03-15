package com.canteen.canteenapi.controller;

import com.canteen.canteenapi.model.request.AddCanteenRequest;
import com.canteen.canteenapi.model.request.UpdateCanteenRequest;
import com.canteen.canteenapi.model.response.CanteenInfo;
import com.canteen.canteenapi.service.CanteenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/canteens", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CanteenController {

    private static final Logger logger = LoggerFactory.getLogger(CanteenController.class.getName());

    private CanteenService canteenService;

    @Autowired
    public CanteenController(CanteenService canteenService) {
        this.canteenService = canteenService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<CanteenInfo>> getAllCanteens(Pageable pageable) {
        logger.debug("Getting all canteens for page: {} and page size: {} ", pageable.getPageNumber(), pageable.getPageSize());

        return ResponseEntity.ok(canteenService.getAllCanteens(pageable));
    }

    @RequestMapping(path = "/{canteenUid}", method = RequestMethod.GET)
    public ResponseEntity<CanteenInfo> getCanteen(@PathVariable UUID canteenUid) {
        logger.debug("Getting canteen with uid: {} ", canteenUid);

        return ResponseEntity.ok(canteenService.getCanteen(canteenUid));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UUID> addCanteen(@RequestBody @Valid AddCanteenRequest request) {
        logger.debug("Adding canteen with name: {}", request.getName());

        return ResponseEntity.ok(canteenService.addCanteen(request));
    }

    @RequestMapping(method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> updateCanteen(@RequestBody @Valid UpdateCanteenRequest request) {
        logger.debug("Updating canteen with name: {}", request.getName());

        canteenService.updateCanteen(request);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{uuid}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCanteen(@PathVariable UUID uuid) {
        logger.debug("Deleting canteen with uid: {}", uuid);

        canteenService.deleteCanteen(uuid);
        return ResponseEntity.noContent().build();
    }


}
