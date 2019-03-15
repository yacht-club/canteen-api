package com.canteen.canteenapi.service;

import com.canteen.canteenapi.model.request.AddCanteenRequest;
import com.canteen.canteenapi.model.request.UpdateCanteenRequest;
import com.canteen.canteenapi.model.response.CanteenInfo;

import java.util.List;
import java.util.UUID;

public interface CanteenService {

    List<CanteenInfo> getAllCanteens();

    CanteenInfo getCanteen(UUID canteenUid);

    UUID addCanteen(AddCanteenRequest request);

    void updateCanteen(UpdateCanteenRequest request);

    void deleteCanteen(UUID canteenUid);
}
