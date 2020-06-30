package com.tlh.bms.service.impl;

import com.tlh.bms.data.RoomPriceRepository;
import com.tlh.bms.data.entities.RoomCategoryPrice;
import com.tlh.bms.service.RoomPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RoomPricingServiceImpl implements RoomPricingService {

    @Autowired
    private RoomPriceRepository roomPriceRepository;

    @Override
    public Map<Long, RoomCategoryPrice> getPrices(Long hotel) {
        return roomPriceRepository.findByHotel(hotel).stream().collect(Collectors.toMap(RoomCategoryPrice::getRoomCategory, Function.identity()));
    }

    @Override
    public RoomCategoryPrice getByHotelAndRoomCategory(Long hotel, Long category) {
        return roomPriceRepository.findByHotelAndRoomCategory(hotel, category);
    }
}
