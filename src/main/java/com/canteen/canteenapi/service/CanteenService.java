package com.canteen.canteenapi.service;

import com.canteen.canteenapi.model.request.AddCanteenRequest;
import com.canteen.canteenapi.model.request.UpdateCanteenRequest;
import com.canteen.canteenapi.model.response.CanteenInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CanteenService {

    Page<CanteenInfo> getAllCanteens(Pageable pageable);

    CanteenInfo getCanteen(UUID canteenUid);

    UUID addCanteen(AddCanteenRequest request);

    void updateCanteen(UpdateCanteenRequest request);

    void deleteCanteen(UUID canteenUid);

}
