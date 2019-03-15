package com.canteen.canteenapi.service.impl;

import com.canteen.canteenapi.converter.ModelConverter;
import com.canteen.canteenapi.exception.CanteenNotFoundException;
import com.canteen.canteenapi.model.entity.CanteenEntity;
import com.canteen.canteenapi.model.request.AddCanteenRequest;
import com.canteen.canteenapi.model.request.UpdateCanteenRequest;
import com.canteen.canteenapi.model.response.CanteenInfo;
import com.canteen.canteenapi.repository.CanteenRepository;
import com.canteen.canteenapi.service.CanteenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CanteenServiceImpl implements CanteenService {

    private final static Logger logger = LoggerFactory.getLogger(CanteenServiceImpl.class);

    private CanteenRepository canteenRepository;

    public CanteenServiceImpl(CanteenRepository canteenRepository) {
        this.canteenRepository = canteenRepository;
    }

    @Override
    public Page<CanteenInfo> getAllCanteens(Pageable pageable) {
        return new PageImpl<>(canteenRepository.findAll(pageable)
                .stream()
                .map(ModelConverter::convert)
                .collect(Collectors.toList()));
    }

    @Override
    public CanteenInfo getCanteen(UUID canteenUid) {
        return ModelConverter.convert(canteenRepository.findByCanteenUid(canteenUid).orElseThrow(() -> {
            logger.info("Canteen not found with uid: {}", canteenUid);
            return new CanteenNotFoundException("Canteen not found with uid:" + canteenUid);
        }));
    }

    @Override
    public UUID addCanteen(AddCanteenRequest request) {
        return canteenRepository.save(ModelConverter.convert(request)).getCanteenUid();
    }

    @Override
    public void updateCanteen(UpdateCanteenRequest request) {
        CanteenEntity entity = canteenRepository.findByCanteenUid(request.getCanteenUid()).orElseThrow(() -> {
            logger.info("Canteen not found with uid: {}", request.getCanteenUid());
            return new CanteenNotFoundException("Canteen not found with uid:" + request.getCanteenUid());
        });

        entity.copy(ModelConverter.convert(request));
        canteenRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteCanteen(UUID canteenUid) {
        canteenRepository.deleteByCanteenUid(canteenUid);
    }
}
